/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport_management;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Sean Ng
 */
public class ATC {
    //===============Resources=================
    private boolean runwayOccupied = false;
    //gates:true = free
    private final boolean[] gates = new boolean[]{true, true, true}; //max 3
    private final Semaphore refuelTruck = new Semaphore(1, true);
    private boolean truckBusy = false;
    private int planesOnGround; //max 3
    private int emergencyPlanes = 0;
    
    //request for landing and find available gates
    public synchronized int requestLanding(int airplaneID, boolean isEmergency){
        System.out.println("Plane-" + airplaneID + ": Requesting to land. Emergency: " + isEmergency);
        if(isEmergency){
            emergencyPlanes ++;
        }
        //runway is occupied or airport is full / not emergency but there are other emergency planes
        //enter the loop to wait
        while((runwayOccupied || planesOnGround >= 3) || (!isEmergency && emergencyPlanes > 0 ))
        {
            try{
                System.out.println("ATC: Plane-" + airplaneID + " WAIT for landing. Airport/Runway is BUSY.");
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        if(isEmergency){
            emergencyPlanes --;
        }
        
        runwayOccupied = true;
        planesOnGround ++;
        
        int gateIdx = findAvailableGate(airplaneID);
        
        System.out.println("ATC: Landing permission GRANTED for Plane-" + airplaneID + " at Gate -" + (gateIdx + 1) + ".");
        return gateIdx;
    }
    
    public synchronized int findAvailableGate(int airplaneID){
        for(int i = 0; i < gates.length; i ++){
            if(gates[i]){
                gates[i] = false; 
                return i;
            }
        }
        return -1;
    }
    
    public synchronized void releaseGate(int gateID){
        gates[gateID] = true;
    }
    
    
    //release runway
    public synchronized void releaseRunway(int airplaneID){
        runwayOccupied = false;
        System.out.println("Plane-" + airplaneID + ": cleared runway");
        notifyAll();
        
    }
    
    public void useTruck(int airplaneID) throws InterruptedException{
        System.out.println("Plane-" + airplaneID + ": requesting for refuel truck.");
        refuelTruck.acquire();
        System.out.println("Plane-" + airplaneID + ": acquired refuel truck. Refueling...");
    }
    
    public void releaseTruck(int airplaneID) throws InterruptedException{
        refuelTruck.release();
        System.out.println("Plane-"+ airplaneID + ": finished refueling. refuel truck released.");
    }
    
    //occupy runway to leave
    public synchronized void requestTakeOff(int airplaneID, int gateID){
        while(runwayOccupied){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        
        runwayOccupied = true;
        gates[gateID] = true; //release gate
        System.out.println("ATC: Plane-" + airplaneID + " leaving Gate-" + (gateID + 1) + ". Cleared for take-off.");
    }
    
    public synchronized void leaveAirport(int airplaneID){
        runwayOccupied = false;
        planesOnGround --;
        System.out.println("Plane-" + airplaneID + ": left the airport. Runway is free.");
        notifyAll();
    }
    
    public boolean sanityCheck(){
        boolean allGatesEmpty = true;
        
        for(int i = 0; i < gates.length; i ++){
            if(!gates[i]){
                allGatesEmpty = false;
                System.out.println("ALERT: Gate- " + i + " is still occupied!");
            }
        }
        
        return allGatesEmpty;
    }
}

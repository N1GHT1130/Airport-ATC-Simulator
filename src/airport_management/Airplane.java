/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport_management;

/**
 *
 * @author Sean Ng
 */
public class Airplane implements Runnable{
    
    private final int airplaneID;
    private final boolean emergency;
    private final ATC atc;
    private final Statistics stat;
    
    public Airplane(int airplaneID, ATC atc,Statistics stat, boolean emergency){
        this.airplaneID = airplaneID;
        this.atc = atc;
        this.stat = stat;
        this.emergency = emergency;
    }
    
    @Override
    public void run(){
        try{
            long arrivalTime = System.currentTimeMillis();
            //request landing permission
            System.out.println("Plane-" + airplaneID + " has ARRIVED at the airport airspace.");
            int gateIdx = atc.requestLanding(airplaneID, emergency);
            
            //landing
            System.out.println("Plane-" + airplaneID + " is landing...");
            
            long waitTime = System.currentTimeMillis() - arrivalTime;
            Thread.sleep(1000);
            System.out.println("Plane-" + airplaneID + ": LANDED successfully.");
            
            //docking at the gate
            System.out.println("Plane-" + airplaneID + ": docking at Gate-" + (gateIdx + 1) + ".");
            atc.releaseRunway(airplaneID); //runway released
            
            //disembark, boarding, cleaning and refueling
            int boardingPax = 10 + (int)(Math.random() * 41);
            gateActivities(gateIdx, boardingPax);
            
            //request take off permission
            atc.requestTakeOff(airplaneID, gateIdx);
            System.out.println("Plane-" + airplaneID + ": taking off...");
            Thread.sleep(1000);
            
            //leave airport
            atc.leaveAirport(airplaneID);
            
            stat.addPlaneData(waitTime, boardingPax);
            
        }catch(InterruptedException e){
            System.out.println("Plane-" + airplaneID + "is interrupted!");
        }
        
        
    }
    
    public void gateActivities(int gateID, int boardingPax) throws InterruptedException{
        Object gateLock = new Object();
        System.out.println("Plane-" + airplaneID + ": at gate " + (gateID + 1) + ". Starting ground services...");
        
        Passenger pTask = new Passenger(airplaneID, boardingPax, gateLock);
        Thread passengers = new Thread(pTask);
        
        Thread refuel = new Thread(new FuelTruck(airplaneID, atc));
        
        Thread cleaning = new Thread(new Cleaning(airplaneID, gateLock, pTask));
        
        refuel.start();
        passengers.start();
        cleaning.start();
        
        refuel.join();
        passengers.join();
        cleaning.join();
        
        System.out.println("Plane-" + airplaneID + ": finished all gate activities.");
    
    }
    
    public int getAirplaneID(){
        return airplaneID;
    }
    
    public boolean isEmergency(){
        return emergency;
    }
    
}

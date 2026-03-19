/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport_management;

/**
 *
 * @author Sean Ng
 */
public class FuelTruck implements Runnable {
    private final int airplaneID;
    private final ATC atc;
    
    public FuelTruck(int airplaneID, ATC atc){
        this.airplaneID = airplaneID;
        this.atc = atc;
    }
    
    @Override
    public void run(){
        try{
            atc.useTruck(airplaneID);
            Thread.sleep(2000);
            atc.releaseTruck(airplaneID);
        }catch(InterruptedException e){
            System.out.println("Plane-" + airplaneID + ": Refueling Interrupted.");
        }
    }
        
}

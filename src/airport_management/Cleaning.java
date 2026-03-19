/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport_management;

/**
 *
 * @author Sean Ng
 */
public class Cleaning implements Runnable {
    private final int airplaneID;
    private final Object gateLock;
    private final Passenger pTask; //reference from passenger 
    
    public Cleaning(int airplaneID, Object gateLock, Passenger pTask){
        this.airplaneID = airplaneID;
        this.gateLock = gateLock;
        this.pTask = pTask;
    }
    
    public void run(){
        try{
            synchronized(gateLock){
                while(!pTask.getDisembarked()){ //if the passengers are not disembarked
                    gateLock.wait();
                }
            }
            System.out.println("Plane-" + airplaneID + ": Cleaning and refilling service ongoing...");
            Thread.sleep(2000);
            
            
            synchronized(gateLock){
                pTask.setCleaned(true);
                System.out.println("Plane-" + airplaneID + ": Cleaning and refilling service completed.");
                gateLock.notifyAll(); //finished cleaning, notify the passenger thread to continue boarding
            }
        }catch(InterruptedException e){
            System.out.println("Plane-"+ airplaneID + ": Cleaning and refilling service interrupted!");
        }
    }
}

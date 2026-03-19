/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport_management;

/**
 *
 * @author Sean Ng
 */
public class Passenger implements Runnable {
    private final int airplaneID;
    private final int boardingPax;
    private final Object gateLock; //lock for gate activities
    private boolean disembarked = false; //status to record passengers disembark
    private boolean cleaned = false; //status of planes cleaned 
    
    public Passenger(int airplaneID, int boardingPax, Object gateLock){
        this.airplaneID = airplaneID;
        this.boardingPax = boardingPax;
        this.gateLock = gateLock;
    }
    
    @Override
    public void run(){
        try{
            int passengerPax = (int)(Math.random() * 41);
            System.out.println("Plane-" + airplaneID + ": " + passengerPax + " passengers disembarking...");
            for(int i = 0; i <= passengerPax; i++){
                Thread.sleep(20);
            }
            
            synchronized(gateLock){ //to make sure passengers are disembarked first
                disembarked = true;
                System.out.println("Plane-" + airplaneID + ": passenger disembark completed.");
                gateLock.notifyAll();
            
                //if the plane is not cleaned, passenger should not be boarding
                while(!cleaned){ 
                    System.out.println("Plane-" + airplaneID + ": waiting for cleaning and supplies refilling.");
                    gateLock.wait();
                }
            }
            //passenger boarding 
            System.out.println("Plane-" + airplaneID + ": " + boardingPax + " passengers boarding...");
            for(int i = 0; i <= boardingPax; i ++){
                Thread.sleep(20); //spend random time according to no. of pax
            }
            System.out.println("Plane-" + airplaneID + ": passenger boarding completed.");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void setCleaned(boolean status){
        this.cleaned = status;
    }
    
    public boolean getDisembarked(){
        return disembarked;
    }
}

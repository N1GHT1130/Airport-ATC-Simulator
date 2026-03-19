/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airport_management;
import java.util.Random;
/**
 *
 * @author Sean Ng
 */
public class Airport_Management {

    public static void main(String[] args) {
        ATC atc = new ATC();
        Statistics stat = new Statistics();
        Random rand = new Random();
        
        Thread[] threads = new Thread[6];
        
        System.out.println("========== AIRPORT SIMULATION START ===========");
        
        //create threads for each airplane
        for(int i = 0; i < 6; i++){
            try{
                int arrivalDelay = rand.nextInt(2000);
                Thread.sleep(arrivalDelay);
                
                int planeID = i + 1;
                
                boolean isEmergency = (planeID == 5);
                
                Airplane plane = new Airplane(planeID, atc, stat, isEmergency);
                
                threads[i] = new Thread(plane);
            }catch(InterruptedException e){
                System.err.println("Generator interrupted!");
            }
        }
        
        //additional requirements: congested scenario
        try{
            //let two airplanes occupy the gates first
            threads[0].start();
            threads[1].start();

            Thread.sleep(1500);

            //then the other airplanes come in
            threads[2].start();
            threads[3].start();
            
            threads[4].start();//emergency airplane
            threads[5].start();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        
        //join all the threads to make sure all the threads end together
        for(int i = 0; i < threads.length; i++){
            try{
                if(threads[i] != null){
                    threads[i].join();
                }
            }catch(InterruptedException e){
                System.err.println("Join process interrupted.");
            }
        }
        
        System.out.println("========== AIRPORT SIMULATION ENDS ===========");
        boolean sanity = atc.sanityCheck();
        stat.displayReport(sanity);
    }
    
}

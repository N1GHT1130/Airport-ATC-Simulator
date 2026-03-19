/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport_management;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Sean Ng
 */
public class Statistics {
    private final AtomicInteger totalPlanes = new AtomicInteger(0);
    private final AtomicInteger totalPassengers = new AtomicInteger(0);
    private final AtomicLong totalWaitTime = new AtomicLong(0);
    private long minWait = Long.MAX_VALUE;
    private long maxWait = 0;
    
    public void addPlaneData(long waitTime, int noPassengers){
        
        totalPlanes.incrementAndGet();
        totalPassengers.addAndGet(noPassengers);
        totalWaitTime.addAndGet(waitTime);
        
        synchronized(this){
            if(waitTime < minWait) minWait = waitTime;
            if(waitTime > maxWait) maxWait = waitTime;
        }
        
    }
    
   
    
    public void displayReport(boolean sanity){
        System.out.println("========== STATISTICS ===========");
        System.out.println("Sanity Check: All Gates Empty");
        if(sanity){
            System.out.println(sanity + ": Sanity Check Passed.");
        }
        else{
            System.out.println(sanity + ": Sanity Check Failed.");
        }
        System.out.println("Total Planes Served     :" + totalPlanes.get());
        System.out.println("Total Passengers        :" + totalPassengers.get());
        System.out.println("Average Waiting Time    :" + (totalWaitTime.get() / totalPlanes.get()) + " ms");
        System.out.println("Min Waiting Time        :" + minWait + " ms");
        System.out.println("Max Waiting Time        :" + maxWait + " ms");
    }
}

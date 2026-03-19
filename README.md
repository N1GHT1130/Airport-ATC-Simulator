# Airport Concurrent Programming Simulation

## Overview
This project simulates an airport system using Java concurrency concepts.

## Features
- 1 runway control
- Maximum 3 planes on ground
- Gate management
- Refueling system (single truck)
- Emergency landing handling

## Concurrency Concepts Used
- Threads (Plane, ATC, Passenger)
- Synchronization
- Shared resources control
- Race condition prevention

## How to Run
1. Open in Apache NetBeans
2. Run Main class

## Sample Output
========== AIRPORT SIMULATION START ===========
Plane-2 has ARRIVED at the airport airspace.
Plane-1 has ARRIVED at the airport airspace.
Plane-2: Requesting to land. Emergency: false
ATC: Landing permission GRANTED for Plane-2 at Gate -1.
Plane-2 is landing...
Plane-1: Requesting to land. Emergency: false
ATC: Plane-1 WAIT for landing. Airport/Runway is BUSY.
Plane-2: LANDED successfully.
Plane-2: docking at Gate-1.
Plane-2: cleared runway
ATC: Landing permission GRANTED for Plane-1 at Gate -2.
Plane-1 is landing...
Plane-2: at gate 1. Starting ground services...
Plane-2: requesting for refuel truck.
Plane-2: 4 passengers disembarking...
Plane-2: acquired refuel truck. Refueling...
Plane-2: passenger disembark completed.
Plane-2: waiting for cleaning and supplies refilling.
Plane-2: Cleaning and refilling service ongoing...
Plane-3 has ARRIVED at the airport airspace.
Plane-3: Requesting to land. Emergency: false
Plane-4 has ARRIVED at the airport airspace.
ATC: Plane-3 WAIT for landing. Airport/Runway is BUSY.
Plane-5 has ARRIVED at the airport airspace.
Plane-6 has ARRIVED at the airport airspace.
Plane-4: Requesting to land. Emergency: false
ATC: Plane-4 WAIT for landing. Airport/Runway is BUSY.
Plane-6: Requesting to land. Emergency: false
ATC: Plane-6 WAIT for landing. Airport/Runway is BUSY.
Plane-5: Requesting to land. Emergency: true
ATC: Plane-5 WAIT for landing. Airport/Runway is BUSY.
Plane-1: LANDED successfully.
Plane-1: docking at Gate-2.
Plane-1: cleared runway
Plane-1: at gate 2. Starting ground services...
ATC: Plane-3 WAIT for landing. Airport/Runway is BUSY.
ATC: Landing permission GRANTED for Plane-5 at Gate -3.
Plane-5 is landing...
ATC: Plane-6 WAIT for landing. Airport/Runway is BUSY.
ATC: Plane-4 WAIT for landing. Airport/Runway is BUSY.
Plane-1: requesting for refuel truck.
Plane-1: 27 passengers disembarking...
Plane-1: passenger disembark completed.
Plane-1: waiting for cleaning and supplies refilling.
Plane-1: Cleaning and refilling service ongoing...
Plane-5: LANDED successfully.
Plane-5: docking at Gate-3.
Plane-5: cleared runway
Plane-5: at gate 3. Starting ground services...
ATC: Plane-3 WAIT for landing. Airport/Runway is BUSY.
ATC: Plane-4 WAIT for landing. Airport/Runway is BUSY.
ATC: Plane-6 WAIT for landing. Airport/Runway is BUSY.
Plane-5: requesting for refuel truck.
Plane-5: 34 passengers disembarking...
Plane-1: acquired refuel truck. Refueling...
Plane-2: finished refueling. refuel truck released.
Plane-2: Cleaning and refilling service completed.
Plane-2: 32 passengers boarding...
Plane-5: passenger disembark completed.
Plane-5: waiting for cleaning and supplies refilling.
Plane-5: Cleaning and refilling service ongoing...
Plane-2: passenger boarding completed.
Plane-2: finished all gate activities.
ATC: Plane-2 leaving Gate-1. Cleared for take-off.
Plane-2: taking off...
Plane-1: Cleaning and refilling service completed.
Plane-1: 13 passengers boarding...
Plane-2: left the airport. Runway is free.
ATC: Landing permission GRANTED for Plane-3 at Gate -1.
Plane-3 is landing...
ATC: Plane-6 WAIT for landing. Airport/Runway is BUSY.
ATC: Plane-4 WAIT for landing. Airport/Runway is BUSY.
Plane-1: passenger boarding completed.
Plane-1: finished refueling. refuel truck released.
Plane-5: acquired refuel truck. Refueling...
Plane-1: finished all gate activities.
Plane-5: Cleaning and refilling service completed.
Plane-5: 24 passengers boarding...
Plane-3: LANDED successfully.
Plane-3: docking at Gate-1.
Plane-3: cleared runway
ATC: Plane-6 WAIT for landing. Airport/Runway is BUSY.
ATC: Plane-1 leaving Gate-2. Cleared for take-off.
Plane-1: taking off...
Plane-3: at gate 1. Starting ground services...
ATC: Plane-4 WAIT for landing. Airport/Runway is BUSY.
Plane-3: 20 passengers disembarking...
Plane-3: requesting for refuel truck.
Plane-3: passenger disembark completed.
Plane-3: waiting for cleaning and supplies refilling.
Plane-3: Cleaning and refilling service ongoing...
Plane-5: passenger boarding completed.
Plane-1: left the airport. Runway is free.
ATC: Landing permission GRANTED for Plane-6 at Gate -2.
Plane-6 is landing...
ATC: Plane-4 WAIT for landing. Airport/Runway is BUSY.
Plane-5: finished refueling. refuel truck released.
Plane-3: acquired refuel truck. Refueling...
Plane-5: finished all gate activities.
Plane-6: LANDED successfully.
Plane-6: docking at Gate-2.
Plane-6: cleared runway
ATC: Plane-4 WAIT for landing. Airport/Runway is BUSY.
ATC: Plane-5 leaving Gate-3. Cleared for take-off.
Plane-5: taking off...
Plane-6: at gate 2. Starting ground services...
Plane-6: requesting for refuel truck.
Plane-6: 5 passengers disembarking...
Plane-6: passenger disembark completed.
Plane-6: waiting for cleaning and supplies refilling.
Plane-6: Cleaning and refilling service ongoing...
Plane-3: Cleaning and refilling service completed.
Plane-3: 25 passengers boarding...
Plane-3: passenger boarding completed.
Plane-5: left the airport. Runway is free.
ATC: Landing permission GRANTED for Plane-4 at Gate -3.
Plane-4 is landing...
Plane-3: finished refueling. refuel truck released.
Plane-6: acquired refuel truck. Refueling...
Plane-3: finished all gate activities.
Plane-4: LANDED successfully.
Plane-4: docking at Gate-3.
Plane-4: cleared runway
Plane-4: at gate 3. Starting ground services...
ATC: Plane-3 leaving Gate-1. Cleared for take-off.
Plane-3: taking off...
Plane-4: requesting for refuel truck.
Plane-4: 10 passengers disembarking...
Plane-6: Cleaning and refilling service completed.
Plane-6: 27 passengers boarding...
Plane-4: passenger disembark completed.
Plane-4: waiting for cleaning and supplies refilling.
Plane-4: Cleaning and refilling service ongoing...
Plane-6: passenger boarding completed.
Plane-3: left the airport. Runway is free.
Plane-4: acquired refuel truck. Refueling...
Plane-6: finished refueling. refuel truck released.
Plane-6: finished all gate activities.
ATC: Plane-6 leaving Gate-2. Cleared for take-off.
Plane-6: taking off...
Plane-6: left the airport. Runway is free.
Plane-4: Cleaning and refilling service completed.
Plane-4: 24 passengers boarding...
Plane-4: passenger boarding completed.
Plane-4: finished refueling. refuel truck released.
Plane-4: finished all gate activities.
ATC: Plane-4 leaving Gate-3. Cleared for take-off.
Plane-4: taking off...
Plane-4: left the airport. Runway is free.
========== AIRPORT SIMULATION ENDS ===========
========== STATISTICS ===========
Sanity Check: All Gates Empty
true: Sanity Check Passed.
Total Planes Served     :6
Total Passengers        :145
Average Waiting Time    :2912 ms
Min Waiting Time        :12 ms
Max Waiting Time        :7315 ms

## Author
Ng Guan Yik

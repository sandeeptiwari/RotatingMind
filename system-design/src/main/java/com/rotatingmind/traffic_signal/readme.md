Requirements
    
    Traffic Light States: The traffic light system should have three states - Red, Yellow, and Green.
    
    Timing Mechanism: Each light should have a specific duration for which it stays active.
    
    Transition Logic: The system should transition between lights based on timing.
    
    Pedestrian Signals: Optionally, the system should include pedestrian signals with their own states and timing.
    
    Sensor Integration: Optionally, the system should respond to traffic sensors to adjust timings dynamically.
   
    Control Interface: There should be a control interface to start, stop, and reset the traffic light system.
    
    Emergency Mode: The system should support an emergency mode where all lights turn red.
Pojos:

   - TrafficLightState
     a. Represents the state of a traffic light (Red, Yellow, Green).
     b. Has a duration for each state.
   
   - TrafficLight
     a. Represents a traffic light.
     b. Has an identifier and a current state.
     c. Can change its state based on the timer.
   
   - TrafficController
     a. Contains multiple traffic lights.
     b. Coordinates the state changes of traffic lights.
   
   - Timer:
     a. Responsible for triggering state changes at regular intervals.
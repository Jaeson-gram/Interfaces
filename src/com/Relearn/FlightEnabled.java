package com.Relearn;

enum FlightStages implements Trackable{
    LOADED,
    EN_ROUTE,
    DESTINATION,
    RE_EN_ROUTE;

    @Override
    public void track() {
        if (this.equals(LOADED)){
            System.out.println("Loaded! waiting to track route!");
        }
        else if (this.equals(DESTINATION)){
            System.out.println("In destination!");
        }
        else if (this.equals(EN_ROUTE) || this.equals(RE_EN_ROUTE)){
            System.out.println("Vehicle en-route. co-ordinates gotten! recording patterns");
            System.out.println("Monitoring " + this + " stage");
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages = values();

        return allStages[(ordinal() + 1) % allStages.length]; //when it's the last stage -> 3, then return the last stage -> 3 % 3 = 0; ie, return 0
    }

} //enums can also implement interfaces

record DragonFly(String name, String locationOnEarth) implements FlightEnabled{

    @Override
    public void takeOff() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void land() {

    }
} //records can also implement interfaces

class Satellite implements OrbitEarth{

    FlightStages stage = FlightStages.LOADED;
    @Override
    public void orbit() {
        transition("Orbit Achieved!");
    }

    @Override
    public void takeOff() {
        transition("Taking Off!");
    }

    @Override
    public void fly() {
        orbit();
        transition("Collecting data on orbit!");
    }

    @Override
    public void land() {
        transition("Landing!");
    }

    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track(); //our enum type is trackable
    }
} //when a class implements an interface, (if the interfaces extends another interface) it must implement the methods of the parent interface too

interface OrbitEarth extends FlightEnabled{
    void orbit();

    //a private static will be accessed by either a public static method, a private non-static method, or a default method.
    //making it private and static will mean only method on the interface can call it.
    private static void log(String description){
        var today = new java.util.Date();

        System.out.println(today + " : " + description);
    }

    private void logStage(FlightStages stage, String description){
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition to " + nextStage);

        return nextStage;
    }
}  //An interface can also EXTEND the functionalities of another interface, and can do so for multiple interfaces

public interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();
    void fly();
    void land();

    //takes a stage and returns the currenet stage of the object.    -> THE 'default' KEYWORD MAKES IT AN EXTENSION METHOD
    default FlightStages transition(FlightStages stage){
//        System.out.println("transition not implemented on " + getClass().getName()); //an interface isn't a class, but we're just calling the getClass() and getName() of the class using it
//        //this means we want every class using it to implement it before using it. We can use this statement or just cause an error when used without implementing
//
//        return null;

        FlightStages nextStage = stage.getNextStage();
        System.out.println(getClass().getSimpleName() + " transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }


}

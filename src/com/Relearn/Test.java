package com.Relearn;

public class Test {

    public static void main(String[] args) {

        inFlight(new Jet());
        System.out.println("-".repeat(29));
//        OrbitEarth.log("Testing " + Satellite.class.getName());

        orbit(new Satellite());
    }

    private static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();

        flier.transition(FlightStages.EN_ROUTE);
        if (flier instanceof Trackable trackable)
            trackable.track();

        flier.land();
    }

    private static void orbit(OrbitEarth flier){
        flier.takeOff();
        System.out.println();

        flier.fly();
        System.out.println();

        flier.land();
        System.out.println();
    }


}

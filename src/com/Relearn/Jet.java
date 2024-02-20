package com.Relearn;

public class Jet implements FlightEnabled{

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " taking off!");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " en route!");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " landing!");
    }

    @Override
    public FlightStages transition(FlightStages stage) {
        return FlightEnabled.super.transition(stage);

//        System.out.println(getClass().getSimpleName() + "transitioning");
//        return FlightStages.EN_ROUTE;
    }
}

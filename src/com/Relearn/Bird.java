package com.Relearn;

public class Bird extends Animal implements FlightEnabled, Trackable{


    @Override
    void move() {
        System.out.println(getClass().getSimpleName() + " flapping wings... ");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " taking off...");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " flying...");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " landing... landed.");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s being tracked. Coordinates found: Somewhere in Ahoada, Rivers, Nigeria, Africa. Earth -> Paths are being recorded for live location and patterns");
    }
}

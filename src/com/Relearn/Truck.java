package com.Relearn;

public class Truck implements Trackable{

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s being tracked. Coordinates found: Somewhere in Ahoada, Rivers, Nigeria, Africa. Earth -> Paths are being recorded for live location and patterns");
    }
}

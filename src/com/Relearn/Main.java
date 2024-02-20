package com.Relearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Bird bird = new Bird();
//        Jet jet = new Jet();

        Animal animal = bird;                           // -> bird is an animal (abstract class)
        FlightEnabled flightEnabled = bird;             // -> bird is flight-enabled (interface)
        Trackable trackable = bird;                     // -> bird is trackable (interface)


        animal.move();
        System.out.println("=".repeat(23));

        flightEnabled.takeOff();
        flightEnabled.fly();
        flightEnabled.land();
        System.out.println("=".repeat(23));

        trackable.track();
        System.out.println("=".repeat(23));
        System.out.println("=".repeat(23));

        inFlight(bird);
        System.out.println("=".repeat(23));
        System.out.println("=".repeat(23));
        inFlight(new Jet());

        System.out.println("=".repeat(23));
        System.out.println("=".repeat(23));

        Trackable truck = new Truck();
        truck.track();

        System.out.println("=".repeat(23));        System.out.println("=".repeat(23));

        //      USING CONSTANTS OF AN INTERFACE
        double kmsTravelled = 100;
        double milesTransfered = kmsTravelled * flightEnabled.KM_TO_MILES;
        System.out.printf("The truck travelled %.2f km, or %.2f miles %n", kmsTravelled, milesTransfered);


        System.out.println("=".repeat(23));         System.out.println("=".repeat(23));

        //  BETTER TO USE THE INTERFACE TYPE (LIST) AS THE BASE

        List<FlightEnabled> list = new ArrayList<>(); //so an arraylist can go into a list, and this is the better option
        List<FlightEnabled> anotherlist = new LinkedList<>(); //so an arraylist can go into a list, and this is the better option

        takeOffFlier(list);
        flyFlier(list);
        landFlier(list);

        takeOffFlier(anotherlist);
        flyFlier(anotherlist);
        landFlier(anotherlist);
    }

    private static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();

        if (flier instanceof Trackable trackable)
            trackable.track();

        flier.land();
    }

    private static void enTrack(Trackable trackable) {
        trackable.track();

        if (trackable instanceof FlightEnabled flier){
            flier.takeOff();
            flier.fly();
            flier.land();
        }
    }

    private static void takeOffFlier(List<FlightEnabled> fliers){ //it's better to use List than (ArrayList, LinkedList, etc)
        for (FlightEnabled flier : fliers){
            flier.takeOff();
        }
    }

    private static void flyFlier(List<FlightEnabled> fliers){ //because any of those types (ArrayL..., LinkedL...) can go into the List interface type
        for (FlightEnabled flier : fliers){
            flier.takeOff();
        }
    }

    private static void landFlier(List<FlightEnabled> fliers){ //it makes the code more extensible and less stressful to modify (in most cases) when we don't use that specific type
        for (FlightEnabled flier : fliers){
            flier.takeOff();
        }
    }
}

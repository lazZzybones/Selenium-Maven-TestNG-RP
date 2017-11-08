package com.epam.framework.features.transavia.business_objects.factory;

import com.epam.framework.features.transavia.business_objects.Booking;
import com.epam.framework.features.transavia.business_objects.MultiTrip;
import com.epam.framework.features.transavia.business_objects.Trip;

public class StaticMethods {
    public static Booking createBooking(String flightNumber, String lastName, String flightDate){
        Booking booking = new Booking();
        booking.setFlightNumber(flightNumber);
        booking.setFlightDate(lastName);
        booking.setLastName(flightDate);
        return booking;
    }

    public static Trip createTrip(String depatureAirport, String arrivalAirport){
        Trip trip = new Trip();
        trip.setDepatureAirport(depatureAirport);
        trip.setArrivalAirport(arrivalAirport);
        return trip;
    }

    public static MultiTrip createMultiTrip(String depatureAirportFirst, String arrivalAirportFirst, String depatureAirportSecond, String arrivalAirportSecond){
        MultiTrip multiTrip = new MultiTrip();
        multiTrip.setDepatureAirportFirst(depatureAirportFirst);
        multiTrip.setArrivalAirportFirst(arrivalAirportFirst);
        multiTrip.setDepatureAirportSecond(depatureAirportSecond);
        multiTrip.setArrivalAirportSecond(arrivalAirportSecond);
        return multiTrip;
    }
}
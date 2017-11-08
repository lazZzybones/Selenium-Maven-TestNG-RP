package com.epam.framework.features.transavia.tests;

import com.epam.framework.features.transavia.business_objects.Booking;
import com.epam.framework.features.transavia.pages.BookingPage;
import com.epam.framework.features.transavia.pages.HomePage;
import com.epam.framework.features.transavia.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TimeArrivalTest extends BaseTest {

    private static final String FLIGHT_NUMBER = "MF8C9R";
    private static final String LAST_NAME = "kukharau";
    private static final String FLIGHT_DATE = "9 June 2016";
    private static final String ARRIVAL_TIME = "2016-06-09 23:35";
    private HomePage main;
    private LoginPage loginPage;
    private BookingPage bookingPage;
    private Booking booking;

    @BeforeMethod
    public void preConditionSetup(){
        booking = new Booking();
        booking.setFlightNumber(FLIGHT_NUMBER);
        booking.setLastName(LAST_NAME);
        booking.setFlightDate(FLIGHT_DATE);
    }

    @Test(description = "This TC check arrival time ")
    public void loginToAccAndCheckTimeArrive() {

        main = new HomePage(driver);
        loginPage = main.goToLoginPage();
        loginPage.setCredentials(booking);
        bookingPage = loginPage.viewBooking();
        assertEquals(bookingPage.getTimeArrival(), ARRIVAL_TIME);
    }
}
package com.epam.cleartrip.actions;

import com.epam.cleartrip.data.TripBooking;
import com.epam.cleartrip.pages.HomePage;
import com.epam.cleartrip.suitbase.BaseUtilityClearTrip;

public class HomePageAction extends BaseUtilityClearTrip {

	
	public boolean oneWayTrupBooking(TripBooking booking) {
		HomePage pageobj = new HomePage(getDriver());
		return pageobj.travelBooking(booking);		
	}
	
}

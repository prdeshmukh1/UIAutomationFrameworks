package com.cleartrip.ui.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import com.cleartrip.ui.pageobjects.actions.SearchFlightsResults;
import com.cleartrip.ui.utls.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchFlightsResultsStepDefs {

	public static List<String> onWardFlightDetails = new ArrayList<String>();
	public static List<String> returnFlightDetails = new ArrayList<String>();

	SearchFlightsResults searchFlightsResults = new SearchFlightsResults();

	@Then("^I wait For Results to Apper on the Screen$")
	public void i_wait_For_Results_to_Apper_on_the_Screen() throws Throwable {
		new CommonMethods().waitUntillElementPresent(searchFlightsResults.getDepartureFlightsList());
	}


	@Then("^I select (\\d+) Flight and (\\d+) flight to book tickets$")
	public void i_select_Flight_and_flight_to_book_tickets(int depart, int retr) throws Throwable {

//		String beforeSelect=new GetScreenShot().capture(SeleniumDriver.getDriver(), "beforeSelect");
//		Reporter.addScreenCaptureFromPath(beforeSelect, "Before selection of Flights");
		searchFlightsResults.clickToChooseDeparture_ReturnFlights(searchFlightsResults.getDepartureFlightsList(),
				searchFlightsResults.getReturnFlightsList(), depart, retr);
//		Reporter.addStepLog("After Selecting From and To Flights");
//		String AfterSelect=new GetScreenShot().capture(SeleniumDriver.getDriver(), "AfterSelect");
//		Reporter.addScreenCaptureFromPath(AfterSelect, "After selection of Flights");
	}


	@Then("^I read departure Flights (\\d+) rowData$")
	public void i_read_DepartureFlights_rowData(int row) throws Throwable {

		onWardFlightDetails = searchFlightsResults.getSelectedRowData(searchFlightsResults.getDepartureFlightsList(),
				row);
	}

	@Then("^I read Return Flights (\\d+) rowData$")
	public void i_read_ReturnFlights_rowData(int row) throws Throwable {

		returnFlightDetails = searchFlightsResults.getSelectedRowData(searchFlightsResults.getReturnFlightsList(), row);
	}


	@Then("^I Book the Tickets$")
	public void i_Book_Tickets() throws Throwable {
		searchFlightsResults.clickBookTikcetsButton();
		new CommonMethods().waitFor(20000);
//		String reivewPage=new GetScreenShot().capture(SeleniumDriver.getDriver(), "reivewPage");
//		Reporter.addScreenCaptureFromPath(reivewPage, "Checkout Page");
	}

	@Then("^I read ItenaryDetails$")
	public void i_Read_ItineraryDetails() throws Throwable {

//		new ItineraryPageActions().getOnwardJourneyFlightDetails();
//		new ItineraryPageActions().getReturnJourneyFlightDetails();
//		new ItineraryPageActions().verifyItineraryOnWardFlightDetails_With_SearchPageOnwardFlightDetails();
//		new ItineraryPageActions().verifyItineraryReturnFlightDetails_With_SearchPageRetunFlightDetails();
//		
	}

}

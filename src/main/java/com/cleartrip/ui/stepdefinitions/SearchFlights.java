package com.cleartrip.ui.stepdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchFlights {
	
	@Given("^I am on the Home Page \"([^\"]*)\" of cleartrip Website$")
	public void i_am_on_the_Home_Page_of_cleartrip_Website(String url) throws Throwable {
	   open
	}
	
	@Then("^I click on Flights Button$")
	public void i_click_on_Flights_Button() throws Throwable {
		//flightSearchPageActions.clickonFlights();
	}

	@Then("^I select RoundTrip radioButton$")
	public void i_select_RoundTrip_dropdown() throws Throwable {
		flightSearchPageActions.chooseToHaveRoundTripJourney();
	}
	
	@Then("^I enter \"([^\"]*)\" and \"([^\"]*)\" values$")
	public void i_enter_and_values(String from, String to) throws Throwable {
		flightSearchPageActions.enterSourceAs(from);
		flightSearchPageActions.selectTheFirstAvailableAutoCompleteOptionFromSource();
		flightSearchPageActions.enterDestinationAs(to);
		flightSearchPageActions.selectTheFirstAvailableAutoCompleteOptionFromDestination();
	}
	@Then("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String depart, String returndate) throws Throwable {
		flightSearchPageActions.enterDepartureDateAs(depart);
		flightSearchPageActions.enterReturnDateAs(returndate);
	}

	@Then("^I select \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_select_and(String adult, String child) throws Throwable {
		flightSearchPageActions.selectNumberOfAdults(adult);
		flightSearchPageActions.selectNumberOfChilds(child);
	    
	}
	
	@Then("^I click on Search Flights$")
	public void i_click_on_Search_Flights() throws Throwable {
	//	new CommonMethods().waitForElementToAppear(SeleniumDriver.getDriver(), "//*[@id='SearchBtn']");
		flightSearchPageActions.clickSearchButton();
	 
	}

}

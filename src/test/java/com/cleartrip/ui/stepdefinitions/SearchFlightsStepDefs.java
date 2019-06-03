package com.cleartrip.ui.stepdefinitions;

import com.cleartrip.ui.BaseTest;
import com.cleartrip.ui.pageobjects.actions.SearchFlights;
import com.cleartrip.ui.utls.CommonMethods;
import com.cleartrip.ui.utls.DriverUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchFlightsStepDefs extends BaseTest {
	SearchFlights searchflights = new SearchFlights();

	@Given("^I am on the Home Page \"([^\"]*)\" of cleartrip Website$")
	public void i_am_on_the_Home_Page_of_cleartrip_Website(String url) {
		driver.get(url);
	}

	@Then("^I click on Flights Button$")
	public void i_click_on_Flights_Button() {
//		searchflights.clickonFlights();
		
	}

	@Then("^I select RoundTrip radioButton$")
	public void i_select_RoundTrip_dropdown() {
		searchflights.chooseToHaveRoundTripJourney();

	}

	@Then("^I enter \"([^\"]*)\" and \"([^\"]*)\" values$")
	public void i_enter_and_values(String from, String to) throws InterruptedException {
		searchflights.enterFromAs(from);
//		searchflights.selectTheFirstAvailableAutoCompleteOptionFromSource();
		searchflights.enterToAs(to);
//		searchflights.selectTheFirstAvailableAutoCompleteOptionFromDestination();
	}

	@Then("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String depart, String returndate) throws Throwable {
		searchflights.enterDepartureDateAs(depart);
		searchflights.enterReturnDateAs(returndate);
	}

	@Then("^I select \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_select_and(String adult, String child) throws Throwable {
		searchflights.selectNumberOfAdults(adult);
		searchflights.selectNumberOfChilds(child);

	}

	@Then("^I click on Search Flights$")
	public void i_click_on_Search_Flights() throws Throwable {
		new CommonMethods().waitForElementToAppear(DriverUtil.getDriver(), "//*[@id='SearchBtn']");
		searchflights.clickSearchButton();

	}

}

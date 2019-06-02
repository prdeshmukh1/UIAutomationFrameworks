package com.cleartrip.ui.pageobjects.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchFlightsLocators {

	@FindBy(xpath = "//ul[@class='navGroup productNav withArrows']/li/a[@href='/flights']")
	public WebElement searchPage_FlightsBtn;

	@FindBy(how = How.ID, using = "RoundTrip")
	public WebElement searchPage_RoundTripRadioBtn;

	@FindBy(id = "FromTag")
	public WebElement searchPage_FromTag;

	@FindBy(id = "ToTag")
	public WebElement searchPage_ToTag;

	@FindBy(id = "DepartDate")
	public WebElement searchPage_DepartDate;

	@FindBy(id = "ReturnDate")
	public WebElement searchPage_ReturnDate;

	@FindBy(css = "#Adults")
	public WebElement searchPage_Adults;

	@FindBy(css = "#Childrens")
	public WebElement searchPage_Children;

	@FindBy(css = "#SearchBtn")
	public WebElement searchPage_SearchBtn;
	
}

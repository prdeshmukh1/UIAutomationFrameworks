package com.cleartrip.ui.pageobjects.actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.cleartrip.ui.pageobjects.locators.SearchFlightsLocators;
import com.google.common.base.Function;

import env.DriverUtil;

public class SearchFlights {

	SearchFlightsLocators searchFlightsLocators = null;

	public SearchFlights() {
		searchFlightsLocators = new SearchFlightsLocators();
		PageFactory.initElements(DriverUtil.getDriver(), searchFlightsLocators);
	}

	public void clickonFlights() {
		try {
			Thread.sleep(20000);
			searchFlightsLocators.searchPage_FlightsBtn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void chooseToHaveRoundTripJourney() {
		searchFlightsLocators.searchPage_RoundTripRadioBtn.click();
	}

	public void enterFromAs(String destination) {
		searchFlightsLocators.searchPage_FromTag.clear();
		searchFlightsLocators.searchPage_FromTag.sendKeys(destination);
	}

	public void enterToAs(String origin) {
		searchFlightsLocators.searchPage_ToTag.clear();
		searchFlightsLocators.searchPage_ToTag.sendKeys(origin);
	}

	public void enterDepartureDateAs(String date) {
		searchFlightsLocators.searchPage_DepartDate.clear();
		searchFlightsLocators.searchPage_DepartDate.sendKeys(date);
	}

	public void enterReturnDateAs(String date) {
		searchFlightsLocators.searchPage_ReturnDate.clear();
		searchFlightsLocators.searchPage_ReturnDate.sendKeys(date);
		DriverUtil.getDriver()
				.findElement(By.xpath("//*[@class='monthBlock last']//a[text()='" + date.split("/")[0] + "'] "))
				.click();
	}

	public void selectNumberOfAdults(String adults) {
		Select select = new Select(searchFlightsLocators.searchPage_Adults);
		select.selectByValue(adults);
	}

	public void selectNumberOfChilds(String childs) {
		Select select = new Select(searchFlightsLocators.searchPage_Children);
		select.selectByValue(childs);
	}

	public void clickSearchButton() throws InterruptedException {
		searchFlightsLocators.searchPage_SearchBtn.click();
		Thread.sleep(6000);
		clickDepartFlightPriceInDesc();
	}

	public void clickDepartFlightPriceInDesc() {
		List<WebElement> elements = DriverUtil.getDriver().findElements(By.xpath("//a[text()='Price']"));
		System.err.println("count:" + elements.size());
		System.err.println(elements.get(0).getAttribute("class"));
		System.err.println(elements.get(1).getAttribute("class"));
		if (elements.get(0).getAttribute("class").equalsIgnoreCase("current sortAsc"))
			elements.get(0).click();
		if (elements.get(1).getAttribute("class").equalsIgnoreCase("current sortAsc"))
			elements.get(1).click();

	}

	public void selectTheFirstAvailableAutoCompleteOptionFromSource() throws InterruptedException {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverUtil.getDriver()).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement optionListElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("#ui-id-1"));
			}
		});

		// select the first item from the auto complete list
		List<WebElement> originOptions = optionListElement.findElements(By.tagName("li"));	
		originOptions.get(0).click();
	}

	public void selectTheFirstAvailableAutoCompleteOptionFromDestination() {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverUtil.getDriver()).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement optionListElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("#ui-id-2"));
			}
		});

		// select the first item from the auto complete list
		WebElement originOptionsElement = optionListElement;
		List<WebElement> originOptions = originOptionsElement.findElements(By.tagName("li"));
		originOptions.get(0).click();
	}

}

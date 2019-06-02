package com.cleartrip.ui.utls;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import env.DriverUtil;

// Making it final class, so that other class should not extend from it.
public final class CommonMethods {

	public void waitForElementToAppear(WebDriver driver, String loc) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loc)));

	}

	public void waitFortextToBePresentInElement(WebDriver driver, WebElement element, String text) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));

	}

	public WebElement waitUntillElementPresent(final WebElement element) {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverUtil.getDriver()).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});

	}

	public void waitFor(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean isAlertPresent() {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), 20 /* timeout in seconds */);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	public static boolean isElementPresent(WebElement webElement) {
		try {
			boolean isPresent = webElement.isDisplayed();
			return isPresent;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

}

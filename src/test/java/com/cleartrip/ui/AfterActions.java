package com.cleartrip.ui;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cleartrip.ui.utls.DriverUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class AfterActions {

	@After
	public static void tearDown(Scenario scenario) {

		WebDriver driver = DriverUtil.getDriver();
		System.out.println(scenario.isFailed());
		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
		}
		DriverUtil.closeDriver();
	}
}

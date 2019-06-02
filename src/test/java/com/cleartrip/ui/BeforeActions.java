package com.cleartrip.ui;

import cucumber.api.java.Before;
import env.DriverUtil;

public class BeforeActions {

	@Before
	public static void setUp() {
		// ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		System.out.println("========================== Before =========================================");

		DriverUtil.getDriver();
	}
}

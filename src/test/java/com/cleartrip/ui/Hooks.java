package com.cleartrip.ui;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before(order = 1)
	public void beforeScenario(Scenario scenario) {
//		System.out.println("In hooks");
//		System.out.println(scenario.getName());
//		System.out.println(scenario.getStatus());
	}
}

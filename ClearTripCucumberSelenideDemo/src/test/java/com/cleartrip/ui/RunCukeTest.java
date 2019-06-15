package com.cleartrip.ui;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumberHtmlReport"},
		//pretty:target/cucumber-json-report.json
		features = "classpath:features",
		glue = {"com.cleartrip.ui.stepdefinitions"}
)

public class RunCukeTest {
}

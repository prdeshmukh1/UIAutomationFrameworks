package com.cleartrip.ui.stepdefinitions;

import com.cleartrip.ui.utls.DriverUtil;

import cucumber.api.java.en.Then;

public class BrowserRelatedStepDefs {

	@Then("^I close browser$")
	public void i_close_browser() throws Throwable {
		DriverUtil.closeDriver();
	}

	// Step to navigate to specified URL
	@Then("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link) {
//			navigationObj.navigateTo(link);
	}

	// Step to navigate forward
	@Then("^I navigate forward")
	public void navigate_forward() {
//			navigationObj.navigate("forward");
	}

	// Step to navigate backward
	@Then("^I navigate back")
	public void navigate_back() {
//			navigationObj.navigate("back");
	}

	// steps to refresh page
	@Then("^I refresh page$")
	public void refresh_page() {
		DriverUtil.getDriver().navigate().refresh();
	}

	// Switch between windows

	// Switch to new window
	@Then("^I switch to new window$")
	public void switch_to_new_window() {
//			navigationObj.switchToNewWindow();
	}

	// Switch to old window
	@Then("^I switch to previous window$")
	public void switch_to_old_window() {
//			navigationObj.switchToOldWindow();
	}

	// Switch to new window by window title
	@Then("^I switch to window having title \"(.*?)\"$")
	public void switch_to_window_by_title(String windowTitle) throws Exception {
//			navigationObj.switchToWindowByTitle(windowTitle);
	}

	// Close new window
	@Then("^I close new window$")
	public void close_new_window() {
//			navigationObj.closeNewWindow();
	}

	// Switch between frame

	// Step to switch to frame by web element
	@Then("^I switch to frame having (.+) \"(.*?)\"$")
	public void switch_frame_by_element(String method, String value) {
//			navigationObj.switchFrame(method, value);
	}

	// step to switch to main content
	@Then("^I switch to main content$")
	public void switch_to_default_content() {
		DriverUtil.getDriver().switchTo().defaultContent();
	}

	// To interact with browser

	// step to resize browser
	@Then("^I resize browser window size to width (\\d+) and height (\\d+)$")
	public void resize_browser(int width, int heigth) {
//			navigationObj.resizeBrowser(width, heigth);
	}

	// step to maximize browser
	@Then("^I maximize browser window$")
	public void maximize_browser() {

//			navigationObj.maximizeBrowser();
	}

	// zoom in/out page

	// steps to zoom in page
	@Then("^I zoom in page$")
	public void zoom_in() {
//			navigationObj.zoomInOut("ADD");
	}

	// steps to zoom out page
	@Then("^I zoom out page$")
	public void zoom_out() {
//			navigationObj.zoomInOut("SUBTRACT");
	}

}

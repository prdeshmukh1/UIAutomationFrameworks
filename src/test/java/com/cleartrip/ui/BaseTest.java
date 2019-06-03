package com.cleartrip.ui;

import org.openqa.selenium.WebDriver;

import com.cleartrip.ui.utls.DriverUtil;

public class BaseTest 
{
	protected WebDriver driver;
	public BaseTest(){
		this.driver = DriverUtil.getDriver();
	}
}

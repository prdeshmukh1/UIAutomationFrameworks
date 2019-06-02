package com.cleartrip.ui;

import org.openqa.selenium.WebDriver;

import env.DriverUtil;

public class BaseTest 
{
	protected WebDriver driver;
	public BaseTest(){
		this.driver = DriverUtil.getDriver();
	}
}

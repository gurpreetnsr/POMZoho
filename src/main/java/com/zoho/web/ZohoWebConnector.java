package com.zoho.web;

import org.openqa.selenium.By;

import com.zoho.base.pages.ZohoPage;

public interface ZohoWebConnector {
	
	void validateLogin();
	void logout();
	ZohoPage validateTitle(String expectedTitle);
	ZohoPage validateText(By locator, String expectedText);
	ZohoPage validateElementPresence(By locator);
	ZohoPage validateNonElementPresence(By locator);
	boolean isElementPresent(By locator);
}

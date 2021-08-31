package com.zoho.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.zoho.session.ZohoTestSession;

public interface WebConnector extends ZohoWebConnector {
	void openBrowser(String bName);
	void navigate(String url);
	void quit();
	EventFiringWebDriver getCurrentDriver();
	ZohoTestSession getSession();
	void log(String message);
	
	boolean isStopExecution();
	void setStopExecution(boolean stopExecution);
	void assertAll();
	
	SoftAssert getSoftAssert();
	void setSoftAssert(SoftAssert softAssert);
	void fail(String message);
	
	
}

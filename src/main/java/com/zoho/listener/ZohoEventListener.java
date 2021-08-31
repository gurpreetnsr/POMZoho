package com.zoho.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoEventListener extends AbstractWebDriverEventListener {
	public void beforeFindBy(By locator, WebElement element, WebDriver driver) {
		//System.out.println("This is before finding the UI Element");
		//boolean err= false;
		if(getSession().isExecuteListener())
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
			} catch (Exception e) {
				getDriver().fail("The element not found " + locator);
				getDriver().assertAll();
			}
		}
	}

	//	public void afterFindBy(By by, WebElement element, WebDriver driver) {
	//		System.out.println("This is after finding the UI Element");
	//		System.out.println(by.toString());
	//		System.out.println(element.toString());
	//
	//	}

	public ZohoTestSession getSession()
	{
		return (ZohoTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public WebConnector getDriver()
	{
		return getSession().getCon();
	}
	public void log(String message)
	{
		getSession().log(message);
	}



}

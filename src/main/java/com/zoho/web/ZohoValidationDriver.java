package com.zoho.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public abstract class ZohoValidationDriver implements WebConnector {

	EventFiringWebDriver driver;
	boolean stopExecution;
	SoftAssert softAssert = new SoftAssert();

	public ZohoPage validateTitle(String expectedTitle) {
		//System.out.println("The value of fucntion is " + stopExecution);
		//Assert.assertEquals(driver.getTitle(), expectedTitle);
		log("Expected title is " + expectedTitle);
		log("Actual title is " + driver.getTitle());
		if(!expectedTitle.equals(driver.getTitle()))
		{
			fail("Titles do not match. Got title as " + driver.getTitle());
		}

		return getSession().getCurrentPage();
	}

	public ZohoPage validateText(By locator, String expectedText) {
		//Assert.assertEquals(driver.getTitle(), expectedTitle);
		//System.out.println("The value of fucntion is " + stopExecution);
		String actualText =driver.findElement(locator).getText();
		if(!expectedText.equals(actualText))
		{
			fail("Text not matching. Got text as " + actualText);
		}
		return getSession().getCurrentPage();
	}

	public ZohoPage validateElementPresence(By locator) {
		if(!isElementPresent(locator))
			fail("Element not found "+ locator);
		return getSession().getCurrentPage();
	}
	
	public ZohoPage validateNonElementPresence(By locator) {
		if(isElementPresent(locator))
			fail("Element is should not present "+ locator);
		return getSession().getCurrentPage();
	}

	public boolean isElementPresent(By locator)
	{
		getSession().setExecuteListener(false);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			getSession().setExecuteListener(true);
			return false;
		}
		getSession().setExecuteListener(true);
		return true;
	}

	public void validateLogin() {
		// TODO Auto-generated method stub
	}

	public ZohoTestSession getSession() {
		return (ZohoTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}

	public void assertAll()
	{
		softAssert.assertAll();
	}

	public SoftAssert getSoftAssert() {
		return softAssert;
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}

	public void log(String message)
	{
		getSession().log(message);
	}
	public void fail(String message)
	{
		getSession().failTest(message); // Failing the test in ExtentReport

		softAssert.fail(message); // fail the test in TestNG

		if(isStopExecution())
			assertAll();
	}



}

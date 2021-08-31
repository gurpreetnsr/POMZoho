package com.zoho.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.zoho.base.pages.ZohoPage;
import com.zoho.listener.ZohoEventListener;
import com.zoho.session.ZohoTestSession;

public class ZohoDriver extends ZohoValidationDriver {

	public void logout() {
		// TODO Auto-generated method stub
	}

	public void openBrowser(String bName) {
		log("Opening the browser " + bName);
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Browser Drivers\\Chrome92\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();
		driver = new EventFiringWebDriver(cdriver);
		ZohoEventListener eventListener = new ZohoEventListener();
		driver.register(eventListener);
		driver.manage().window().maximize();
	}

	public void navigate(String url) {
		log("Navigating to the URL " + url);
		driver.get(url);
	}

	public void quit() {
		// TODO Auto-generated method stub
	}

	public EventFiringWebDriver getCurrentDriver() 
	{
		return driver;
	}

}

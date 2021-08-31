package com.zoho.pages.normal;

import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public class LaunchPage extends ZohoBasePage {
	
	public ZohoPage openBrowser(String browser) {
		System.out.println("Open broswer from Launch page");
		getDriver().openBrowser("browser");
		return this;
	}

	public ZohoPage goToHomePage() {
		System.out.println("Zoho Home Page is called");
		//ZohoTestSession session = getSession();
		log("Navigating to https://www.zoho.com/index1.html");
		getDriver().navigate("https://www.zoho.com/index1.html");
		return new HomePage();

	}

}

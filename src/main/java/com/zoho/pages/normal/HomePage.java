package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

public class HomePage extends ZohoBasePage {
	
	@FindBy(css=Constants.LOGIN_LINK)
	WebElement SignIn;
	
	public ZohoPage goToEnterUsernamePage() {
		log("Going to username page");
		waitForPageToLoad();
		SignIn.click();
		return new EnterUsernamePage();
	}

}

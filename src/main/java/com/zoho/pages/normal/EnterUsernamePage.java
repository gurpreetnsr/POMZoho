package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

public class EnterUsernamePage extends ZohoBasePage {
	
	@FindBy(css=Constants.LOGIN_ID)
	WebElement loginUsername;
	
	@FindBy(id="nextbtn")
	WebElement nextButton;
	
	public ZohoPage submitUsername(String userName)
	{
		waitForPageToLoad();
		loginUsername.sendKeys(userName);
		nextButton.click();
		
		boolean presencePasswordField = validator(false).isElementPresent(Constants.PASSWORD_LOCATOR);
		if(!presencePasswordField)
			return this;
		else
			return new EnterPasswordPage();
	}

}

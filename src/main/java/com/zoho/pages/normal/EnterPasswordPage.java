package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

public class EnterPasswordPage extends ZohoBasePage {
	
	@FindBy(css=Constants.PASSWORD)
	WebElement loginPassword;
	
	@FindBy(id="nextbtn")
	WebElement nextButton;
	
	public ZohoPage submitPassword(String password)
	{
		loginPassword.sendKeys(password);
		nextButton.click();
		
		boolean presencePasswordField = validator(false).isElementPresent(Constants.PASSWORD_LOCATOR);
		if(!presencePasswordField)
			return this;
		else
			return new EnterPasswordPage();
		
	}

}

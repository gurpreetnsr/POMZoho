package com.zoho.base.pages;

import com.zoho.web.WebConnector;

public interface ZohoNormalPage {

	// Zoho normal
	ZohoPage goToHomePage();
	ZohoPage goToEnterUsernamePage();
	void goToRegisterPage();
	ZohoPage submitUsername(String userid);
	ZohoPage submitPassword(String password);
	WebConnector validator(boolean stopExecution);

}

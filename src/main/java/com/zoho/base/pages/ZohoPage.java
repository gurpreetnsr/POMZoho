package com.zoho.base.pages;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public interface ZohoPage extends ZohoNormalPage, ZohoSessionPage {
	
	//normal browser operations
	ZohoPage openBrowser(String browser);
	void quit();
	void getTotalWindows();
	ZohoTestSession getSession();
	
	// Zoho normal
	ZohoPage goToHomePage();
	ZohoPage goToEnterUsernamePage();
	void goToRegisterPage();
	ZohoPage submitUsername(String userid);
	ZohoPage submitPassword(String password);
	WebConnector validator(boolean stopExecution);
	
	// Zoho session based functions
	void createDeal();
	void logout();
	
	void log(String message);
		

}

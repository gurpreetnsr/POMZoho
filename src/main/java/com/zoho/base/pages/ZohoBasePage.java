package com.zoho.base.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoBasePage implements ZohoPage {

	public ZohoBasePage()
	{
		PageFactory.initElements(getCurrentDriver(), this);
		getSession().setCurrentPage(this);
	}

	public ZohoPage openBrowser(String browser) {
		return null;
		// TODO Auto-generated method stub
	}

	public void quit() {
		// TODO Auto-generated method stub
	}

	public void getTotalWindows() {
		// TODO Auto-generated method stub

	}

	public ZohoPage goToHomePage() {
		// TODO Auto-generated method stub
		return null;

	}


	public void goToRegisterPage() {
		// TODO Auto-generated method stub

	}

	public ZohoPage submitUsername(String userid) {
		return null;
		// TODO Auto-generated method stub

	}
	public ZohoPage submitPassword(String password) {
		return null;
		// TODO Auto-generated method stub
	}

	public WebConnector validator(boolean stopExecution) {
		getSession().getCon().setStopExecution(stopExecution);
		return getSession().getCon();
	}

	public void createDeal() {
		// TODO Auto-generated method stub

	}

	public void logout() {
		// TODO Auto-generated method stub

	}

	public ZohoTestSession getSession()
	{
		return (ZohoTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public WebConnector getDriver()
	{
		return getSession().getCon();
	}

	public ZohoPage goToEnterUsernamePage() {
		// TODO Auto-generated method stub
		return null;
	}

	public EventFiringWebDriver getCurrentDriver()
	{
		return getSession().getCon().getCurrentDriver();
	}

	public void log(String message)
	{
		getSession().log(message);
	}

	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)getCurrentDriver();
		int i=1;
		// check for pageload 100% - 20 secs
		while(i!=10){
			String state = (String)js.executeScript("return document.readyState;");
			System.out.println(state);

			if(state.equals("complete"))
				break;
			else
				wait(2);

			i++;
		}
		// check for jquery/ajax status - 20 secs
		i=1;
		while(i!=10){

			Long d= (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if(d.longValue() == 0 )
				break;
			else
				wait(2);
			i++;

		}

	}

	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

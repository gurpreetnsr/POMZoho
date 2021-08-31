package com.zoho.session;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.reports.ExtentManager;
import com.zoho.web.WebConnector;
import com.zoho.web.ZohoDriver;

public class ZohoTestSession {
	WebConnector con;
	ZohoPage currentPage;
	ExtentReports reports;
	ExtentTest test;
	boolean executeListener;
	
	public ZohoTestSession()
	{
		con = new ZohoDriver();
	}

	public void init(String testName)
	{
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session")==null)
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		
		reports = ExtentManager.getReport(Constants.REPORTS_PATH);
		test = reports.createTest(testName);
		
		ZohoPage page = new LaunchPage();
		//return page;
	}
	
	public WebConnector getCon()
	{
		return con;
	}

	public ZohoPage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(ZohoPage currentPage) {
		this.currentPage = currentPage;
	}

	public void end() {
		getCon().assertAll();
		
	}

	public void log(String message) {
		test.log(Status.INFO, message);
	}
	
	public void skipTest(String message) {
		test.log(Status.SKIP, message);
	}
	
	
	public void generateReport()
	{
		if(reports !=null)
		reports.flush();
	}
	public void failTest(String failuremessage) {
		takeScreenShot();
		test.log(Status.FAIL, failuremessage);
		//take screenshot also
	}
	
	public void takeScreenShot()
	{
		Date d = new Date();
		String srcreenshotFile = d.toString().replace(":", "_").replace(" ", "_")+".png";
		File srcFile = ((TakesScreenshot)getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File((ExtentManager.screenshotFolderPath)+srcreenshotFile));
			test.log(Status.INFO, "Screenshot -> " + test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+srcreenshotFile));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isExecuteListener() {
		return executeListener;
	}

	public void setExecuteListener(boolean executeListener) {
		this.executeListener = executeListener;
	}
	

}

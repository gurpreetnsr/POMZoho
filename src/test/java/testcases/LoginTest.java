package testcases;

import java.util.Hashtable;

import javax.xml.validation.Validator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.listener.ZohoEventListener;
import com.zoho.pages.normal.EnterPasswordPage;
import com.zoho.pages.normal.EnterUsernamePage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.session.ZohoTestSession;
import com.zoho.util.DataUtil;
import com.zoho.util.Xls_Reader;
import com.zoho.web.ZohoDriver;
import com.zoho.web.ZohoWebConnector;

public class LoginTest {

	ZohoTestSession session;
	String testName = "LoginTest";
	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	@BeforeMethod
	public void init()
	{
		session = new ZohoTestSession();
		session.init(testName);
	}

	@Test(dataProvider = "getData")
	public void loginTest(Hashtable<String, String> data)
	{
		session.log(data.toString());
		if(data.get("RunMode").equals("N"))
		{
			// skip the test in Extent Report
			session.skipTest("Skipping the test as run mode is No");
			// skip the test in TestNG
			throw new SkipException("Skipping the test as run mode is No");

		}
		//String userName = "se.leniumtraining10@gmail.com";
		String userName = data.get("Username");

		//String password = "Whizdom@2020";
		String password = data.get("Password");

		//String userNameValid = "Y";
		String userNameValid = data.get("UsernameValid");

		ZohoPage page  = new LaunchPage()
				.openBrowser("chrome")
				.goToHomePage()
				.validator(true).validateTitle(Constants.HOME_PAGE_TITLE)
				.validator(false).validateText(Constants.HOMEPAGE_TEXT_LOCATOR, "GET STARTED FOR FREE")
				.validator(true).validateElementPresence(Constants.LOGIN_LINK_LOCATOR)
				.goToEnterUsernamePage()
				.submitUsername(userName);

		if(page instanceof EnterUsernamePage & userNameValid.equals("Y"))
		{
			// report failure
			page.validator(true).fail("Could not enter using valid username " + userName);
		} else if(page instanceof EnterPasswordPage)
		{
			if(userNameValid.equals("N"))
				// report failure
				page.validator(true).fail("Could enter using valid username " + userName);
			else 
				page.submitPassword(password);
		}

		session.end();	

	}

	@DataProvider
	public Object[][] getData()
	{
		 return DataUtil.getData(testName, xls);
	}

	@AfterMethod
	public void quit()
	{
		session.generateReport();
	}

}

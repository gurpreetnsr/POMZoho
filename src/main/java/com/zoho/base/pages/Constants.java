package com.zoho.base.pages;

import org.openqa.selenium.By;

public class Constants {
		
	public static final String LOGIN_LINK = ".signupcontainer>a";
	public static final By LOGIN_LINK_LOCATOR = By.cssSelector(LOGIN_LINK);
	
	public static final String LOGIN_ID="#getusername>span>input";
	public static final By LOGIN_ID_LOCATOR=By.cssSelector(LOGIN_ID);
		
	public static final String NEXT_BUTTON="#nextbtn>span";
	public static final By NEXT_BUTTON_LOCATOR=By.cssSelector(NEXT_BUTTON);
	
	public static final String PASSWORD="#password";
	public static final By PASSWORD_LOCATOR=By.cssSelector(PASSWORD);
	
	
	public static final String HOMEPAGE_TEXT = "//div[@class='zh-home-btn']/a";
	public static final By HOMEPAGE_TEXT_LOCATOR = By.xpath(HOMEPAGE_TEXT);
	
	// title
	public static final String HOME_PAGE_TITLE = "Zoho | Cloud Software Suite for Businesses";
	
	// report path
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"//reports//";
	

}

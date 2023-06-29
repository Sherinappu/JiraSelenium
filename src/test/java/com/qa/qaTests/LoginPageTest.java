package com.qa.qaTests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.ActiveSprints;
import com.qa.pages.LoginPage;
import com.qa.testBase.TestBase;

import com.qa.genericLibrary.*;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	ActiveSprints activesprints;
	Commonmethods commonmethods;
	
	public LoginPageTest() {
		super();  //else may give nullpointerexception
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		loginpage = new LoginPage();
		commonmethods = new Commonmethods();
	}
	
	@Test
	public void loginfunctionality() {
		activesprints = loginpage.verifyloginfunctionality(prop.getProperty("usename"), prop.getProperty("password"));
		
	} 	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}

package com.qa.qaTests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.ActiveSprints;
import com.qa.pages.LoginPage;
import com.qa.pages.Reportspage;
import com.qa.testBase.TestBase;

import com.qa.genericLibrary.*;

public class ReportsPageTest extends TestBase{
	
	LoginPage loginpage;
	ActiveSprints activesprints;
	Reportspage reportspage;
	Commonmethods commonmethods;
	
	public ReportsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		loginpage = new LoginPage();
		reportspage= new Reportspage();
		commonmethods = new Commonmethods();
		activesprints = loginpage.verifyloginfunctionality(prop.getProperty("usename"), prop.getProperty("password"));
		reportspage = activesprints.clickonreports();
	}
	
	@Test
	public void verifyissuesexcludedfromthesprint() {
		reportspage.clickonsprintreports();
		String issuecount = reportspage.verifycountofissuesremovedfromsprint();
		System.out.println(issuecount);
		reportspage.clickonback();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	 

}

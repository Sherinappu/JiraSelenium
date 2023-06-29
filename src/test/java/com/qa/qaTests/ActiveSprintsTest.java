package com.qa.qaTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.qa.pages.ActiveSprints;
import com.qa.pages.IssuesPage;
import com.qa.pages.LoginPage;
import com.qa.pages.Reportspage;
import com.qa.testBase.TestBase;

import com.qa.genericLibrary.*;


public class ActiveSprintsTest extends TestBase {
	LoginPage loginpage;
	ActiveSprints activesprints;
	Reportspage reportspage;
	Commonmethods commonmethods;
	IssuesPage issuespage;
	
	
	public ActiveSprintsTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		loginpage = new LoginPage();
		commonmethods = new Commonmethods();
		issuespage = new IssuesPage();
		activesprints = loginpage.verifyloginfunctionality(prop.getProperty("usename"), prop.getProperty("password"));
	}
	
	@Test
	public void activesprintdisplay() {
		String pagemsg = activesprints.verifyactivesprintsarepresent();
		AssertJUnit.assertEquals(pagemsg, "There are no active sprints");
		reportspage = activesprints.clickonreports();
		}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

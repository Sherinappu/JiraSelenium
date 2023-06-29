package com.qa.qaTests;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.ActiveSprints;
import com.qa.pages.IssuesPage;
import com.qa.pages.LoginPage;
import com.qa.pages.Reportspage;
import com.qa.testBase.TestBase;

import com.qa.genericLibrary.*;

public class IssuePageTest extends TestBase {
	
	LoginPage loginpage;
	ActiveSprints activesprints;
	IssuesPage issuespage;
	Commonmethods commonmethods;
	
	
	public IssuePageTest() {
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
	public void Verifyallissuetypes() throws InterruptedException {
		activesprints.clickonissues();
		issuespage.clickonallissues();
		issuespage.clickontypedropdown();
		issuespage.clickonsearchbox();
		issuespage.clickonrequiredissuetype();
		
	}
	
	@Test
	public void Verifybugncmpr911() throws InterruptedException{
		activesprints.clickonissues();
		issuespage.clickonallissues();
		issuespage.clickontypedropdown();
		issuespage.clickonsearchbox();
		issuespage.clickonrequiredissuetypeandgetbugs();
		issuespage.verifyallworkflowissue();
		String ncm911link = issuespage.verifyanyworkflowissue();
		System.out.println("Link of NCM911 is-  " + ncm911link);
	}
	
	
	@Test
	public void Verifycommentforbugncmpr911() throws InterruptedException{
		activesprints.clickonissues();
		issuespage.clickonallissues();
		issuespage.clickontypedropdown();
		issuespage.clickonsearchbox();
		issuespage.clickonrequiredissuetypeandgetbugs();
		issuespage.verifyallworkflowissue();
		String ncm911link = issuespage.verifyanyworkflowissue();
		
		String bugcomt =  issuespage.verifyissueopenedinanewwindow(ncm911link);
		System.out.println("Latest comment for NCMPR-911 is"+" "+bugcomt);
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.testBase.TestBase;

import com.qa.genericLibrary.*;

public class ActiveSprints extends TestBase{
	Commonmethods commonmethods = new Commonmethods();
	@FindBy(xpath="//*[@class='ghx-no-active-sprint-content']//*[contains(text(),'There are no active sprints')]")
	WebElement activesprint;
	
	@FindBy(css="a[data-testid='navigation-apps-sidebar-software-classic.ui.menu.reports-link--item'][href='/projects/NCMPR?selectedItem=com.atlassian.jira.jira-projects-plugin:report-page']")
	WebElement reportoption;
	
	@FindBy(css="a[href='/jira/software/c/projects/NCMPR/issues']")
	WebElement issues;
	
	@FindBy(xpath="//span[contains(text(),'Zephyr Scale')]")
	WebElement zephyrscale;
	
	public ActiveSprints(){
		PageFactory.initElements(driver, this);}
	
	public String verifyactivesprintsarepresent() {
		return activesprint.getText();
	}
		
	public Reportspage clickonreports() {
		wait.until(ExpectedConditions.visibilityOf(reportoption));
		reportoption.click();
		return new Reportspage();

	}
	
	public IssuesPage clickonissues() {
		commonmethods.scrollintoview(issues);
		issues.click();
		return new IssuesPage();
	
	}
	
	public ZephyrscalePage clickonZephyrscale() {
		commonmethods.scrollintoview(zephyrscale);
		zephyrscale.click();
		return new ZephyrscalePage();
	}
}

package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.testBase.TestBase;

import com.qa.genericLibrary.*;

public class Reportspage extends TestBase{
	Commonmethods commonmethods= new Commonmethods();
	
	@FindBy(css="a[href='/jira/software/c/projects/NCMPR/boards/132/reports/sprint-retrospective']")
	WebElement sprintReports;
	
	@FindBy(xpath="//h4[contains(text(),'Issues Removed From Sprint')]")
	WebElement issuesremoved;
	
	@FindBy(xpath="//div[@class='ghx-sprint-report-table ghx-report-issue-list']//table[2]//tr//*[@class=\"ghx-nowrap\"]/a")
	List<WebElement> issues;

	@FindBy(css="a[href='/jira/software/c/projects/NCMPR/boards/132']")
	WebElement clickback;
	
	
	public Reportspage(){
		PageFactory.initElements(driver, this);}
	
	public void clickonsprintreports() {
		//commonmethods.scrollintoview(sprintReports);
		wait.until(ExpectedConditions.visibilityOf(sprintReports));
		sprintReports.click();
	}
	
	
	public String verifycountofissuesremovedfromsprint() {
		commonmethods.scrollintoview(issuesremoved);
		return("issues excluded from the sprint are" + " = " + issues.size());
	}
	
	public void clickonback() {
		clickback.click();
	}

}

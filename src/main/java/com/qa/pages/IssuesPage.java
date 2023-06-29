package com.qa.pages;

import java.util.List;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.testBase.TestBase;

import com.qa.genericLibrary.*;

public class IssuesPage extends TestBase {
	
	String ncm911link;
	Commonmethods commonmethods = new Commonmethods();
	
	@FindBy(css="a[href='/jira/software/c/projects/NCMPR/issues/?filter=allissues']")
	WebElement allissues;
	
	@FindBy(css="button[data-testid='jql-builder-basic.ui.jql-editor.picker.filter-button.type']")
	WebElement typedropdown;
	
	@FindBy(xpath="//body/div/div/div[@data-placement='bottom-start']/div/div[@id='type']/div[1]/div[1]")
	WebElement searchbox;
	
	@FindBy(xpath="//*[@data-testid='jql-builder-basic.ui.jql-editor.picker.async-select.select.option']")
	List<WebElement> issuetype;
	
	@FindBy(xpath="//*[@class='_1reo15vq _18m915vq _1bto1l2s _18u01y44' and contains(text(),'Sub-task')]")
	WebElement ourtype;
	
	@FindBy(xpath="//*[@data-testid='jql-builder-basic.common.ui.text-field.search-field-container']//*[@name='search']")
	WebElement mainsearch;
	
	@FindBy(css="a[data-component-selector='jira-native-issue-table-issue-key'][href='/browse/NCMPR-911']")
	WebElement workflowissue;
	
	@FindBy(xpath="//p[contains(text(),'Prod validation complete')]")
	WebElement ncm11bugcmt;
	
	public IssuesPage(){
		PageFactory.initElements(driver, this);}
	
	public void clickonallissues() throws InterruptedException {
		
		allissues.click();
		
		//commonmethods.waitforelementstoappear(By.xpath("//*[@class=' css-1b6odlt']//*[text()='Search']"));
	}
	public void clickontypedropdown() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(typedropdown));
		commonmethods.threadsleep();
		
		typedropdown.click();
	}
	public void clickonsearchbox() throws InterruptedException {

		commonmethods.threadsleep();
		//wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.click();
	}
	
	
	
	public void clickonrequiredissuetype() throws InterruptedException {
		commonmethods.threadsleep();
		commonmethods.scrollintoview(ourtype);
		for(WebElement issuetypeeach : issuetype)
		{
			String issuetxt = issuetypeeach.getText();
			if(issuetxt.contains("Bug"))
			{
				System.out.println("Bug");
				issuetypeeach.click();
				System.out.println("all bugs listed");
				break;
			}
		}
		typedropdown.click();
	}
	
	public void clickonrequiredissuetypeandgetbugs() throws InterruptedException {
		commonmethods.threadsleep();
		commonmethods.scrollintoview(ourtype);
		for(WebElement issuetypeeach : issuetype)
		{
			String issuetxt = issuetypeeach.getText();
			if(issuetxt.contains("Bug"))
			{
				issuetypeeach.click();
				break;
			}
		}
		typedropdown.click();
	}
	
	public void verifyallworkflowissue() {
		commonmethods.entervalueinafield(mainsearch, "workflow");
	}
	
	public String verifyanyworkflowissue() {
		String ncm911link = commonmethods.getattributevalue(workflowissue, "href");
		return ncm911link;
	}
	
	public String verifyissueopenedinanewwindow(String ncm911link1) throws InterruptedException {
		String mainwindow = commonmethods.mainwindowhandling();
		commonmethods.switchtonewwindow();
		commonmethods.accessurl(ncm911link1);
		commonmethods.threadsleep();
		String bugcmt = commonmethods.gettextinafield(ncm11bugcmt);
		commonmethods.closingawindow();
		commonmethods.switchtoawindowhandle(mainwindow);
		return bugcmt;
		
	}
	
}

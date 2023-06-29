package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.testBase.TestBase;

import com.qa.genericLibrary.*;

public class LoginPage extends TestBase  {
	//Page factory or object repo


	Commonmethods commonmethods;
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	WebElement continuebtn;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Log in')]")
	WebElement loginbtn;
	
	@FindBy(css="span[aria-label='Appswitcher Icon']")
	WebElement appswitcher;
	
	@FindBy(css="a[data-testid='switcher-item__JIRA_SOFTWARElittler'] .css-5mekwu")
	WebElement jirasoftware;
	
	@FindBy(css="input[name='search']")
	WebElement searchncm;
	
	@FindBy(css="a[href='/browse/NCMPR']")
	WebElement clickncm;
	
	//initialization
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);}
		
	//Actions

	public ActiveSprints verifyloginfunctionality(String un, String pw) {
		commonmethods = new Commonmethods();
		commonmethods.entervalueinafield(username, un);
		//username.sendKeys(un);
		continuebtn.click();
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pw);
		wait.until(ExpectedConditions.visibilityOf(loginbtn));
		loginbtn.click();
		wait.until(ExpectedConditions.visibilityOf(appswitcher));
		appswitcher.click();
		wait.until(ExpectedConditions.visibilityOf(jirasoftware));
		jirasoftware.click();
		wait.until(ExpectedConditions.visibilityOf(searchncm));
		commonmethods.entervalueinafield(searchncm,"ncm");
		clickncm.click();
		return new ActiveSprints();
		
	}
	

}

package com.qa.genericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.qa.testBase.TestBase;

public class Commonmethods extends TestBase {
	
	 
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public void accessurl(String url) {
		driver.get(url);
	}
	
	public void scrollintoview(WebElement scrollelement) {
		//JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollelement);

	}
	public void threadsleep() throws InterruptedException{
		Thread.sleep(2000);
	}
	
	
	public WebElement waitforelementstoappear(By waitelement) {
		WebElement waitelemt = wait.until(ExpectedConditions.visibilityOfElementLocated(waitelement));
		return waitelemt;
	}
	
	public void entervalueinafield(WebElement textfield, String requiredvalue) {
		textfield.sendKeys(requiredvalue);
	}
	
	public String gettextinafield(WebElement issuetype) {
		String gettextvalue = issuetype.getText();
		return gettextvalue;
	}
	
	public String getattributevalue(WebElement attributefield, String attrname) {
		String attributevalue = attributefield.getAttribute(attrname);
		return attributevalue;
	}
	
	public String mainwindowhandling() {
		String mainhandle = driver.getWindowHandle();
		return mainhandle;
	}
	
	public void switchtonewwindow() {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	public void switchtoawindowhandle(String windowhandle) {
		driver.switchTo().window(windowhandle);
	}
	
	public void closingawindow() {
		driver.close();
	}
	
	public String takescreenshots(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
		
	}
	

}

package com.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport0 {
	
	public ExtentReports getreportobjects() 
	{
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reportobj = new ExtentSparkReporter(path);
	reportobj.config().setDocumentTitle("Test results");
	reportobj.config().setReportName("Jira Autmn result");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reportobj);
	extent.setSystemInfo("tester", "sherin");
	return extent;

}
}

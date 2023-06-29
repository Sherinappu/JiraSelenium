package com.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.config.DynamicValues;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	//public static Commonmethods commonmethods;
	
	
	public TestBase() {
		
		
		try {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:/Users/sherinaj/eclipse-workspace/Framework1/proj1/src/main/java/com/qa/config/config.properties");
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src/main/java/com/qa/config/config.properties");
		prop.load(fis);
	}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();}
		catch(IOException e) {
			e.printStackTrace();}
	}

public static void Initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sherinaj\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else {
		System.out.println("sorry");
	}
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DynamicValues.IMPLICT_WAIT));
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DynamicValues.PAGE_LOAD_TIMEOUT));
	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 driver.get(prop.getProperty("url"));
}}

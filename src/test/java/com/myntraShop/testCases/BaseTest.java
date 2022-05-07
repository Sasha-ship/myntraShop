package com.myntraShop.testCases;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myntraShop.utilities.ReadConfig;

public class BaseTest {
	ReadConfig readVal = new ReadConfig();
	public String url = readVal.getApplicationURL();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browserName")
	@BeforeClass
	public void setup(String browser) {
		
		
	
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readVal.getChromePath());
			driver = new ChromeDriver();

			
		}
		
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readVal.getMozzilaPath());
			driver = new ChromeDriver();

			
		}
		
		driver.get(url);
		
		logger = LogManager.getLogger("BaseTest");

		logger.info("Url info");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("Browser closed");
	}

}

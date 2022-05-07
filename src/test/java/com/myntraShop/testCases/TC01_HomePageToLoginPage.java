package com.myntraShop.testCases;

import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntraShop.pageObjects.HomePagetoLoginPage;



public class TC01_HomePageToLoginPage extends BaseTest {
	
	
	@Test
	public void  WelcomeToLoginPage()
	{
		
		logger.info("URL is opened");
		
		HomePagetoLoginPage hp = new HomePagetoLoginPage(driver);

		
		hp.movetoLoginPage();
		
		logger.info("Hover on Profile");
		logger.info("Tap on Login/Signup");
		 if(hp.str.equalsIgnoreCase(hp.title.getText()))
		   {
		      Assert.assertTrue(true);
		      logger.info("Login/Signup page confirmed");
		   }
	   
	   else
	   {
		   Assert.assertTrue(false);
		   logger.info("Invalid Page ");
	   }
		   }
		
		
	}



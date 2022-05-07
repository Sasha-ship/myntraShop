package com.myntraShop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class HomePagetoLoginPage  {
	 static WebDriver driver;
	 public  String str ="Login or SignUp";
	 public HomePagetoLoginPage(WebDriver ldriver)
	 {
		 driver=ldriver;
		 PageFactory.initElements(ldriver, this);
	 }
	 
	 
	 @FindBy(xpath="//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[1]/span[2]")
	 @CacheLookup
	 WebElement HoverOnProfile;
	 
	 
	 
	 @FindBy(xpath="//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/a")
	 @CacheLookup
	 WebElement TapOnLogin;
	 
	 @FindBy(xpath ="//*[@id=\"reactPageContent\"]/div/div/div[2]/div[1]")
	public WebElement title;
	
	 public void movetoLoginPage()
	 {
		 Actions mouseHover = new Actions(driver);
		 mouseHover.moveToElement(HoverOnProfile).moveToElement(TapOnLogin).click().build().perform();
		 
	     
	  
		   
	 
	 }
}

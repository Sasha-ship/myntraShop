package com.myntraShop.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport5 extends TestListenerAdapter {

	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark;
	 public ExtentTest logger;
	
	
	
	public void extentTest(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
	    spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+ repName);
        try {
			spark.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Myntra Shop  Project"); // Tile of report
		spark.config().setReportName("Functional Test Automation Report"); // name of the report

		extent.attachReporter(spark);
		

	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure (ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String screenshotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		}
	
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

};
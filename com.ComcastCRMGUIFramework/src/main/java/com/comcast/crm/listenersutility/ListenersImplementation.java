package com.comcast.crm.listenersutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseTest;

public class ListenersImplementation implements ITestListener, ISuiteListener{

	public ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;
	Date date;
	String time;

	public void onStart(ISuite suite) {

		date = new Date();
		time = date.toString().replace(" ", "_").replace(":", "_");

		//Spark report configuration
		spark = new ExtentSparkReporter("./advancedReports/report_"+time+".html");
		spark.config().setDocumentTitle("Flipkart Advance Report");
		spark.config().setReportName("Flipkart Report");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		//Add environment details
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("BROWSER", "Chrome 116.0");
	}

	public void onFinish(ISuite suite) {

		report.flush();
	}

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName()+"Started");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+"Completed");
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot take=(TakesScreenshot) BaseTest.sDriver;
		String filepath = take.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, testname+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"Failed");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}

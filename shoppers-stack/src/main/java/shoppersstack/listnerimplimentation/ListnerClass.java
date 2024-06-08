package shoppersstack.listnerimplimentation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import shoppersstack.baseclass.BaseClass;
import shopperstack.fileutility.JavaUtility;

public class ListnerClass implements ITestListener, ISuiteListener{
	
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		JavaUtility java=new JavaUtility();
		spark=new ExtentSparkReporter("./AdvancedReports/"+suite.getName()+java.getSystemDate()+".html");
		report=new ExtentReports();
		report.attachReporter(spark);
		Reporter.log(suite.getName()+" has started execution", true);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		Reporter.log(result.getName()+" test script has started execution", true);
		test.log(Status.INFO, result.getName()+" test script has started execution");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" test script has successfully executed", true);
		test.log(Status.PASS, result.getName()+" test script has successfully executed");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" test script has skipped", true);
		test.log(Status.SKIP, result.getName()+" test script has skipped");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log(suite.getName()+" has finished execution", true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" test script has failed and successfully captured the screenshot", true);
		JavaUtility java=new JavaUtility();
		String screenShotPath="./FailedScreenshots/"+result.getName()+java.getSystemDate()+".png";
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File path=new File(screenShotPath);
		try {
			FileHandler.copy(img, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath("."+screenShotPath);
		test.log(Status.FAIL, result.getName()+" test script has failed and successfully captured the screenshot");
		
	}

}

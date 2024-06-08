package demo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//@Listeners(shoppersstack.listnerimplimentation.ListnerClass.class)
public class DemoTest {

	@Test
	public void demoTest()  {
		//Assert.fail();
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReports/Demo.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test=report.createTest("TestName");
		test.log(Status.INFO, "Demo Reports");
		report.flush();
		
		
		
	}
}

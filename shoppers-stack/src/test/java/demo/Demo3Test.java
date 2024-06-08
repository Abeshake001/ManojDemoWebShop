package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

import shoppersstack.baseclass.BaseClass;

public class Demo3Test extends BaseClass{
	
	@Test
	public void demo3Test() {
		
		String browser = System.getProperty("browser");
		System.out.println(browser);
		Reporter.log("Demo 3 Executing", true);
	}

}

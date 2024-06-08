package demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import shoppersstack.baseclass.BaseClass;

@Listeners(shoppersstack.listnerimplimentation.ListnerClass.class)
public class AddAdressTest extends BaseClass{
	
	@Test
	public void addAddressTest() {
		//Click ion My Profile
		test.log(Status.INFO, "Clicked on My Profile");
		
		//Click on Address
		test.log(Status.INFO, "Clicked on Addresses");
		//Assert.fail();
		//Click on Add New Address
		test.log(Status.INFO, "Clicked on Add New Address");
		
		//Entering all The Details
		test.log(Status.INFO, "Entered all the details");
		
		
	}

}

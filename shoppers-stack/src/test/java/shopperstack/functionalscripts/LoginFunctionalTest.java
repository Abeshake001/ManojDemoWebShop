package shopperstack.functionalscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shopperstack.fileutility.ReadExcel;
import shopperstack.fileutility.ReadProperties;

public class LoginFunctionalTest {

	@DataProvider
	public Object[][] dataSupplier() {
		ReadExcel readExcel=new ReadExcel();
		Object[][] data = readExcel.getMultipleData("LoginTest");
		return data;
	}
	
	
	
	@Test(dataProvider = "dataSupplier")
	public void loginTest(String username, String password) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		ReadProperties read=new ReadProperties();
		String url = read.fetchProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		Thread.sleep(2000);
		driver.quit();
	}
	
}

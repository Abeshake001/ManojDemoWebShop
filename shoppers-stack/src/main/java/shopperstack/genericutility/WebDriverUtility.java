package shopperstack.genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class WebDriverUtility {

	public void clickOnWebElement(WebElement element) {
		element.click();
	}
	
	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void captureScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File path=new File("./Screenshots/"+screenshotName+".png");
		try {
			FileHandler.copy(img, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void captureWebElementScreenshot(WebElement element, String screenshotName) {
		File img = element.getScreenshotAs(OutputType.FILE);
		File path=new File("./Screenshots/"+screenshotName+".png");
		try {
			FileHandler.copy(img, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

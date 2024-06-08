package shoppersstack.baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import shoppersstack.listnerimplimentation.ListnerClass;
import shopperstack.fileutility.ReadProperties;
import shopperstack.genericutility.WebDriverUtility;
import shopperstack.objectrepository.LoginPage;
import shopperstack.objectrepository.WelcomePage;

/**
 * @author Manoj Kumar M
 */
public class BaseClass extends ListnerClass{

	public WebDriver driver;
	public static WebDriver sdriver;
	ReadProperties read=new ReadProperties();
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	@BeforeClass
	public void openBrowser() {
		String browser = System.getProperty("browser");
		if(browser.contains("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.contains("Edge")){
			driver=new EdgeDriver();
		}
		
		sdriver=driver;
		driver.manage().window().maximize();
		String url = read.fetchProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@BeforeMethod
	public void login() {
		WelcomePage welcomePage=new WelcomePage(driver);
		webDriverUtility.clickOnWebElement(welcomePage.getLoginButton());
		String username = read.fetchProperty("username");
		String password = read.fetchProperty("password");
		LoginPage loginPage=new LoginPage(driver);
		webDriverUtility.sendText(loginPage.getEmailTextField(), username);
		webDriverUtility.sendText(loginPage.getPasswordTextField(), password);
		webDriverUtility.clickOnWebElement(loginPage.getLoginButton());
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.partialLinkText("Log out")).click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}

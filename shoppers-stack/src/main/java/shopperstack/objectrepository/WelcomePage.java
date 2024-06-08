package shopperstack.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage{

	public WelcomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(partialLinkText = "Log in")
	private WebElement loginButton;
	

}

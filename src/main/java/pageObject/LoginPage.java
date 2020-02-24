package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	By LOGIN_BUTTON_LOCATOR = By.id("SubmitLogin");
	

	public WebDriver driver;
	private WebDriverWait wait;
	public String USEREMAIL;
	
	@SuppressWarnings("deprecation")
	public LoginPage(WebDriver driver) 
	{
	
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, 100);
		
	}
	
	public void EnterEmail() 
	{
		WebElement emailTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_TEXT_BOX_LOCATOR));
		emailTextBox.clear();
		emailTextBox.sendKeys(CreateAccount.USEREMAIL);
	
	}
	
	public void EnterPassword() 
	{
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_TEXT_BOX_LOCATOR));
		pass.clear();
		pass.sendKeys(RegisterUser.Password);
		
	}

	
	public void clickSigninButton() 
	{
		WebElement SignInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON_LOCATOR));
		SignInButton.click();
		
	
	}
	
}

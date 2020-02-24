package pageObject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {
		
	By Email=By.id("email_create");
	By NewAccount=By.id("SubmitCreate");
	By accalert=By.id("create_account_error");
	
	
	public WebDriver driver;
	private WebDriverWait wait;
	
	public static String USEREMAIL;
	
	
	@SuppressWarnings("deprecation")
	public CreateAccount(WebDriver driver) 
	{
		
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, 100);
		
	}
	
	public void clickEmailTextBox() 
	{
		WebElement emailTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
		emailTextBox.clear();
		USEREMAIL= "Tej" + generateRandom() + "@gmail.com";
		emailTextBox.sendKeys(USEREMAIL);
		
	}
	
	public void clickLoginButton() 
	{
		WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(NewAccount));
		loginButton.click();
		
	}

	public static int generateRandom() 
	{
		Random rand = new Random();
		int randomNo = rand.nextInt(1000000);
		return randomNo;

	}

}

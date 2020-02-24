package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin=By.partialLinkText("Sign in");
	
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver;
		
	}

	
	public WebElement SignIn()
	
	{
		return driver.findElement(signin);
	}

}

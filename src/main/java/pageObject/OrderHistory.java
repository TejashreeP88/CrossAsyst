package pageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class OrderHistory {

	By user_info = By.className("account");
	By history = By.className("icon-list-ol");
	By price = By.className("history_price");
	
	
	
	private WebDriver driver;
	private WebDriverWait wait;


	@SuppressWarnings("deprecation")
	public OrderHistory(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 100);
		

	}

	public void AccountInfo() {
		WebElement accountinfo = wait.until(ExpectedConditions.presenceOfElementLocated(user_info));
		accountinfo.click();
	}
	
	public void ViewHistory() {
		WebElement History = wait.until(ExpectedConditions.presenceOfElementLocated(history));
		History.click();
	}
	
	public void checkprice() {
		WebElement price1 = wait.until(ExpectedConditions.presenceOfElementLocated(price));
		String valueprice = price1.getText();
		Assert.assertEquals(CartSummaryPage.TotalAmount, valueprice);
	
	}

}
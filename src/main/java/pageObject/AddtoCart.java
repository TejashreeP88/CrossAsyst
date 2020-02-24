package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddtoCart 

	{
	
	By Women_category = By.linkText("Women");
	By T_shirt = By.xpath("//a[@class=\"product_img_link\"]");
	By T_shirt_quickview = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[2]");
	
	public WebDriver driver;
	private WebDriverWait wait;
	
	@SuppressWarnings("deprecation")
	public AddtoCart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, 100);
		
	}
	
	public ProductCatalogPage selectWomenMenuOption() 
	{
		WebElement womenMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(Women_category));
		womenMenu.click();
		return new ProductCatalogPage(driver);
	}


}

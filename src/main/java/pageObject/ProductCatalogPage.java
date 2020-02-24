package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ProductCatalogPage {

	By PRODUCR_LINK_LOCATOR = By.xpath("//a[@class=\"product_img_link\"]");


	private WebDriver driver;
	private WebDriverWait wait;

	@SuppressWarnings("deprecation")
	public ProductCatalogPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 100);
	}

	public int getProductCount() {
		List<WebElement> productELementList = driver.findElements(PRODUCR_LINK_LOCATOR);
		return productELementList.size();

	}

	public ProductDetails selectProduct(int key) 
	{
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(PRODUCR_LINK_LOCATOR));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		return new ProductDetails(driver);
	}
	
	

}

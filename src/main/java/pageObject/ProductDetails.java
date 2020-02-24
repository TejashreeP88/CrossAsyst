package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductDetails 
	{
	
	By QUANTITY = By.xpath("//input[@id=\"quantity_wanted\"]");
	By PRICE_LOCATOR = By.id("our_price_display");
	By ADD_PRODUCT_TO_CART= By.xpath("//button/span[text()=\"Add to cart\"]");
	By PROCEED_TO_CHECKOUT = By.partialLinkText("Proceed to checkout");
	
	
	
	private WebDriver driver;
	private WebDriverWait wait;

	//public static String TotalPrice;
	
	@SuppressWarnings("deprecation")
	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
	}


	public void increaseProductCount(int count) {
		WebElement increaseCount = wait.until(ExpectedConditions.elementToBeClickable(QUANTITY));
		increaseCount.click();
		increaseCount.clear();
		increaseCount.sendKeys(count + "");
	}

	public void addProductToCart() {
		WebElement addProductCart = wait.until(ExpectedConditions.presenceOfElementLocated(ADD_PRODUCT_TO_CART));
		addProductCart.click();
	}
	
	public void proceedToCheckOut() {
		WebElement proceedToCheckout = wait.until(ExpectedConditions.presenceOfElementLocated(PROCEED_TO_CHECKOUT));
		proceedToCheckout.click();
		
		
	}
	
}

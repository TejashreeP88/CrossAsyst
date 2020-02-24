package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CartSummaryPage 

{

	By TOTAL_PRICE_LOCATOR = By.id("total_price");
	By PROCEED_TOCHECKOUT = By.partialLinkText("Proceed to checkout");
	By PROCEED_TOCHECKOUT_btn = By.name("processAddress");
	By PROCEED_TOCHECKOUT_ship = By.name("processCarrier");
	By CHECKBOX_LOCATOR = By.id("cgv");
	By PAYMENT_LOCATOR = By.partialLinkText("Pay by check");
	By CONFIRM_ORDER = By.xpath("//span[text()=\"I confirm my order\"]/..");
	By TOTAL_PRICE_PAYMENT = By.id("amount");
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	public static String TotalAmount;

	@SuppressWarnings("deprecation")
	public CartSummaryPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 100);
		js = ((JavascriptExecutor) driver);

	}

	public void getTotalPrice() {
		WebElement priceLink = wait.until(ExpectedConditions.presenceOfElementLocated(TOTAL_PRICE_LOCATOR));
		TotalAmount = priceLink.getText();
		System.out.println("Total"+TotalAmount);
		//Assert.assertEquals(ProductDetails.TotalPrice, value);
		//return ProductDetails.stringToDouble(value);

	}

	public void proceedToCheckoutSummary() {
		js.executeScript("window.scrollTo(0,800)");
		WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TOCHECKOUT));
		js.executeScript("arguments[0].click();", checkout);
		

	}

	public void proceedToCheckoutAddress() {
		js.executeScript("window.scrollTo(0,800)");
		WebElement checkoutAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TOCHECKOUT_btn));
		js.executeScript("arguments[0].click();", checkoutAdd);

	}

	public void proceedToCheckoutShipping() {
		js.executeScript("window.scrollTo(0,600)");
		WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(CHECKBOX_LOCATOR));
		checkbox.click();
		WebElement checkoutship = wait.until(ExpectedConditions.presenceOfElementLocated(PROCEED_TOCHECKOUT_ship));
		js.executeScript("arguments[0].click();", checkoutship);
		
		
	}

	public void proceedToPayment() {
		js.executeScript("window.scrollTo(0,600)");
		WebElement priceLink = wait.until(ExpectedConditions.presenceOfElementLocated(TOTAL_PRICE_LOCATOR));
		String TotalAmount_payment = priceLink.getText();
		Assert.assertEquals(TotalAmount, TotalAmount_payment);
		WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(PAYMENT_LOCATOR));
		js.executeScript("arguments[0].click();", checkbox);

	}

	public void confirmOrder() {
	/*	
		WebElement priceLink = wait.until(ExpectedConditions.presenceOfElementLocated(TOTAL_PRICE_PAYMENT));
		String amount = priceLink.getText();
		Assert.assertEquals(ProductDetails.TotalPrice, amount);
		*/
		js.executeScript("window.scrollTo(0,600)");
		WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(CONFIRM_ORDER));
		checkbox.click();

	}

	public void completePayment() {
		getTotalPrice();
		proceedToCheckoutSummary();
		proceedToCheckoutAddress();
		proceedToCheckoutShipping();
		proceedToPayment();
		confirmOrder();
	}

}

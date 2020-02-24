package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterUser {
	
	By FIRST_NAME_TEXT_BOX_LOCATOR = By.id("customer_firstname");
	By LAST_NAME_TEXT_BOX_LOCATOR = By.id("customer_lastname");
	By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	By FORM_ADDRESS_TEXT_BOX_LOCATOR = By.id("address1");
	By FORM_CITY_TEXT_BOX_LOCATOR = By.id("city");
	By FORM_POSTCODE_TEXT_BOX_LOCATOR = By.id("postcode");
	By FORM_STATE_SELECT_LOCATOR = By.id("id_state");
	By FORM_COUNTRY_SELECT_LOCATOR = By.id("country");
	By FORM_PHONE_MOBILE_TEXT_BOX_LOCATOR = By.id("phone_mobile");
	By FORM_ALIAS_TEXT_BOX_LOCATOR = By.id("alias");
	By FORM_SUBMIT_BUTTON_LOCATOR = By.id("submitAccount");
	By signOut=By.partialLinkText("Sign out");

	public static String Password;
	private WebDriverWait wait;
	private WebDriver driver;

	@SuppressWarnings("deprecation")
	public RegisterUser(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, 100);
		
	}

	public void typeFirstNameTextBox(String keys) 
	{
		WebElement FirstNameTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_TEXT_BOX_LOCATOR));
		FirstNameTextBox.sendKeys(keys);
	}

	public void typeLastNameTextBox(String keys) 
	{
		WebElement lastNameTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME_TEXT_BOX_LOCATOR));
		lastNameTextBox.sendKeys(keys);
	}

	public void typePasswordTextBox(String keys) 
	{
		WebElement passwordTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_TEXT_BOX_LOCATOR));
		Password=keys;
		passwordTextBox.sendKeys(keys);
	}

	public void typeAddressTextBox(String keys) 
	{
		WebElement addressTextBox = wait
				.until(ExpectedConditions.presenceOfElementLocated(FORM_ADDRESS_TEXT_BOX_LOCATOR));
		addressTextBox.sendKeys(keys);
	}

	public void typeCityTextBox(String keys) 
	{
		WebElement cityTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(FORM_CITY_TEXT_BOX_LOCATOR));
		cityTextBox.sendKeys(keys);
	}

	public void typePostCodeTextBox(String keys) 
	{
		WebElement typePostCodeTextBox = wait
				.until(ExpectedConditions.presenceOfElementLocated(FORM_POSTCODE_TEXT_BOX_LOCATOR));
		typePostCodeTextBox.sendKeys(keys);
	}

	public void typeMobilePhoneTextBox(String keys) 
	{
		WebElement mobilePhoneTextBox = wait
				.until(ExpectedConditions.presenceOfElementLocated(FORM_PHONE_MOBILE_TEXT_BOX_LOCATOR));
		mobilePhoneTextBox.sendKeys(keys);
	}

	public void typeAliasTextBox(String keys) 
	{
		WebElement aliasTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(FORM_ALIAS_TEXT_BOX_LOCATOR));
		aliasTextBox.sendKeys(keys);
	}

	public void selectCountry() 
	{

		Select stateDropDown = new Select(
				wait.until(ExpectedConditions.presenceOfElementLocated(FORM_COUNTRY_SELECT_LOCATOR)));
		stateDropDown.selectByVisibleText("United States");

	}

	public void selectState(String Key) 
	{
		
		Select stateDropDown = new Select(
				wait.until(ExpectedConditions.presenceOfElementLocated(FORM_STATE_SELECT_LOCATOR)));
		stateDropDown.selectByVisibleText("Alabama");

	}
	
	public void registerAccount() 
	{
		WebElement registerButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(FORM_SUBMIT_BUTTON_LOCATOR));
		registerButton.click();
	}
	
	public void SignOut() 
	{
		WebElement SignOut = wait
				.until(ExpectedConditions.visibilityOfElementLocated(signOut));
		SignOut.click();
	}

	
	public void registerCustomer() 
	{

		typeFirstNameTextBox("Test");
		typeLastNameTextBox("Test");
		typePasswordTextBox("12345");
		typeAddressTextBox("test");
		typeCityTextBox("Mumbai");
		typePostCodeTextBox("12135");
		selectState("");
		typeAliasTextBox("test");
		typeMobilePhoneTextBox("99999999");
		registerAccount();
		SignOut();
		

	}

	
}

package automationPractice;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.AddtoCart;
import pageObject.CartSummaryPage;
import pageObject.CreateAccount;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.RegisterUser;
import pageObject.ProductCatalogPage;
import pageObject.ProductDetails;
import pageObject.OrderHistory;



public class E2ETest extends base{
	
	double grandTotal;
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));

	}
	@Test (priority=1)
	public void basePageNavigation() throws IOException
	{

		LandingPage l=new LandingPage(driver);
		l.SignIn().click(); 
	}
	
	@Test(priority=2)
	public void createNewAccount()
	{
		CreateAccount acc = new CreateAccount(driver);
		acc.clickEmailTextBox();
		acc.clickLoginButton();
		
	}
	
	@Test(priority=3)
	public void RegisterNewUser()
	{
	RegisterUser reguser = new RegisterUser(driver);
	reguser.registerCustomer();
		
	}

	@Test(priority=4)
	public void Login()
	{

	LoginPage Loginn = new LoginPage(driver);
	Loginn.EnterEmail();
	Loginn.EnterPassword();
	Loginn.clickSigninButton();
	}

	@Test(priority=5)
	public void AddToCart() 
	{

	AddtoCart Cart = new AddtoCart(driver);
	ProductCatalogPage productPage = Cart.selectWomenMenuOption();
	productPage.getProductCount();
	ProductDetails productDetails = productPage.selectProduct(0);
	productDetails.increaseProductCount(2);
	productDetails.addProductToCart();
	productDetails.proceedToCheckOut();
	
	}

	@Test(priority=6)
	public void Checkout()
	{
	
	CartSummaryPage cs= new CartSummaryPage(driver);
	cs.completePayment();

	}

	@Test(priority=7)
	public void OrderHistory()
	{
	
	OrderHistory His= new OrderHistory(driver);
	His.AccountInfo();
	His.ViewHistory();
	//His.checkprice();
	}


	@AfterTest
	public void teardown()
	{
		
		//driver.close();
		//driver=null;
		
	}

	
	
		
		
		
	
	
}

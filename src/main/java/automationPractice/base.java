package automationPractice;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		
	prop= new Properties();
	FileInputStream fis=new FileInputStream("D:\\Eclipse\\crossAsyst\\src\\main\\java\\automationPractice\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equals("chrome"))
	{
		
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
			
		
	}
	else if (browserName.equals("firefox"))
	{
	
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//driver//geckodriver.exe");
	driver= new FirefoxDriver();
	driver.manage().window().maximize();
	
	}
	else if (browserName.equals("IE"))
	{
	
	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//driver//IEDriverServer.exe");
	driver= new InternetExplorerDriver();
	driver.manage().window().maximize();

	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;


}

}

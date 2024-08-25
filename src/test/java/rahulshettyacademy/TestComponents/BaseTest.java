package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import rahulshettyacademy.pageobjects.LandingLoginPage;

public class BaseTest  {
	public WebDriver driver;
	public LandingLoginPage loginPage;
	public WebDriver initializeDriver() throws IOException
	{
		this.driver=driver;
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
		prop.load(fis);
		String BrowserName =prop.getProperty("browser");
		
		if(BrowserName.contains("firefox"))
		{
		System.setProperty("webdriver.gecko.driver","C:/Drivers/geckodriver-v0.33.0-win64/geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize(); 
	}
		else if(BrowserName.contains("chrome"))
		{
			//chrome driver
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		return driver;
		
}
	@BeforeMethod
	public LandingLoginPage launchApplication() throws IOException
	{
		
		driver = initializeDriver();
		LandingLoginPage loginPage = new LandingLoginPage(driver);
		loginPage.goTo();
		return loginPage;
		
	}
}

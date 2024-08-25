package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstarctComponents.AbstractComponents;

public class LandingLoginPage extends AbstractComponents {
	private static final String ProductCatalogue = null;

	WebDriver driver;

	public LandingLoginPage(WebDriver driver) // constructor will going to get executed at the very begining of the class execution
	{
		super(driver);		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	// page factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	public rahulshettyacademy.pageobjects.ProductCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		return null;
	
	}
	
	public void goTo()
	{
			driver.get("https://rahulshettyacademy.com/client/");
	}

	

	

	
}
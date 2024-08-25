package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstarctComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (css=".hero-primary")
	static
	WebElement confirmationMessage;
	
	public static String VerifyConfirmationMessage()
	{
		try {
			return confirmationMessage.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}

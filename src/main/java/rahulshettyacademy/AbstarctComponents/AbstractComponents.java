package rahulshettyacademy.AbstarctComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	
public AbstractComponents(WebDriver driver) {
	this.driver =driver;
	PageFactory.initElements(driver,this); // to initiatize the page factory in the class
		
	}
@FindBy(css="[routerlink*='cart']")
WebElement cart;


public void waitForelementToAppear(By findby)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(findby)));

}
public void waitForElementToDisappear(WebElement ele) throws InterruptedException
{
	Thread.sleep(1000);
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	// wait.until(ExpectedConditions.invisibilityOf(ele));
}
public void goToCartPage()
{
	cart.click();
}
}
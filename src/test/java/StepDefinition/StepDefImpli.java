package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingLoginPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.pageobjects.cartPage;

public class StepDefImpli extends BaseTest {
	
	public LandingLoginPage loginPage;
	public ProductCatalogue productCatalogue;
	@Given("I landed on e-commerce page")
	public void i_landed_on_ecommerce_page() throws IOException
	{
		launchApplication();
	}
	
	@Given("^I logged in with username (.+)and password(.+)$") // (.+) regular exp for generic usage of data
	public void i_logged_in_with_username_and_password(String username ,String password)
	{
		try {
			ProductCatalogue productCatalogue = new ProductCatalogue(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("^I add the product (.+) to cart$")
	public void   i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		productCatalogue.goToCartPage();
		cartPage cartpage = new cartPage(driver);
	}
	@And("^checkout (.+) and submit the order$")
	public void checkout_submit_order()
	{
		Boolean match = cartPage.verifyProductDisplay(productCatalogue);
		cartPage.goToCheckOut();
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.selectcountry("Ind");
		checkout.SubmitOrder();
		ConfirmationPage confirmation = new ConfirmationPage(driver);

		
	}
@Then("Then confirmation message {string} is displayed.")
public void confirmation_message_displayed(String string)
{
	

	 String confirmationMessage = null;
	try {
		confirmationMessage = ConfirmationPage.VerifyConfirmationMessage();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	 Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));
	driver.close();
}

}
}

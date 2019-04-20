package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageobjects.OrderAdayroiFrom;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

public class OrderproductStepdefs {
	WebDriver driver;
	OrderAdayroiFrom Adayroi;
	
	//khoi tao (constructor)
	
	public OrderproductStepdefs() {
		this.driver = Hooks.driver;
		this.Adayroi = new OrderAdayroiFrom(this.driver);
	}
	
	//define actions
	
			@Given("^The user is ready login to Adayroi\\.com and staying in homepage\\.$")
			public void the_user_is_ready_login_to_Adayroi_com_and_staying_in_homepage() throws Exception {
				this.Adayroi.OrderAdayroiHome();

			}

		    @When("^The user add item from \"([^\"]*)\" into shopping cart, and the user will see product on shopping cart.$")
		    public void the_user_add_item_from_something_into_shopping_cart_and_the_user_will_see_product_on_shopping_cart(String strArg1) throws Throwable {
		    	this.Adayroi.additemtoCart();

		    }

		    @Then("^The system will be show notification \"([^\"]*)\"  $")
		    public void the_system_will_be_show_notification_something(String CompleteMessage) throws Throwable {
		       this.Adayroi.orderCompleted(CompleteMessage);
		    }
		}
		    

package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;

	@Given("^the user in the homepage$")
	public void the_user_in_the_homepage() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
	}

	@When("^I click on register link$")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

//	@When("^I entered the user data$")
//	public void i_entered_the_user_data() {
//		registerObject = new UserRegistrationPage(getDriver);
//		registerObject.userRegisteration("Islam", "Hassan", "islam@email.com", "123456");
//	}

	@When("^I entered the \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_entered_the(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstname, lastname, email, password);
	}

	@Then("^The registeration page displayed successfully$")
	public void the_registeration_page_displayed_successfully() {
		registerObject.UserLogout();
	}

}

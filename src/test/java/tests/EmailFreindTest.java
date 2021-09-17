package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFreindPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFreindTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String password = "islam123";
	String email = "islam@vvv.com";
	String firstName = "Islam";
	String lastName = "Hassan";
	String productName = "Apple MacBook Pro 13-inch";
	String FreindEmail = "freind@ff.com";
	String YourEmail = "";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailFreindPage emailFreindObject;

	// 1- User Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		Thread.sleep(4000);
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	// 2- Search for a product
	@Test(priority = 2)
	public void UserCanSearchUsingAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			searchObject.ProductSearchUsingAutosuggest("Mac");
			Assert.assertEquals(detailsObject.productNameBreadCrump.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error Occured >> " + e.getMessage());
		}
	}

	// 3- Email a friend
	@Test(priority = 3)
	public void RegisterdUserCanSendEmail() {
		detailsObject.sendEmail();
		emailFreindObject = new EmailFreindPage(driver);
		emailFreindObject.EmailFreind(FreindEmail, YourEmail);
		Assert.assertTrue(emailFreindObject.messageNotification.getText().contains("Your message has been sent."));
	}

	// 4-User Logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registerObject.UserLogout();
	}
}

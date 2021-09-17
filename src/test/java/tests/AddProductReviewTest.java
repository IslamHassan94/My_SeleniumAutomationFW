package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	UserRegistrationPage registerObject;
	ProductReviewPage reviewObject;
	LoginPage loginObject;
	String password = "islam123";
	String email = "sss@urt.com";
	String firstName = "Islam";
	String lastName = "Hassan";
	String reviewTitle = "Title";
	String reviewMessage = "message";

	// 1- Register
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	// 2- Search
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

	// 3- Add Review
	@Test(priority = 3)
	public void RegisteredUserCanAddReview() {
		reviewObject = new ProductReviewPage(driver);
		detailsObject.openReviewPage();
		reviewObject.AddProductReview(reviewTitle, reviewMessage);
		Assert.assertTrue(reviewObject.messageNotification.getText().contains("Product review is successfully added."));
	}

	// 4- Logout
	@Test(priority = 4)
	public void RegisteredUserCanLogout() {
		registerObject.UserLogout();
	}
}

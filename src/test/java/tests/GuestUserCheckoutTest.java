package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetalisPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class GuestUserCheckoutTest extends TestBase {

	/**
	 * 1-Register user 2-Search for product 3-Add to cart 4-Checkout 5-Logout
	 */

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetalisPage orderObject;
	String password = "islam123";
	String email = "islam@sax.acom";
	String firstName = "Islam";
	String lastName = "Hassan";
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
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

	@Test(priority = 2)
	public void UserCanAddProductToCart() throws InterruptedException {
		cartObject = new ShoppingCartPage(driver);
		detailsObject.addProductToCart();
		detailsObject.openShoppingCart();
		Assert.assertTrue(cartObject.ProductTitle.getText().contains(productName));
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void GuestUserCanCheckout() throws InterruptedException {
		cartObject.OpenCheckoutPage();
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.openCheckoutPageAsGuest();
		checkoutObject.GuestUserCanCheckout(firstName, lastName, email, "Egypt", "Cairo", "91 cairo,Egypt", "11856",
				"123456789", productName);
		Assert.assertTrue(checkoutObject.ProductName.isDisplayed());
		Assert.assertTrue(checkoutObject.ProductName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.thankYouLbl.isDisplayed());
		Thread.sleep(1000);
		Assert.assertTrue(
				checkoutObject.successMessage.getText().contains("Your order has been successfully processed!"));
		checkoutObject.VeiwOrderDetailes();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new OrderDetalisPage(driver);
		orderObject.downloadInvoice();
		orderObject.printOrder();
	}

}

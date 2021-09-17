package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CheckoutPage;
import pages.OrderDetalisPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class E2ETests extends TestBase {
	SearchPage searchObject;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	OrderDetalisPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String productName) throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutosuggest(productName);
		productDetails = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNameBreadCrump.getText().contains(productName));
	}

	@When("^choose to buy Two items$")
	public void choose_to_buy_Two_items() throws InterruptedException {
		cartObject = new ShoppingCartPage(driver);
		productDetails.addProductToCart();
		driver.navigate().to("http://demo.nopcommerce.com/" + "cart");
	}

	@When("^moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order()
			throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartObject.OpenCheckoutPage();
		checkoutObject.GuestUserCanCheckout("test", "user", "Egypt", "testuser1@test.com", "test address", "123456",
				"32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.ProductName.isDisplayed());
		Assert.assertTrue(checkoutObject.ProductName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.thankYouLbl.isDisplayed());

	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		orderObject = new OrderDetalisPage(driver);
		checkoutObject.VeiwOrderDetailes();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.downloadInvoice();
		Thread.sleep(3000);
		orderObject.printOrder();
	}
}

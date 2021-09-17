package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;

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
		// cartObject.UpdateProductQuantityInCart("5");
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() {
		cartObject.RemoveFromCart();
	}
}

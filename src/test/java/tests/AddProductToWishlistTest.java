package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishListObject;

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
	public void UserCanAddProductsToWishlist() {
		wishListObject = new WishlistPage(driver);
		detailsObject.addProductToWishList();
		detailsObject.openWishlistPage();
		Assert.assertTrue(wishListObject.WishListHeader.isDisplayed());
		Assert.assertTrue(wishListObject.ProductCell.getText().contains(productName));
	}

	@Test(priority = 3)
	public void UserCanRemoveProductsFromWishlist() {
		wishListObject.RemoveItemsFromWishlist();
		Assert.assertTrue(wishListObject.EmptyWishlistMessage.getText().contains("empty"));
	}
}

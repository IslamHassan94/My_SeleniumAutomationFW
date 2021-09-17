package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductsUsingAutoSuggestTest extends TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;

	@Test
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
}

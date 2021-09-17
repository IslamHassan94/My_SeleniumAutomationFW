package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	HomePage homeObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;

	@Test(priority = 1)
	public void UserCanChangeCurrency() {
		homeObject = new HomePage(driver);
		homeObject.ChangeCurrency();
	}

	@Test(priority = 2)
	public void UserCanSearchUsingAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			searchObject.ProductSearchUsingAutosuggest("Mac");
			Assert.assertEquals(detailsObject.productNameBreadCrump.getText(), productName);
			Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("€"));
		} catch (Exception e) {
			System.out.println("Error Occured >> " + e.getMessage());
		}
	}

}

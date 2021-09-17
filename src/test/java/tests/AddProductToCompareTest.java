package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.ProductToComparePage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductToComparePage compareObject;

	// 1-Search for product

	@Test(priority = 1)
	public void UserCanCompareProducts() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new ProductToComparePage(driver);

		searchObject.ProductSearchUsingAutosuggest(firstProductName);
		Assert.assertEquals(detailsObject.productNameBreadCrump.getText(), firstProductName);
		detailsObject.addProductToCompare();

		searchObject.ProductSearchUsingAutosuggest(secondProductName);
		Assert.assertEquals(detailsObject.productNameBreadCrump.getText(), secondProductName);
		detailsObject.addProductToCompare();

		detailsObject.openAddToComparePage();
		Assert.assertTrue(compareObject.FirstProductName.isDisplayed());
		Assert.assertTrue(compareObject.SecondProductName.isDisplayed());

		compareObject.CompareProducts();
	}

	@Test(priority = 2)
	public void UserCanClearList() {
		compareObject.ClearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.isDisplayed());
	}
}

package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductToComparePage extends PageBase {

	public ProductToComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.clear-list")
	private WebElement clearListLink;

	@FindBy(css = "table.compare-products-table")
	private WebElement compareTable;

	@FindBy(css = "div.no-data")
	public WebElement noDataLbl;

	@FindBy(tagName = "tr")
	public List<WebElement> allRows;

	@FindBy(tagName = "td")
	public List<WebElement> allCols;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement FirstProductName;

	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement SecondProductName;

	public void ClearCompareList() {
		clickButton(clearListLink);
	}

	public void CompareProducts() {
		// Get All Rows
		System.out.println(allRows.size());

		// Get All data in each row
		for (WebElement row : allRows) {
			System.out.println(row.getText() + "\t");
			for (WebElement col : allCols) {
				System.out.println(col.getText() + "\t");
			}
		}
	}

}

package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;

	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(id = "ui-id-1")
	List<WebElement> productList;

	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement productTitle;

	public void ProductSearch(String productName) {
		setTextElementText(searchTxtBox, productName);
		clickButton(searchBtn);
	}

	public void OpenProductDetalisPage() {
		clickButton(productTitle);
	}

	public void ProductSearchUsingAutosuggest(String searchTxt) {
		setTextElementText(searchTxtBox, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();
	}

}

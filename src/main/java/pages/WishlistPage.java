package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "h1")
	public WebElement WishListHeader;

	@FindBy(css = "td.product")
	public WebElement ProductCell;

	@FindBy(css = "button.updatecart")
	private WebElement UpdateWishlistBtn;

	@FindBy(css = "button.remove-btn")
	private WebElement RemoveBtn;

	@FindBy(css = "div.no-data")
	public WebElement EmptyWishlistMessage;

	public void RemoveItemsFromWishlist() {
		clickButton(RemoveBtn);
	}
}

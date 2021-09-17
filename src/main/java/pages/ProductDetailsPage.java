package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrump;

	@FindBy(css = "button.button-2.email-a-friend-button")
	public WebElement emailFreindbtn;

	@FindBy(id = "price-value-4")
	public WebElement productPriceLbl;

	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;

	@FindBy(id = "add-to-wishlist-button-4")
	WebElement wishlistBtn;

	@FindBy(linkText = "wishlist")
	WebElement wishlistLink;

	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement AddToCompareBtn;

	@FindBy(linkText = "product comparison")
	WebElement AddToCompareLink;

	@FindBy(id = "add-to-cart-button-4")
	WebElement AddToCartBtn;

	@FindBy(linkText = "shopping cart")
	WebElement ShoppingCartLink;

	public void sendEmail() {
		clickButton(emailFreindbtn);
	}

	public void openReviewPage() {
		clickButton(addReviewLink);
	}

	public void addProductToWishList() {
		clickButton(wishlistBtn);
	}

	public void openWishlistPage() {
		clickButton(wishlistLink);
	}

	public void addProductToCompare() {
		clickButton(AddToCompareBtn);
	}

	public void openAddToComparePage() {
		clickButton(AddToCompareLink);
	}

	public void addProductToCart() {
		clickButton(AddToCartBtn);
	}

	public void openShoppingCart() {
		clickButton(ShoppingCartLink);
	}

}

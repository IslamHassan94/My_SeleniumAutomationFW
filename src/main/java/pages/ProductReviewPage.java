package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement ReviewTitleTxt;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement ReviewTxt;

	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submitReviewBtn;

	@FindBy(id = "addproductrating_4")
	WebElement ratingRadioBtn;

	@FindBy(css = "div.result")
	public WebElement messageNotification;

	public void AddProductReview(String ReviewTitle, String ReviewMessage) {
		setTextElementText(ReviewTitleTxt, ReviewTitle);
		setTextElementText(ReviewTxt, ReviewMessage);
		clickButton(ratingRadioBtn);
		clickButton(submitReviewBtn);
	}

}

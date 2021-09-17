package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button.remove-btn")
	WebElement RemoveFromCartBtn;

	@FindBy(css = "a.product-name")
	public WebElement ProductTitle;

	@FindBy(css = "button.button-2.update-cart-button")
	WebElement UpdateCart;

	@FindBy(xpath = "//input[@id='itemquantity11230']")
	WebElement QuantityTxt;

	@FindBy(css = "span.product-subtotal")
	WebElement TotalLbl;

	@FindBy(id = "checkout")
	WebElement CheckOutBtn;

	@FindBy(id = "termsofservice")
	WebElement AgreeCheckBox;

	public void RemoveFromCart() {
		clickButton(RemoveFromCartBtn);
	}

	public void UpdateProductQuantityInCart(String qty) throws InterruptedException {
		// Clear Txt first
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		QuantityTxt = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='itemquantity11230']")));
		clearTxt(QuantityTxt);
		setTextElementText(QuantityTxt, qty);
		clickButton(UpdateCart);
	}

	public void OpenCheckoutPage() {
		clickButton(AgreeCheckBox);
		clickButton(CheckOutBtn);
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement guestBtn;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxt;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipTxt;

	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn;

	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;

	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn;

	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement continueInfoBtn;

	@FindBy(css = "a.product-name")
	public WebElement ProductName;

	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;

	@FindBy(css = "h1")
	public WebElement thankYouLbl;

	@FindBy(css = "strong")
	public WebElement successMessage;

	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;

	public void RegisteredUserCanCheckout(String countryName, String cityName, String address, String postCode,
			String phone, String productName) throws InterruptedException {
		Select select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, cityName);
		setTextElementText(addressTxt, address);
		setTextElementText(zipTxt, postCode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		Thread.sleep(3000);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
	}

	public void confirmOrder() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(confirmBtn);
	}

	public void VeiwOrderDetailes() {
		clickButton(orderDetailsLink);
	}

	public void GuestUserCanCheckout(String fName, String lName, String email, String countryName, String cityName,
			String address, String postCode, String phone, String productName) throws InterruptedException {
		setTextElementText(fnTxt, fName);
		setTextElementText(lnTxt, lName);
		setTextElementText(emailTxt, email);
		Select select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, cityName);
		setTextElementText(addressTxt, address);
		setTextElementText(zipTxt, postCode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		Thread.sleep(3000);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
	}

	public void openCheckoutPageAsGuest() {
		clickButton(guestBtn);

	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;

	@FindBy(id = "FirstName")
	WebElement fnTxtBox;

	@FindBy(id = "LastName")
	WebElement lnTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = "div.result")
	public WebElement successMessage;

	@FindBy(linkText = "Log out")
	public WebElement logoutBtn;

	@FindBy(linkText = "My account")
	WebElement myAccountLink;

	@FindBy(css = "span.close")
	public WebElement closeIcon;

	@FindBy(css = "div.master-wrapper-page")
	WebElement page;

	public void userRegisteration(String firstName, String lastName, String email, String password) {
		clickButton(genderRdoBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}

	public void UserLogout() {
		clickButton(logoutBtn);
	}

	public void OpenMyAccountPage() {
		clickButton(myAccountLink);
	}

	public void closePop() {
		clickButton(closeIcon);
	}

}

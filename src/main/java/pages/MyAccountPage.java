package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordLink;

	@FindBy(id = "OldPassword")
	WebElement oldPassword;

	@FindBy(id = "NewPassword")
	WebElement newPassword;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPassword;

	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePasswordBtn;

	@FindBy(css = "p.content")
	public WebElement passwordChangedMessage;

	public void openChangePasswordPage() {
		clickButton(changePasswordLink);
	}

	public void ChangePassword(String oldpassword, String newpassword) {
		setTextElementText(oldPassword, oldpassword);
		setTextElementText(newPassword, newpassword);
		setTextElementText(confirmNewPassword, newpassword);
		clickButton(changePasswordBtn);
	}

}

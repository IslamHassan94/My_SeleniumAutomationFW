package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFreindPage extends PageBase {

	public EmailFreindPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement FreindEmailTxt;

	@FindBy(id = "YourEmailAddress")
	WebElement YourEmailAddessTxt;

	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement SendEmailBtn;

	@FindBy(css = "div.result")
	public WebElement messageNotification;

	public void EmailFreind(String FreindEmail, String YourEmailAddress) {
		setTextElementText(FreindEmailTxt, FreindEmail);
		setTextElementText(YourEmailAddessTxt, YourEmailAddress);
		clickButton(SendEmailBtn);
	}

}

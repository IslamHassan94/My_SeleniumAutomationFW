package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computersMenu;

	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement noteBooksMenu;

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(linkText = "Contact us")
	WebElement conactUsLink;

	@FindBy(id = "customerCurrency")
	WebElement customerCurrency;

	public void openRegisterationPage() {
		clickButton(registerLink);
	}

	public void openLoginPage() {
		clickButton(loginLink);
	}

	public void openContactUsPage() {
		scrollToBottom();
		clickButton(conactUsLink);
	}

	public void ChangeCurrency() {
		select = new Select(customerCurrency);
		select.selectByVisibleText("Euro");
	}

	public void SelectNoteBooksMenu() {
		action.moveToElement(computersMenu).moveToElement(noteBooksMenu).click().build().perform();
	}

}

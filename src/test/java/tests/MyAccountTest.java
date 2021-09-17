package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;

	String oldPass = "123456";
	String newPass = "1234567";
	String email = "ppcp@qet.com";
	String firstName = "Islam";
	String lastName = "Hassan";

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPass);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void RegisterUserCanChangePassword() throws InterruptedException {
		myAccountObject = new MyAccountPage(driver);
		registerObject.OpenMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPass, newPass);
		Assert.assertTrue(myAccountObject.passwordChangedMessage.getText().contains("Password was changed"));
		registerObject.closePop();
		Thread.sleep(5000);

	}

	@Test(priority = 3)
	public void RegisteredUserCanLogout() {
		registerObject.UserLogout();
	}

	@Test(priority = 4)
	public void RegisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, newPass);
		Assert.assertTrue(registerObject.logoutBtn.isDisplayed());
		registerObject.UserLogout();
	}
}

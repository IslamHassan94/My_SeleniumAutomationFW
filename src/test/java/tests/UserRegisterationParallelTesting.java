package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationParallelTesting extends TestBase2 {
	Faker fakeData = new Faker();
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully() {
		homeObject = new HomePage(getDriver());
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(getDriver());
		registerObject.userRegisteration(firstName, lastName, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = ("UserCanRegisterSuccessfully"))
	public void RegisteredUserCanLogout() {
		registerObject.UserLogout();
	}

	@Test(dependsOnMethods = ("RegisteredUserCanLogout"))
	public void RegisteredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(getDriver());
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logoutBtn.isDisplayed());
	}
}

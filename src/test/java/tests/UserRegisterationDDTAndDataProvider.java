package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationDDTAndDataProvider extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name = "testData")
	public static Object[][] UserData() {
		return new Object[][] { { "Islam", "Hassan", "ss@ll.com", "1234567" },
				{ "ali", "ahmed", "aliahmed@qws.com", "1234567" } };
	}

	@Test(priority = 1, dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password) {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.UserLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logoutBtn.isDisplayed());
		registerObject.UserLogout();
	}

}

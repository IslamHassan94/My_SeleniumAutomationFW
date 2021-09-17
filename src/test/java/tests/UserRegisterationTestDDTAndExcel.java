package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestDDTAndExcel extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name = "ExcelData")
	public Object[][] userRegestirationData() throws IOException {
		// get data from excel reader class
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String firstName, String lastName, String email, String password) {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.UserLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logoutBtn.isDisplayed());
		registerObject.UserLogout();
	}

}

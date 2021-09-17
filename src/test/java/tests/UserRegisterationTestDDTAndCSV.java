package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegisterationTestDDTAndCSV extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	CSVReader reader;

	@Test
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException {
		// Get path of CSV file
		String CSV_Path = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.csv";
		reader = new CSVReader(new FileReader(CSV_Path));
		String[] csvCell;
		// While loop will be executed till the last line in CSV file
		while ((csvCell = reader.readNext()) != null) {
			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
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

}

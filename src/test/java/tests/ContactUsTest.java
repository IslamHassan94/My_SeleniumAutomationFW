package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

	String FullName = "Islam";
	String Email = "islam@mail.com";
	String Enquiry = "Please I want the following items. ";
	String successMessage = "Your enquiry has been successfully sent to the store owner.";

	ContactUsPage contactusObject;
	HomePage homeObject;

	@Test
	public void UserCanContactUsSuccessfully() {
		homeObject = new HomePage(driver);
		contactusObject = new ContactUsPage(driver);
		homeObject.openContactUsPage();
		contactusObject.ContactUs(FullName, Email, Enquiry);
		Assert.assertEquals(contactusObject.successMessage.getText(), successMessage);
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetalisPage extends PageBase {

	public OrderDetalisPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Print")
	WebElement printInvoiceLink;

	@FindBy(linkText = "PDF Invoice")
	WebElement pdfInvoiceLink;

	public void printOrder() {
		clickButton(printInvoiceLink);
	}

	public void downloadInvoice() throws InterruptedException {
		clickButton(pdfInvoiceLink);
		Thread.sleep(3000);
	}
}

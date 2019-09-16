package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TransactionSummaryPage {
	
	private WebDriver driver = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	By transactionPendingAlertMsg = By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]");
	By transactionPendingInfoMsg = By.xpath("//*[contains(@class, 'bold') and contains(text(), 'Transaction Pending')]");
	By price = By.xpath("//small[contains(text(),'Price:')]");
	By discount = By.xpath("//small[contains(text(),'Discount:')]");
	By totalAmountToPay = By.xpath("//*[contains(@id, 'walletCards')]//*[contains(@class, 'Select-control')]//*[contains(@class, 'Select-input') and contains(@role, 'combobox')]");
	By tripDetails = By.xpath("//h4[contains(text(),'Trip Details')]");
	By departureTime = By.xpath("//b[contains(text(),'Depart:')]");
	By busType = By.xpath("//b[contains(text(),'Bus Type:')]");
	
	
	public TransactionSummaryPage(WebDriver driver) {
		
		this.driver  = driver;
	}

	public void verifyTripDetailsIsPresent() {
		if (driver.findElement(tripDetails).isDisplayed()) {
			System.out.println("tripDetails is Present");
		} else {
			System.out.println("tripDetails is Absent");
		}
	}
	public void verifyDepartureTimeIsPresent() {
		if (driver.findElement(departureTime).isDisplayed()) {
			System.out.println("departureTime is Present");
		} else {
			System.out.println("departureTime is Absent");
		}
	}
	public void verifyBusTypeIsPresent() {
		if (driver.findElement(busType).isDisplayed()) {
			System.out.println("busType is Present");
		} else {
			System.out.println("busType is Absent");
		}
	}
	
	public void verifyTotalAmountToPayIsPresent() {
		if (driver.findElement(totalAmountToPay).isDisplayed()) {
			System.out.println("totalAmountToPay is Present");
		} else {
			System.out.println("totalAmountToPay is Absent");
		}
	}
	
	public void verifyDiscountIsPresent() {
		if (driver.findElement(discount).isDisplayed()) {
			System.out.println("discount is Present");
		} else {
			System.out.println("discount is Absent");
		}
	}
	public void verifyPriceIsPresent() {
		if (driver.findElement(price).isDisplayed()) {
			System.out.println("price is Present");
		} else {
			System.out.println("price is Absent");
		}
	}
	
	public void verifyTransactionPendingAlertMsgIsPresent() {
		if (driver.findElement(transactionPendingAlertMsg).isDisplayed()) {
			System.out.println("transactionPendingAlertMsg is Present");
		} else {
			System.out.println("transactionPendingAlertMsg is Absent");
		}
	}
	
	public void verifyTransactionPendingInfoMsgIsPresent() {
		if (driver.findElement(transactionPendingInfoMsg).isDisplayed()) {
			System.out.println("transactionPendingInfoMsg is Present");
		} else {
			System.out.println("transactionPendingInfoMsg is Absent");
		}
	}
	
}


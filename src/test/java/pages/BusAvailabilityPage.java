package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class BusAvailabilityPage {
	
	private WebDriver driver = null;
	
	By viewSeatsButton = By.xpath("//button[@class='btn btn-view-seats']");
	By seatNumber4 = By.xpath("//span[contains(text(),'4')]");
	By seatNumber5 = By.xpath("//span[contains(text(),'5')]");
	By seatNumber6 = By.xpath("//span[contains(text(),'6')]");
	By seatNumber7 = By.xpath("//span[contains(text(),'7')]");
	By seatNumber8 = By.xpath("//span[contains(text(),'8')]");
	By seatNumber9 = By.xpath("//span[contains(text(),'9')]");
	By seatNumber10 = By.xpath("//span[contains(text(),'10')]");
	By seatNumber11 = By.xpath("//span[contains(text(),'11')]");
	By seatNumber12 = By.xpath("//span[contains(text(),'12')]");
	By seatNumber13 = By.xpath("//span[contains(text(),'13')]");
	By seatExceededPopopAlert = By.xpath("//button[@class='confirm']");
	By continueButton = By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']");
	By continueWithoutLoginButton = By.xpath("//a[@id='ContentPlaceHolder2_lnkContinuebtn']");
	
	public BusAvailabilityPage(WebDriver driver) {
		
		this.driver  = driver;
	}

	
	public void clickOnContinueWithoutLoginButton(){
		driver.findElement(continueWithoutLoginButton).click();
		System.out.println("continueWithoutLoginButton Successfully clicked On");
	}
	public void clickOnContinueButton(){
		driver.findElement(continueButton).click();
		System.out.println("continueButton Successfully clicked On");
	}
	public void clickOnSeatExceededPopopAlert(){
		driver.findElement(seatExceededPopopAlert).click();
		System.out.println("seatExceededPopopAlert Successfully clicked On");
	}
	
	public void verifySeatExceededPoPopAlertIsPresent() {
		if (driver.findElement(seatExceededPopopAlert).isDisplayed()) {
			System.out.println("seatExceededPopopAlert is Present");
		} else {
			System.out.println("seatExceededPopopAlert is Absent");
		}
	}
	public void clickOnViewSeatsButton(){
		driver.findElement(viewSeatsButton).click();
		System.out.println("viewSeatsButton Successfully clicked On");
	}

	public void selectSeatNumber4(){
		driver.findElement(seatNumber4).click();
		System.out.println("seatNumber4 successfully Selected");
	}

	public void selectSeatNumber5(){
		driver.findElement(seatNumber5).click();
		System.out.println("seatNumber4 successfully Selected");
	}
	
	public void selectSeatNumber6(){
		driver.findElement(seatNumber6).click();
		System.out.println("seatNumber6 successfully Selected");
	}
	
	public void selectSeatNumber7(){
		driver.findElement(seatNumber7).click();
		System.out.println("seatNumber7 successfully Selected");
	}
	
	public void selectSeatNumber8(){
		driver.findElement(seatNumber8).click();
		System.out.println("seatNumber8 successfully Selected");
	}
	public void selectSeatNumber9(){
		driver.findElement(seatNumber9).click();
		System.out.println("seatNumber9 successfully Selected");
	}
	
	public void selectSeatNumber10(){
		driver.findElement(seatNumber10).click();
		System.out.println("seatNumber10 successfully Selected");
	}
	public void selectSeatNumber11(){
		driver.findElement(seatNumber11).click();
		System.out.println("seatNumber11 successfully Selected");
	}
	public void selectSeatNumber12(){
		driver.findElement(seatNumber12).click();
		System.out.println("seatNumber12 successfully Selected");
	}
	public void selectSeatNumber13(){
		driver.findElement(seatNumber13).click();
		System.out.println("seatNumber13 successfully Selected");
	}
	
	
}


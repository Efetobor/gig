package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class PassengerDetailsPage {
	
	private WebDriver driver = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	By fullNameField = By.xpath("//input[@id='ContentPlaceHolder2_txtFullname1']");
	By arrowDropdownGenderField = By.xpath("//select[@id='ContentPlaceHolder2_ddlgender1']");
	By male = By.xpath("//option[contains(text(),'Male')]");
	By female = By.xpath("//option[contains(text(),'Female')]");
	By emailAddField = By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']");
	By phoneNumberField = By.xpath("//input[@id='ContentPlaceHolder2_txtphone1']");
	By nextOfKinsName = By.xpath("//input[@id='ContentPlaceHolder2_txtnextofkin1']");
	By nextOfKinsPhoneNumber = By.xpath("//input[@id='ContentPlaceHolder2_txtnextofkinphone1']");
	By fbnUssdPaymentMethod = By.xpath("//a[@id='lnkbtnFbnUssd2']//img[@class='img-responsive']");
	By unionBankUSSD = By.xpath("//a[@id='lnkbtnUbnUssd2']//img[@class='img-responsive']");
	By noPickUpCheckBox = By.xpath("//input[@id='pickupNo']");
	
	
	
	public PassengerDetailsPage(WebDriver driver) {
		
		this.driver  = driver;
	}

	public void checkTheNoIWillJoinTheBusAtTerminalCheckBox(){
		driver.findElement(noPickUpCheckBox).click();
		System.out.println("noPickUpCheckBox successfully clicked On");
	}
	public void clickOnFBNUSSD(){
		driver.findElement(fbnUssdPaymentMethod).click();
		System.out.println("fbnUssdPaymentMethod successfully clicked On");
	}
	public void EnterNextOfKinsPhoneNumber(String text) {
		driver.findElement(nextOfKinsPhoneNumber).sendKeys(text);
		System.out.println("nextOfKinsPhoneNumber Successfully Entered");
	}
	public void EnterNextOfKinsName(String text) {
		driver.findElement(nextOfKinsName).sendKeys(text);
		System.out.println("nextOfKinsName Successfully Entered");
	}
	public void EnterPhoneNumber(String text) {
		driver.findElement(phoneNumberField).sendKeys(text);
		System.out.println("phoneNumberField Successfully Entered");
	}
	public void EnterEmailAddress(String text) {
		driver.findElement(emailAddField).sendKeys(text);
		System.out.println("emailAddField Successfully Entered");
	}
	public void selectFemaleFromDropDown(){
		driver.findElement(female).click();
		System.out.println("female successfully clicked On");
	}
	public void selectMaleFromDropDown(){
		driver.findElement(male).click();
		System.out.println("male successfully clicked On");
	}
	public void clickOnArrowDropdownGenderField(){
		driver.findElement(arrowDropdownGenderField).click();
		System.out.println("arrowDropdownGenderField successfully clicked On");
	}
	
	public void EnterfullName(String text) {
		driver.findElement(fullNameField).sendKeys(text);
		System.out.println("fullNameField Successfully Entered");
	}
	

	
	
	
	
	
}


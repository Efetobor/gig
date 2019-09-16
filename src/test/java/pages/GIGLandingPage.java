package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class GIGLandingPage {
	
	private WebDriver driver = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	By closeButton = By.xpath("//span[contains(text(),'close')]");
	By departureTerminalDropdownArrow = By.xpath("//span[@class='select2-selection__arrow']//b");
	By destinationDropdown = By.xpath("//select[@id='ContentPlaceHolder2_ddlto']");
	By bookNowButton = By.xpath("//input[@id='ContentPlaceHolder2_Button1']");
	By lagosIyanaIpajaParkDeparture = By.xpath("//*[contains(@class, 'select2-results__option') and contains(text(), 'Lagos => Iyana Ipaja')]");
	By abiaAbaDestination = By.xpath("//option[contains(text(),'Abia-Aba')]");

	////*[contains(@class, 'bold') and contains(text(), 'Transaction Pending')]
	
	
	public GIGLandingPage(WebDriver driver) {
		
		this.driver  = driver;
	}

	public void selectLagosIyanaIpajaParkDeparture(){
		driver.findElement(lagosIyanaIpajaParkDeparture).click();
		System.out.println("lagosIyanaIpajaParkDeparture successfully clicked On");
	}
	public void selectAbiaAbaDestination(){
		driver.findElement(abiaAbaDestination).click();
		System.out.println("abiaAbaDestination successfully clicked On");
	}
	public void clickOnCloseButton(){
		driver.findElement(closeButton).click();
		System.out.println("close button successfully clicked On");
	}

	public void clickOnDepartureTerminalDropdownArrow(){
		driver.findElement(departureTerminalDropdownArrow).click();
		System.out.println("departureTerminalDropdownArrow successfully clicked On");
	}

	public void clickOnDestinationDropdown(){
		driver.findElement(destinationDropdown).click();
		System.out.println("destinationDropdown successfully clicked On");
	}
	
	public void clickOnBookNowButton(){
		driver.findElement(bookNowButton).click();
		System.out.println("bookNowButton successfully clicked On");
	}
	
}


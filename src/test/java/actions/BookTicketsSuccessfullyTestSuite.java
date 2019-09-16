package actions;

import org.testng.annotations.Test;

import methods.NavigateToURL;
import methods.StartBrowser;
import methods.URL;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.PassengerDetailsPage;
import pages.TransactionSummaryPage;
import pages.BusAvailabilityPage;
import pages.GIGLandingPage;

public class BookTicketsSuccessfullyTestSuite {
	static WebDriver driver = null;
	URL baseUrl = new URL();
	

	@BeforeTest
	public void startUp() throws IOException {
		StartBrowser openConnection = new StartBrowser(driver);
		driver = openConnection.initializeBrowser();
	}

	@Test(priority = 1)
	public void bookAOneWayTicketSuccessfully() {
		NavigateToURL startWebsite = new NavigateToURL(driver);
		startWebsite.launchURL();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		GIGLandingPage bookTicket = new GIGLandingPage(driver);
		if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
			System.out.println("Download GIGM Ad still present on the screen");
		
		bookTicket.clickOnCloseButton();
	
		WebElement contactUs = driver.findElement(By.xpath("//div[@class='row minicard-row']//div[1]//div[1]//a[1]"));
		js.executeScript("arguments[0].scrollIntoView();", contactUs);
		bookTicket.clickOnDepartureTerminalDropdownArrow();
		bookTicket.selectLagosIyanaIpajaParkDeparture();
		
		WebElement contactUs2 = driver.findElement(By.xpath("//div[@class='row minicard-row']//div[1]//div[1]//a[1]"));
		js.executeScript("arguments[0].scrollIntoView();", contactUs2);
		bookTicket.clickOnDestinationDropdown();
		
		bookTicket.selectAbiaAbaDestination();
		
		bookTicket.clickOnBookNowButton();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-view-seats']")));
		
		BusAvailabilityPage checkBusAvailability = new BusAvailabilityPage(driver);
		checkBusAvailability.clickOnViewSeatsButton();
		checkBusAvailability.selectSeatNumber13();
		checkBusAvailability.selectSeatNumber12();
		if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
			System.out.println("Exceeded Number of Seats POP UP Element is Present");
			checkBusAvailability.clickOnSeatExceededPopopAlert();
			checkBusAvailability.clickOnContinueButton();
			
			checkBusAvailability.clickOnContinueWithoutLoginButton();
			
			PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
			EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
			EnterPassengerDetails.EnterfullName("Test01");
			EnterPassengerDetails.clickOnArrowDropdownGenderField();
			EnterPassengerDetails.selectMaleFromDropDown();
		
			WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
			js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
			
			EnterPassengerDetails.EnterEmailAddress("test@testing.com");
			EnterPassengerDetails.EnterPhoneNumber("08000000000");
			EnterPassengerDetails.EnterNextOfKinsName("Mother");
			EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
			EnterPassengerDetails.clickOnFBNUSSD();
			
			driver.switchTo().alert().accept();
			
			//This is to wait until the Transaction summary page displays
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
			
			TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
			TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
			TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
			
			}else if(driver.findElements(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']")).size() != 0){
				checkBusAvailability.selectSeatNumber11();
			
				if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
					System.out.println("Exceeded Number of Seats POP UP Element is Present");
					checkBusAvailability.clickOnSeatExceededPopopAlert();
					checkBusAvailability.clickOnContinueButton();
					
					checkBusAvailability.clickOnContinueWithoutLoginButton();
					
					PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
					EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
					
					EnterPassengerDetails.EnterfullName("Test01");
					EnterPassengerDetails.clickOnArrowDropdownGenderField();
					EnterPassengerDetails.selectMaleFromDropDown();
					
					WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
					js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
					
					EnterPassengerDetails.EnterEmailAddress("test@testing.com");
					EnterPassengerDetails.EnterPhoneNumber("08000000000");
					EnterPassengerDetails.EnterNextOfKinsName("Mother");
					EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
					EnterPassengerDetails.clickOnFBNUSSD();
					
					driver.switchTo().alert().accept();
				
					//This is to wait until the Transaction summary page displays
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
					
					TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
					TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
					TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
				
				}else if(driver.findElements(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']")).size() != 0){
					System.out.println("Chosen Seat is Not Free");
					checkBusAvailability.selectSeatNumber10();
					if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
						System.out.println("Exceeded Number of Seats POP UP Element is Present");
						checkBusAvailability.clickOnSeatExceededPopopAlert();
						checkBusAvailability.clickOnContinueButton();
						
						checkBusAvailability.clickOnContinueWithoutLoginButton();
						
						PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
						EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
						EnterPassengerDetails.EnterfullName("Test01");
						EnterPassengerDetails.clickOnArrowDropdownGenderField();
						EnterPassengerDetails.selectMaleFromDropDown();
					
						WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
						js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
						
						EnterPassengerDetails.EnterEmailAddress("test@testing.com");
						EnterPassengerDetails.EnterPhoneNumber("08000000000");
						EnterPassengerDetails.EnterNextOfKinsName("Mother");
						EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
						EnterPassengerDetails.clickOnFBNUSSD();
					
						driver.switchTo().alert().accept();
					
						//This is to wait until the Transaction summary page displays
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
					
						TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
						TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
						TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
					
					}
						else if(driver.findElements(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']")).size() != 0){
							System.out.println("Chosen Seat is Not Free");
							checkBusAvailability.selectSeatNumber9();
							if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
								System.out.println("Exceeded Number of Seats POP UP Element is Present");
								checkBusAvailability.clickOnSeatExceededPopopAlert();
								checkBusAvailability.clickOnContinueButton();
							
								checkBusAvailability.clickOnContinueWithoutLoginButton();
							
								PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
								EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
								EnterPassengerDetails.EnterfullName("Test01");
								EnterPassengerDetails.clickOnArrowDropdownGenderField();
								EnterPassengerDetails.selectMaleFromDropDown();
							
								WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
								js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
								
								EnterPassengerDetails.EnterEmailAddress("test@testing.com");
								EnterPassengerDetails.EnterPhoneNumber("08000000000");
								EnterPassengerDetails.EnterNextOfKinsName("Mother");
								EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
								EnterPassengerDetails.clickOnFBNUSSD();
								
								driver.switchTo().alert().accept();
								
								//This is to wait until the Transaction summary page displays
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
								
								TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
								TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
								TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
								
								
							}else if(driver.findElements(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']")).size() != 0){
								System.out.println("Chosen Seat is Not Free");
								checkBusAvailability.selectSeatNumber8();
								checkBusAvailability.clickOnContinueButton();
							
								checkBusAvailability.clickOnContinueWithoutLoginButton();
							
								PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
								EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
								EnterPassengerDetails.EnterfullName("Test01");
								EnterPassengerDetails.clickOnArrowDropdownGenderField();
								EnterPassengerDetails.selectMaleFromDropDown();
							
								WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
								js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
								
								EnterPassengerDetails.EnterEmailAddress("test@testing.com");
								EnterPassengerDetails.EnterPhoneNumber("08000000000");
								EnterPassengerDetails.EnterNextOfKinsName("Mother");
								EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
								EnterPassengerDetails.clickOnFBNUSSD();
							
								driver.switchTo().alert().accept();
							
								//This is to wait until the Transaction summary page displays
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
							
								TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
								TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
								TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
								
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}else{
								checkBusAvailability.clickOnContinueButton();
								
								checkBusAvailability.clickOnContinueWithoutLoginButton();
							
								PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
								EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
								EnterPassengerDetails.EnterfullName("Test01");
								EnterPassengerDetails.clickOnArrowDropdownGenderField();
								EnterPassengerDetails.selectMaleFromDropDown();
							
								WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
								js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
								
								EnterPassengerDetails.EnterEmailAddress("test@testing.com");
								EnterPassengerDetails.EnterPhoneNumber("08000000000");
								EnterPassengerDetails.EnterNextOfKinsName("Mother");
								EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
								EnterPassengerDetails.clickOnFBNUSSD();
							
								driver.switchTo().alert().accept();
							
								//This is to wait until the Transaction summary page displays
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
							
								TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
								TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
								TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
								
					//so User can see the TransactionSummaryBefore Test Completes
								try {
									Thread.sleep(4000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
				}
				
			}
			
			}
		
		}else{
		
			
			WebElement contactUs = driver.findElement(By.xpath("//div[@class='row minicard-row']//div[1]//div[1]//a[1]"));
			js.executeScript("arguments[0].scrollIntoView();", contactUs);
			bookTicket.clickOnDepartureTerminalDropdownArrow();
			bookTicket.selectLagosIyanaIpajaParkDeparture();
		
			WebElement contactUs2 = driver.findElement(By.xpath("//div[@class='row minicard-row']//div[1]//div[1]//a[1]"));
			js.executeScript("arguments[0].scrollIntoView();", contactUs2);
			bookTicket.clickOnDestinationDropdown();
		
			bookTicket.selectAbiaAbaDestination();
		
			bookTicket.clickOnBookNowButton();
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-view-seats']")));
			
			BusAvailabilityPage checkBusAvailability = new BusAvailabilityPage(driver);
			checkBusAvailability.clickOnViewSeatsButton();
			checkBusAvailability.selectSeatNumber13();
			checkBusAvailability.selectSeatNumber12();
			if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
				System.out.println("Exceeded Number of Seats POP UP Element is Present");
				checkBusAvailability.clickOnSeatExceededPopopAlert();
				checkBusAvailability.clickOnContinueButton();
				
				checkBusAvailability.clickOnContinueWithoutLoginButton();
				
				PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
				EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
				EnterPassengerDetails.EnterfullName("Test01");
				EnterPassengerDetails.clickOnArrowDropdownGenderField();
				EnterPassengerDetails.selectMaleFromDropDown();
			
				WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
				js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
				
				EnterPassengerDetails.EnterEmailAddress("test@testing.com");
				EnterPassengerDetails.EnterPhoneNumber("08000000000");
				EnterPassengerDetails.EnterNextOfKinsName("Mother");
				EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
				EnterPassengerDetails.clickOnFBNUSSD();
			
				driver.switchTo().alert().accept();
			
				//This is to wait until the Transaction summary page displays
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
			
				TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
				TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
				TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
		
				}else if(driver.findElements(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']")).size() != 0){
					checkBusAvailability.selectSeatNumber11();
				
					if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
						System.out.println("Exceeded Number of Seats POP UP Element is Present");
						checkBusAvailability.clickOnSeatExceededPopopAlert();
						checkBusAvailability.clickOnContinueButton();
						
						checkBusAvailability.clickOnContinueWithoutLoginButton();
					
						PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
						EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
					
						EnterPassengerDetails.EnterfullName("Test01");
						EnterPassengerDetails.clickOnArrowDropdownGenderField();
						EnterPassengerDetails.selectMaleFromDropDown();
					
						WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
						js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
						
						EnterPassengerDetails.EnterEmailAddress("test@testing.com");
						EnterPassengerDetails.EnterPhoneNumber("08000000000");
						EnterPassengerDetails.EnterNextOfKinsName("Mother");
						EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
						EnterPassengerDetails.clickOnFBNUSSD();
					
						driver.switchTo().alert().accept();
						
						//This is to wait until the Transaction summary page displays
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
						
						TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
						TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
						TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
					
						
					}else if(driver.findElements(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']")).size() != 0){
						System.out.println("Chosen Seat is Not Free");
						checkBusAvailability.selectSeatNumber10();
						if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
							System.out.println("Exceeded Number of Seats POP UP Element is Present");
							checkBusAvailability.clickOnSeatExceededPopopAlert();
							checkBusAvailability.clickOnContinueButton();
						
							checkBusAvailability.clickOnContinueWithoutLoginButton();
						
							PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
							EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
							EnterPassengerDetails.EnterfullName("Test01");
							EnterPassengerDetails.clickOnArrowDropdownGenderField();
							EnterPassengerDetails.selectMaleFromDropDown();
						
							WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
							js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
							
							EnterPassengerDetails.EnterEmailAddress("test@testing.com");
							EnterPassengerDetails.EnterPhoneNumber("08000000000");
							EnterPassengerDetails.EnterNextOfKinsName("Mother");
							EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
							EnterPassengerDetails.clickOnFBNUSSD();
						
							driver.switchTo().alert().accept();
							
							//This is to wait until the Transaction summary page displays
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
						
							TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
							TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
							TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
							
						
						}
							else if(driver.findElements(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']")).size() != 0){
								System.out.println("Chosen Seat is Not Free");
								checkBusAvailability.selectSeatNumber9();
								if(driver.findElements(By.xpath("//button[@class='confirm']")).size() != 0){
									System.out.println("Exceeded Number of Seats POP UP Element is Present");
									checkBusAvailability.clickOnSeatExceededPopopAlert();
									checkBusAvailability.clickOnContinueButton();
								
									checkBusAvailability.clickOnContinueWithoutLoginButton();
								
									PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
									EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
									EnterPassengerDetails.EnterfullName("Test01");
									EnterPassengerDetails.clickOnArrowDropdownGenderField();
									EnterPassengerDetails.selectMaleFromDropDown();
							
									WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
									js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
									
									EnterPassengerDetails.EnterEmailAddress("test@testing.com");
									EnterPassengerDetails.EnterPhoneNumber("08000000000");
									EnterPassengerDetails.EnterNextOfKinsName("Mother");
									EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
									EnterPassengerDetails.clickOnFBNUSSD();
								
									driver.switchTo().alert().accept();
								
									//This is to wait until the Transaction summary page displays
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
								
									TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
									TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
									TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
									
								
								}else if(driver.findElements(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']")).size() != 0){
									System.out.println("Chosen Seat is Not Free");
									checkBusAvailability.selectSeatNumber8();
									checkBusAvailability.clickOnContinueButton();
								
									checkBusAvailability.clickOnContinueWithoutLoginButton();
								
									PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
									EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
									EnterPassengerDetails.EnterfullName("Test01");
									EnterPassengerDetails.clickOnArrowDropdownGenderField();
									EnterPassengerDetails.selectMaleFromDropDown();
								
									WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
									js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
									
									EnterPassengerDetails.EnterEmailAddress("test@testing.com");
									EnterPassengerDetails.EnterPhoneNumber("08000000000");
									EnterPassengerDetails.EnterNextOfKinsName("Mother");
									EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
									EnterPassengerDetails.clickOnFBNUSSD();
								
									driver.switchTo().alert().accept();
								
									//This is to wait until the Transaction summary page displays
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
									
									TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
									TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
									TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
									
								
								}else{
									checkBusAvailability.clickOnContinueButton();
								
									checkBusAvailability.clickOnContinueWithoutLoginButton();
								
									PassengerDetailsPage EnterPassengerDetails = new PassengerDetailsPage(driver);
									EnterPassengerDetails.checkTheNoIWillJoinTheBusAtTerminalCheckBox();
									EnterPassengerDetails.EnterfullName("Test01");
									EnterPassengerDetails.clickOnArrowDropdownGenderField();
									EnterPassengerDetails.selectMaleFromDropDown();
								
									WebElement emailAddressField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtemail1']"));
									js.executeScript("arguments[0].scrollIntoView();", emailAddressField);
									
									EnterPassengerDetails.EnterEmailAddress("test@testing.com");
									EnterPassengerDetails.EnterPhoneNumber("08000000000");
									EnterPassengerDetails.EnterNextOfKinsName("Mother");
									EnterPassengerDetails.EnterNextOfKinsPhoneNumber("09000000000");
									EnterPassengerDetails.clickOnFBNUSSD();
								
									driver.switchTo().alert().accept();
									
									//This is to wait until the Transaction summary page displays
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'alert alert-danger') and contains(text(), 'Kindly note that this booking would expire after 1 hour if payment is not made')]")));
									
									TransactionSummaryPage TransactionSummaryPageObjects = new TransactionSummaryPage(driver);
									TransactionSummaryPageObjects.verifyTransactionPendingInfoMsgIsPresent();
									TransactionSummaryPageObjects.verifyTransactionPendingAlertMsgIsPresent();
									
								}
								
					}
					
				}
				
				}
			
		}
		
		
		System.out.println("bookAOneWayTicketSuccessfully Test Passed");
	
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}

package methods;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
	private WebDriver driver = null;
		
	public StartBrowser(WebDriver driver) {
		
		this.driver  = driver;
	}
	
	public WebDriver initializeBrowser() throws IOException {
			Properties config = new Properties(); 
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
			config.load(fis);
			String browserName = config.getProperty("browser");
			/*System.out.println("browserNAME=" + browserName);
			System.out.println("chrome".getClass().getName());*/
			if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");	
			this.driver = new ChromeDriver();
			}
			else if (browserName.equals("fireFox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");	
			this.driver = new FirefoxDriver();
			}
			else {
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriver\\IEDriverServer.exe");	
				driver = new FirefoxDriver();
			}
						
			System.out.println("Browser Initialize. Test Passed");
			return driver;

		}
		

	}


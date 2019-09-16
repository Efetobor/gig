package methods;

import org.testng.annotations.Test;
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

public class NavigateToURL {
		WebDriver driver;
		URL baseUrl = new URL();

		public NavigateToURL(WebDriver driver) {
			this.driver = driver;
		}
		public void launchURL() {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(baseUrl.giGLandingPage());
			driver.manage().window().maximize();
						
			System.out.println("Browser Launched Successfully. Test Passed");
		}

	}


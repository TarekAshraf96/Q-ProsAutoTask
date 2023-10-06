package tests;

import java.time.Duration;
import java.util.UUID;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.netty.handler.timeout.TimeoutException;
import pages.registerPage;
import pages.loginPage;

public class register_Test {

	
	
private static WebDriver driver;
	
	
	@BeforeTest
  	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
	}
	
	
	@Test
	public static void SignupToSystem() {
		registerPage register_Page = new registerPage(driver);
		loginPage login_Page = new loginPage(driver);
		
		
		String userName = UUID.randomUUID().toString();
		String password = UUID.randomUUID().toString();
		
		register_Page.signUpToWebsite(userName, password);
		register_Page.CheckAlertPresencse();
		
		login_Page.loginToWebsite(userName, password);
		
		String actualUserName = login_Page.checkUserNameDisplayed();
		String expectedUserName = "Welcome " + userName +"";
		
		Assert.assertEquals(expectedUserName, actualUserName);
		
	}
	@AfterTest
    public void tearDown()
    {
       driver.quit();
  
    }
	
}

package tests;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.*;
import pages.loginPage;

public class login_Test {

	private static WebDriver driver;
	
	
	@BeforeTest
  	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
	}
	
	
	@Test
	public static void loginSuccesfullytoSystem() {
		loginPage login_Page = new loginPage(driver);
		
		login_Page.loginToWebsite("MainUser", "Abcd1234");
	
		String actualUserName = login_Page.checkUserNameDisplayed();
		String expectedUserName = "Welcome MainUser";
		
		Assert.assertEquals(expectedUserName, actualUserName);
		
	}
	@AfterTest
    public void tearDown()
    {
       driver.quit();
  
    }
}

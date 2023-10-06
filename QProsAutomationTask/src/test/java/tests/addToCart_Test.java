package tests;

import org.junit.Assert;
import org.openqa.selenium.Alert;
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

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import pages.addToCartPage;

public class addToCart_Test {

	private static WebDriver driver;

	@BeforeTest
  	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
	}
	
	@Test
	public static void checkAddingItemToCart() {
		String TargetItem = "Samsung galaxy s6";
		addToCartPage addToCart_Page = new addToCartPage(driver);
		
		addToCart_Page.addItemToCart(TargetItem);
		
		addToCart_Page.itemAddedAlert();
		
		addToCart_Page.checkItemDisplay(TargetItem);
		
	}
	
	@Test
	public static void checkRemovingItemFromCart() {
		String TargetItem = "Samsung galaxy s6";
		addToCartPage addToCart_Page = new addToCartPage(driver);
		
		addToCart_Page.addItemToCart(TargetItem);
		
		addToCart_Page.itemAddedAlert();
		
		addToCart_Page.removeItemFromCart(TargetItem);
		
		addToCart_Page.checkItemIsRemoved(TargetItem);
		
	}
	
	
	@Test
	public static void checkItemCheckout() {
		String TargetItem = "Samsung galaxy s6";
		String userName = "Test User";
		String country = "Egypt";
		String city = "Nasr City";
		String creditCard = "3782 8224 6310 005";
		String month = "01/12";
		String year = "1/30";
		
		
		addToCartPage addToCart_Page = new addToCartPage(driver);
		
		addToCart_Page.addItemToCart(TargetItem);
		
		addToCart_Page.itemAddedAlert();
		
		addToCart_Page.checkItemDisplay(TargetItem);
		
		addToCart_Page.purchaseItems(userName, country, city, creditCard, month, year);
		addToCart_Page.checkPurchaseConfirmation();
		
	}
	
	
	@AfterTest
    public void tearDown()
    {
       driver.quit();
  
    }
	
}

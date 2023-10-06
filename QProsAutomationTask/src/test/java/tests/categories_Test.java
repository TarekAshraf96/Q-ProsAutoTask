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
import java.util.Arrays;
import java.util.List;
import pages.loginPage;
import pages.categoriesPage;

public class categories_Test {

	private static WebDriver driver;
	
	@BeforeTest
  	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
	}
	
	@Test
	public static void checkItemsDisplayeInCategories() {
		
		categoriesPage categories_Page = new categoriesPage(driver);

        List<String> categoryNames = Arrays.asList("Phones", "Laptops", "Monitors");
        categories_Page.clickCategoryAndVerifyProducts(categoryNames);
		
	}
	
	
	@AfterTest
    public void tearDown()
    {
       driver.quit();
  
    }
}

package pages;

import java.time.Duration;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;




public class addToCartPage {
	
	private WebDriver driver;

    public addToCartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    By addToCartButton = By.xpath("//a[text()= 'Add to cart']");
    By cartPage = By.xpath("//a[text() = 'Cart']");
    By cartTableBody = By.id("tbodyid");
    By cartTableRow = By.xpath("//tr[@class = 'success']");
    By placeOrderButton = By.xpath("//button[text() = 'Place Order']");
    By paymentNameField = By.id("name");
    By paymentCountryField = By.id("country");
    By paymentCityField = By.id("city");
    By paymentCreditCardField = By.id("card");
    By paymentMonthField = By.id("month");
    By paymentYearField = By.id("year");
    By purchaseButton = By.xpath("//button[text() = 'Purchase']");
    By purchaseCompleteMsg = By.xpath("//div[@class = 'sweet-alert  showSweetAlert visible']/h2");
    By productElements = By.xpath("//div[@class = 'col-lg-4 col-md-6 mb-4']");
    
    
    public void addItemToCart(String itemName) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	String targetItem = "//a[text() = '" + itemName + "']";
    	wait.until(ExpectedConditions.visibilityOfElementLocated(productElements));
        driver.findElement(By.xpath(targetItem)).click();
        
        
    	wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
    	
    	driver.findElement(addToCartButton).click();
    	itemAddedAlert();
    	
    	
    }
    
    public void itemAddedAlert() {
    	try {
    	    Alert alert = driver.switchTo().alert();
    	    alert.accept();
    	} catch (NoAlertPresentException e) {
    	    // Handle the case where no alert is present
    	}
    }
    
    public void checkItemDisplay(String expectedItemName)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept(); // Accept the alert
        } catch (TimeoutException e) {
            // Handle the case where no alert is present
        }
    	
    	driver.findElement(cartPage).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cartTableRow));
    	driver.findElement(cartTableBody).isDisplayed();
    	driver.findElement(cartTableRow).isDisplayed();
    	driver.findElement(By.xpath("//td[text() = '" + expectedItemName + "']")).isDisplayed();
    }
    
    public void removeItemFromCart(String itemName) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept(); // Accept the alert
        } catch (TimeoutException e) {
            // Handle the case where no alert is present
        }
    	
        driver.findElement(cartPage).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text() = '" + itemName + "']/following-sibling::td/a")));
        WebElement deleteLinkElement = driver.findElement(By.xpath("//td[text() = '" + itemName + "']/following-sibling::td/a"));

        deleteLinkElement.click();
    	
    }
    
    
    public void checkItemIsRemoved(String expectedItemName)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text() = '" + expectedItemName + "']")));
        
        Assert.assertTrue(true); 
    	
    }

    public void purchaseItems(String Name, String Country, String City, String Card, String Month, String Year) {
    	
    	driver.findElement(placeOrderButton).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));
    	
    	driver.findElement(paymentNameField).sendKeys(Name);
    	driver.findElement(paymentCountryField).sendKeys(Country);
    	driver.findElement(paymentCityField).sendKeys(City);
    	driver.findElement(paymentCreditCardField).sendKeys(Card);
    	driver.findElement(paymentMonthField).sendKeys(Month);
    	driver.findElement(paymentYearField).sendKeys(Year);
    	
    	driver.findElement(purchaseButton).click();
    }
    
    public void checkPurchaseConfirmation() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(purchaseCompleteMsg));
		
		WebElement userElement = driver.findElement(purchaseCompleteMsg);
        String msgText = userElement.getText();
        String expectedMessage = "Thank you for your purchase!";
		Assert.assertEquals(expectedMessage, msgText);
    }

}

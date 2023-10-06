package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class registerPage {

	
	WebDriver driver = null;
	
	By signUpOption = By.id("signin2");
	By username_Field = By.id("sign-username");
	By password_Field = By.id("sign-password");
	By signUpButton = By.xpath("//button[text() = 'Sign up']");
	
	
	public registerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void signUpToWebsite(String username, String password) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpOption));
		driver.findElement(signUpOption).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
		
		driver.findElement(username_Field).sendKeys(username);
		driver.findElement(password_Field).sendKeys(password);
		driver.findElement(signUpButton).click();
		signUpAlert();
	}
	public void signUpAlert() {
    	try {
    	    Alert alert = driver.switchTo().alert();
    	    alert.accept();
    	} catch (NoAlertPresentException e) {
    	    // Handle the case where no alert is present
    	}
    }
	
	public void CheckAlertPresencse() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
          Alert alert = wait.until(ExpectedConditions.alertIsPresent());
         alert.accept(); 
		} catch (TimeoutException e) {    
	}
    }
	
}

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	
	WebDriver driver = null;
	
	By loginOption = By.id("login2");
	By username_Field = By.id("loginusername");
	By password_Field = By.id("loginpassword");
	By loginButton = By.xpath("//button[text() = 'Log in']");
	By welcomeUser = By.id("nameofuser");
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void loginToWebsite(String username, String password) {
		
		driver.findElement(loginOption).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
		driver.findElement(username_Field).sendKeys(username);
		driver.findElement(password_Field).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public String checkUserNameDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		WebElement userElement = driver.findElement(welcomeUser);
        String userText = userElement.getText();
        return userText;
	}
	
}

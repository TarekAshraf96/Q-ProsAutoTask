package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class categoriesPage {
	private WebDriver driver;

    public categoriesPage(WebDriver driver) {
        this.driver = driver;
    }
    By productElements = By.xpath("//div[@class = 'col-lg-4 col-md-6 mb-4']");
    
    
    public void clickCategoryAndVerifyProducts(List<String> categoryNames) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cat")));
    	
    	for (String categoryName : categoryNames) {
            String categoryXPath = "//a[text() = '" + categoryName + "']";
            driver.findElement(By.xpath(categoryXPath)).click();

        	wait.until(ExpectedConditions.visibilityOfElementLocated(productElements));
            
            WebElement productContainer = driver.findElement(productElements);
            List<WebElement> productList = productContainer.findElements(By.tagName("div"));

            if (productList.size() > 0) {
                System.out.println("Products in the '" + categoryName + "' category are displayed.");
            } else {
                System.out.println("No products found in the '" + categoryName + "' category.");
            }
        }
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By inputField = By.xpath("//input[@name='search']");

    By searchButton = By.xpath("//form[@class='search-input-section row _form_15hr99']/button[@aria-label='Search']");

    public void enterProductDetails(String productName) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(inputField));
        element.sendKeys(productName);
    }

    public void searchButton() {
        driver.findElement(searchButton).click();
    }

}

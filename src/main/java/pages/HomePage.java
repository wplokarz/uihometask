package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By acceptPolicyButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    By searchSidebar = By.xpath("//button[@data-test-btn='search-cta']");

    public void acceptPolicy() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(acceptPolicyButton));
        element.click();
    }

    public void openSearchSidebar() {
        driver.findElement(searchSidebar).click();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By listOfResult = By.xpath("//div[contains(@class,'qa-search-results-list')]");
    By nameOfProduct = By.xpath("//h3[contains(@class,'product-name')]");
    By productPrice = By.xpath("//div[contains(@class,'product-prices')]/div[1]");

    public List<WebElement> getSearchResults() {
        wait.until(ExpectedConditions.presenceOfElementLocated(listOfResult));
        return driver.findElements(listOfResult);
    }
    public String getProductName() {
        List<WebElement> listOfProducts = getSearchResults();
        return listOfProducts.getFirst().findElement(nameOfProduct).getText();
    }

    public String getProductPrice() {
        List<WebElement> listOfProducts = getSearchResults();
        return listOfProducts.getFirst().findElement(productPrice).getText();
    }

    public void getAllProductsNames() {
        List<WebElement> listOfProducts = getSearchResults();
        String productName = null;
        for (WebElement result : listOfProducts) {
            productName =  result.findElement(nameOfProduct).getText();
        }
    }

    public void getAllProductsPrices() {
        List<WebElement> listOfProducts = getSearchResults();
        String price = null;
        for (WebElement result : listOfProducts) {
            price =  result.findElement(productPrice).getText();
        }
    }
}

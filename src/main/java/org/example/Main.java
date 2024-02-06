package org.example;

import driverFactory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ResultPage;
import pages.SearchPage;


public class Main {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getWebdriver();
        driver.get("https://www.ae.com/us/en");
        HomePage home = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = new ResultPage(driver);

        home.acceptPolicy();
        home.openSearchSidebar();
        searchPage.enterProductDetails("1165_3727_100");
        searchPage.searchButton();
        resultPage.getProductPrice();

        driver.quit();

    }
}
package org.example;

import driverFactory.ChromeFactory;
import driverFactory.WebDriverFactory;
import interfaces.BrowserData;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ResultPage;
import pages.SearchPage;


public class Main {
    public static void main(String[] args) {
        BrowserData browserData = ConfigFactory.create(BrowserData.class);
        ChromeFactory chromeFactory = new ChromeFactory(browserData);
        WebDriver driver = WebDriverFactory.getWebdriver(chromeFactory);
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
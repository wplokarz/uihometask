package driverFactory;

import interfaces.BrowserData;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static WebDriver driver;
    static BrowserData browserData = ConfigFactory.create(BrowserData.class);

    static void initialize(BrowserFactory factory) {
        driver = factory.createDriver();
    }

    public static WebDriver getWebdriver(BrowserFactory factory) {
        if (driver == null) {
            initialize(factory);
        }
        return driver;
    }


    private static WebDriver createFirefoxDriver() {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        Dimension dimension = new Dimension(Integer.parseInt(browserData.width()), Integer.parseInt(browserData.height()));
        firefoxDriver.manage().window().setSize(dimension);
        return firefoxDriver;
    }
}

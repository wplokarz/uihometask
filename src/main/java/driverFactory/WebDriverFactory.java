package driverFactory;

import interfaces.BrowserData;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    private static WebDriver driver;
    static BrowserData browserData = ConfigFactory.create(BrowserData.class);

    static void initialize() {
        switch (browserData.browser().toLowerCase()) {
            case "chrome":
                driver = createChromeDriver();
                break;
            case "firefox":
                driver = createFirefoxDriver();
                break;
        }
    }

    public static WebDriver getWebdriver() {
        initialize();
        return driver;
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=" + browserData.width() + "," + browserData.height());
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver createFirefoxDriver() {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        Dimension dimension = new Dimension(Integer.parseInt(browserData.width()), Integer.parseInt(browserData.height()));
        firefoxDriver.manage().window().setSize(dimension);
        return firefoxDriver;
    }
}

package driverFactory;

import interfaces.BrowserData;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory implements BrowserFactory {

    private final BrowserData browserData;

    public ChromeFactory(BrowserData browserData) {
        this.browserData = browserData;
    }
    @Override
    public WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=" + browserData.width() + "," + browserData.height());
        return new ChromeDriver(chromeOptions);
    }
}

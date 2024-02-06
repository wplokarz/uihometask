import driverFactory.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ResultPage;
import pages.SearchPage;

public class ProductTest {
    WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.getWebdriver();
    }

    @Test
    public void testProduct() {
        driver.get("https://www.ae.com/us/en");
        HomePage home = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = new ResultPage(driver);

        home.acceptPolicy();
        home.openSearchSidebar();
        searchPage.enterProductDetails("1165_3727_100");
        searchPage.searchButton();
        Assert.assertEquals(resultPage.getProductName(), "AE Legend Jersey Polo Shirt");
        Assert.assertEquals(resultPage.getProductPrice(), "$19.99");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

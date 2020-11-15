package Hooks;

import driver.DriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks {

    protected WebDriver driver;
    private static final String EBAY_URL = "https://ebay.com/";

    @BeforeMethod
    public void testsSetUp() {
        driver = DriverInstance.getDriver();
        driver.navigate().to(EBAY_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverInstance.closeDriver();
    }
}

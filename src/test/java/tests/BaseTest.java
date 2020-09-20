package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {

    private WebDriver driver;
    private static final String EBAY_URL = "https://www.ebay.com/";


    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(EBAY_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage getBasePage() {
        return new BasePage(getDriver());
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchingResultPage getSearchingResultPage() {
        return new SearchingResultPage(getDriver());
    }

    public ElectronicsCategoryPage getElectronicsCategoryPage() {
        return new ElectronicsCategoryPage(getDriver());
    }

    public CameraDronesPage getCameraDronesPage() {
        return new CameraDronesPage(getDriver());
    }

    public ProductPage getProductPage() {return new ProductPage(getDriver()); }

    public CartPage getCartPage() {return new CartPage(getDriver()); }
}

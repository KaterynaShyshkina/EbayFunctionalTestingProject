package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(id = "gh-ac")
    WebElement searchInputField;

    @FindBy(xpath = "//li[@data-hover-track='p2481888.m1379.l6435']")
    WebElement electronicsListItem;

    @FindBy(id = "gh-cart-n")
    WebElement cartQuantity;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchItemsByKeyword(String keyword) {
        searchInputField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnElectronicsMenu() {
        electronicsListItem.click();
    }

    public WebElement getCartQuantity() {
        return cartQuantity;
    }

    public String getCartQuantityText() {
        return cartQuantity.getText();
    }

}

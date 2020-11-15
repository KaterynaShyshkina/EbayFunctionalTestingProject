package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

    @FindBy(id = "gh-ac")
    WebElement searchInputField;

    @FindBy(xpath = "//a[text()='Electronics']/parent::li")
    WebElement electronicsListItem;

    @FindBy(id = "gh-cart-n")
    WebElement cartQuantity;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchItemsByKeyword(String keyword) {
        searchInputField.sendKeys(keyword, Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public ElectronicsCategoryPage clickOnElectronicsMenu() {
        electronicsListItem.click();
        return new ElectronicsCategoryPage(driver);
    }

    public WebElement getCartQuantity() {
        return cartQuantity;
    }

    public String getCartQuantityText() {
        return cartQuantity.getText();
    }

}

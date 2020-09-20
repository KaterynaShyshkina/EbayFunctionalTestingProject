package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@class='item-price']")
    WebElement itemPrice;

    @FindBy(xpath = "//div[@class='val-col']")
    WebElement cartItemPrice;

    @FindBy(xpath = "//div[@class='val-col total-row']")
    WebElement totalCartPrice;

    @FindBy(id = "gh-la")
    WebElement logoHomeLink;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemPriceText() {
        return itemPrice.getText();
    }

    public String getCartItemPriceText() {
        return cartItemPrice.getText();
    }

    public String getTotalCartPriceText() {
        return totalCartPrice.getText();
    }

    public void clickOnLogoHomeLink() {
        logoHomeLink.click();
    }

}

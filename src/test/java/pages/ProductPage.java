package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends AbstractPage {

    @FindBy(id = "msku-sel-1")
    WebElement colourSelect;

    @FindBy(id = "prcIsum")
    WebElement itemPrice;

    @FindBy(id = "isCartBtn_btn")
    WebElement addToCartButton;

    @FindBy(id = "qtyTextBox")
    WebElement itemQuantityInput;

    @FindBy(id = "qtyErrMsg")
    WebElement quantityErrorMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectItemColour() {
        if (colourSelect.isDisplayed()) {
            Select select = new Select(colourSelect);
            select.selectByIndex(1);
        }
        return this;
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public CartPage clickOnAddToCartButton() {
        addToCartButton.click();
        return new CartPage(driver);
    }

    public ProductPage clearItemQuantity() {
        itemQuantityInput.clear();
        return this;
    }

    public ProductPage enterItemQuantity(String keyword) {
        itemQuantityInput.sendKeys(keyword);
        return this;
    }

    public boolean checkQuantityErrorMessageIsDisplayed() {
        return quantityErrorMessage.isDisplayed();
    }

}

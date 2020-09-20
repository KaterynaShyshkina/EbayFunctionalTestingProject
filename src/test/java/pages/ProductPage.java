package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(id = "isCartBtn_btn")
    WebElement addToCartButton;

    @FindBy(id = "qtyTextBox")
    WebElement itemQuantityInput;

    @FindBy(id = "qtyErrMsg")
    WebElement quantityErrorMessage;

    @FindBy(id = "w1-15-_errMsg")
    WebElement quantityErrorMessageText;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clearItemQuantity() {
        itemQuantityInput.clear();
    }

    public void enterItemQuantity(String keyword) {
        itemQuantityInput.sendKeys(keyword);
    }

    public boolean checkQuantityErrorMessageIsDisplayed() {
        return quantityErrorMessage.isDisplayed();
    }

    public String getQuantityErrorMessageText() {
        return quantityErrorMessageText.getText();
    }

}

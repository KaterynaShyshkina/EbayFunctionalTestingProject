package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTests extends BaseTest {

    private final static String SEARCH_KEYWORD = "samsung";
    private final static String EXPECTED_QUANTITY = "1";
    private final static String ITEM_QUANTITY = "200";

    @Test(priority = 7)
    public void checkItemPricesInCart() {
        getHomePage().searchItemsByKeyword(SEARCH_KEYWORD);
        getSearchingResultPage().clickOnFirstItemLink();
        getBasePage().waitForPageLoadComplete(5);
        getProductPage().clickOnAddToCartButton();
        getBasePage().waitForPageLoadComplete(5);
        assertEquals(getCartPage().getItemPriceText(), getCartPage().getCartItemPriceText(), getCartPage().getTotalCartPriceText());
    }

    @Test(priority = 8)
    public void checkQuantityOnCartLogo() {
        getHomePage().searchItemsByKeyword(SEARCH_KEYWORD);
        getSearchingResultPage().clickOnFirstItemLink();
        getBasePage().waitForPageLoadComplete(5);
        getProductPage().clickOnAddToCartButton();
        getBasePage().waitForPageLoadComplete(5);
        getCartPage().clickOnLogoHomeLink();
        getBasePage().waitForPageLoadComplete(5);
        getBasePage().waitVisibilityOfElement(5, getHomePage().getCartQuantity());
        assertEquals(getHomePage().getCartQuantityText(), EXPECTED_QUANTITY);
    }

    @Test(priority = 9)
    public void checkErrorMessageWhenEnterLargeNumberOfProduct() {
        getHomePage().searchItemsByKeyword(SEARCH_KEYWORD);
        getSearchingResultPage().clickOnFirstItemLink();
        getBasePage().waitForPageLoadComplete(5);
        getProductPage().clearItemQuantity();
        getProductPage().enterItemQuantity(ITEM_QUANTITY);
        assertTrue(getProductPage().checkQuantityErrorMessageIsDisplayed());
    }

    @Test(priority = 10)
    public void checkImpossibilityToAddLargeNumberOfProductToCart() {
        getHomePage().searchItemsByKeyword(SEARCH_KEYWORD);
        getSearchingResultPage().clickOnFirstItemLink();
        getBasePage().waitForPageLoadComplete(5);
        String expectedProductPageUrl = getDriver().getCurrentUrl();
        getProductPage().clearItemQuantity();
        getProductPage().enterItemQuantity(ITEM_QUANTITY);
        getProductPage().clickOnAddToCartButton();
        String actualProductPageUrl = getDriver().getCurrentUrl();
        assertEquals(actualProductPageUrl, expectedProductPageUrl);
    }

}

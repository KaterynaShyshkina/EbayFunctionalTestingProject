package tests;

import Hooks.Hooks;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTests extends Hooks {

    private final static String SEARCH_KEYWORD = "samsung";
    private final static String EXPECTED_QUANTITY = "1";
    private final static String ITEM_QUANTITY = "200";

    @Test
    public void checkItemPricesInCart() {
        var productPage = new HomePage(driver).searchItemsByKeyword(SEARCH_KEYWORD)
                .clickOnFirstItemLink()
                .selectItemColour();
        String itemPrice = productPage.getItemPrice();
        var cartPage = productPage.clickOnAddToCartButton();
        assertEquals(cartPage.getCartItemPriceText(), itemPrice);
    }

    @Test
    public void checkQuantityOnCartLogo() {
        var homePage = new HomePage(driver).searchItemsByKeyword(SEARCH_KEYWORD)
                .clickOnFirstItemLink()
                .selectItemColour()
                .clickOnAddToCartButton()
                .clickOnLogoHomeLink();
        assertEquals(homePage.getCartQuantityText(), EXPECTED_QUANTITY);
    }

    @Test
    public void checkErrorMessageWhenEnterLargeNumberOfProduct() {
        var productPage = new HomePage(driver).searchItemsByKeyword(SEARCH_KEYWORD)
                .clickOnFirstItemLink()
                .selectItemColour()
                .clearItemQuantity()
                .enterItemQuantity(ITEM_QUANTITY);
        assertTrue(productPage.checkQuantityErrorMessageIsDisplayed());
    }

    @Test
    public void checkImpossibilityToAddLargeNumberOfProductToCart() {
        var productPage = new HomePage(driver).searchItemsByKeyword(SEARCH_KEYWORD)
                .clickOnFirstItemLink()
                .selectItemColour();
        String expectedProductPageUrl = driver.getCurrentUrl();
        productPage.clearItemQuantity()
                .enterItemQuantity(ITEM_QUANTITY)
                .clickOnAddToCartButton();
        assertEquals(driver.getCurrentUrl(), expectedProductPageUrl);
    }

}

package tests;

import Hooks.Hooks;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class CategoryItemsTests extends Hooks {

    private final static String EXPECTED_CATEGORY_URL = "Camera-Drones";
    private final static int EXPECTED_MINIMUM_QUANTITY = 1;
    private final static Double EXPECTED_HIGHEST_PRICE = 35.00;

    @Test
    public void checkCameraDronesUrl() {
        new HomePage(driver).clickOnElectronicsMenu()
                .clickOnCameraDronesCategoryLink();
        assertTrue(driver.getCurrentUrl().contains(EXPECTED_CATEGORY_URL));
    }

    @Test
    public void checkAuctionItemsList() {
        var cameraDronesPage = new HomePage(driver).clickOnElectronicsMenu()
                .clickOnCameraDronesCategoryLink()
                .clickOnAuctionTab();
        assertTrue(cameraDronesPage.countItemsWithBids() >= EXPECTED_MINIMUM_QUANTITY);
    }

    @Test
    public void checkFilteringItemsByPrice() {
        var cameraDronesPage = new HomePage(driver).clickOnElectronicsMenu()
                .clickOnCameraDronesCategoryLink()
                .clickOnPriceUnder35FilterLink();
        for (Double itemPrice : cameraDronesPage.getItemPrices()) {
            assertTrue(itemPrice < EXPECTED_HIGHEST_PRICE);
        }
    }

}

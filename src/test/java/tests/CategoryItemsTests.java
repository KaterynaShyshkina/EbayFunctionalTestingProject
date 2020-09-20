package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CategoryItemsTests extends BaseTest {

    private final static String EXPECTED_CATEGORY_URL = "Camera-Drones";
    private final static int EXPECTED_MINIMUM_QUANTITY = 1;
    private final static Double EXPECTED_HIGHEST_PRICE = 35.00;

    @Test(priority = 4)
    public void checkCameraDronesUrl() {
        getHomePage().clickOnElectronicsMenu();
        getElectronicsCategoryPage().clickOnCameraDronesCategoryLink();
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_CATEGORY_URL));
    }

    @Test(priority = 5)
    public void checkAuctionItemsList() {
        getHomePage().clickOnElectronicsMenu();
        getBasePage().waitForPageLoadComplete(5);
        getElectronicsCategoryPage().clickOnCameraDronesCategoryLink();
        getCameraDronesPage().clickOnAuctionTab();
        getBasePage().implicitWait(5);
        assertTrue(getCameraDronesPage().countItemsWithBids() >= EXPECTED_MINIMUM_QUANTITY);
    }

    @Test(priority = 6)
    public void checkFilteringItemsByPrice() {
        getHomePage().clickOnElectronicsMenu();
        getElectronicsCategoryPage().clickOnCameraDronesCategoryLink();
        getCameraDronesPage().clickOnPriceFilterButton();
        getCameraDronesPage().clickOnPriceUnder35FilterLink();
        for (Double itemPrice : getCameraDronesPage().getItemPrices()) {
            assertTrue(itemPrice < EXPECTED_HIGHEST_PRICE);
        }
    }

}

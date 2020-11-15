package tests;

import Hooks.Hooks;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;


public class SearchTests extends Hooks {

    private final static String SEARCH_KEYWORD = "samsung";
    private final static String EXPECTED_SEARCH_QUERY = "samsung";
    private final static String EXPECTED_SEARCH_ITEM_TITLE = "samsung";

    @Test
    public void checkSearchQuery() {
        var searchPage = new HomePage(driver).searchItemsByKeyword(SEARCH_KEYWORD);
        assertTrue(searchPage.checkUrlContainsQuery(EXPECTED_SEARCH_QUERY));
    }

    @Test
    public void checkProductItemsTitles() throws InterruptedException {
        var searchPage = new HomePage(driver).searchItemsByKeyword(SEARCH_KEYWORD);
        Thread.sleep(10000);
        for (WebElement itemTitle : searchPage.getProductItemTitles()) {
            assertTrue(itemTitle.getText().toLowerCase().contains(EXPECTED_SEARCH_ITEM_TITLE));
        }
    }

    @Test
    public void checkSponsoredItemsTitles() {
        var searchPage = new HomePage(driver).searchItemsByKeyword(SEARCH_KEYWORD);
        for (WebElement itemTitle : searchPage.getSponsoredItemTitles()) {
            assertTrue(itemTitle.getText().toLowerCase().contains(EXPECTED_SEARCH_ITEM_TITLE));
        }
    }

}

package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class SearchTests extends BaseTest {

    private final static String SEARCH_KEYWORD = "samsung";
    private final static String EXPECTED_SEARCH_QUERY = "samsung";
    private final static String EXPECTED_SEARCH_ITEM_TITLE = "samsung";

    @Test(priority = 1)
    public void checkSearchingResultUrl() {
        getHomePage().searchItemsByKeyword(SEARCH_KEYWORD);
        assertTrue(getSearchingResultPage().checkUrlContainsQuery(EXPECTED_SEARCH_QUERY));
    }

    @Test(priority = 2)
    public void checkItemsTitlesOnSearchingResultPage() {
        getHomePage().searchItemsByKeyword(SEARCH_KEYWORD);
        for (WebElement itemTitle : getSearchingResultPage().getSearchResultItemTitles()) {
            assertTrue(itemTitle.getText().toLowerCase().contains(EXPECTED_SEARCH_ITEM_TITLE));
        }
    }

    @Test(priority = 3)
    public void checkSponsoredItemsTitlesOnSearchingResultPage() {
        getHomePage().searchItemsByKeyword(SEARCH_KEYWORD);
        for (WebElement itemTitle : getSearchingResultPage().getSearchResultSponsoredItemTitles()) {
            assertTrue(itemTitle.getText().toLowerCase().contains(EXPECTED_SEARCH_ITEM_TITLE));
        }
    }

}

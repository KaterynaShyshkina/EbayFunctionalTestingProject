package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchingResultPage extends BasePage {

    @FindBy(xpath = "//h3[@class='s-item__title']")
    List<WebElement> searchResultItemTitles;

    @FindBy(xpath = "//h3[contains(@class, 's-item__title--has-tags')]")
    List<WebElement> searchResultSponsoredItemTitles;

    @FindBy(xpath = "//li[@data-view='mi:1686|iid:1']//a[@class='s-item__link']")
    WebElement firstItemLink;

    public SearchingResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkUrlContainsQuery(String keyword) {
        return driver.getCurrentUrl().contains("nkw=" + keyword + "&_sacat");
    }

    public List<WebElement> getSearchResultItemTitles() {
        return searchResultItemTitles;
    }

    public List<WebElement> getSearchResultSponsoredItemTitles() {
        return searchResultSponsoredItemTitles;
    }

    public void clickOnFirstItemLink() {
        firstItemLink.click();
    }

}

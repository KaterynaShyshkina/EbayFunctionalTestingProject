package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//h3[@class='s-item__title']")
    List<WebElement> searchResultItemTitles;

    @FindBy(xpath = "//h3[contains(@class, 's-item__title--has-tags')]")
    List<WebElement> searchResultSponsoredItemTitles;

    @FindBy(xpath = "//li[@data-view='mi:1686|iid:1']//h3/..")
    WebElement firstItemLink;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkUrlContainsQuery(String keyword) {
        return driver.getCurrentUrl().contains("nkw=" + keyword + "&_sacat");
    }

    public List<WebElement> getProductItemTitles() {
        return searchResultItemTitles;
    }

    public List<WebElement> getSponsoredItemTitles() {
        return searchResultSponsoredItemTitles;
    }

    public ProductPage clickOnFirstItemLink() {
        firstItemLink.click();
        return new ProductPage(driver);
    }

}

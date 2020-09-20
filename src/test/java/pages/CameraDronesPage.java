package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CameraDronesPage extends BasePage {

    @FindBy(xpath = "//li[@class='fake-tabs__item btn']/a[contains(@href, 'Auction')]")
    WebElement auctionTab;

    @FindBy(xpath = "//span[contains(@class, 'bids')]")
    List<WebElement> bidsLabels;

    @FindBy(xpath = "//button[@aria-controls='s0-26_2-9-0-1[0]-0-1-6-6-5[5]-flyout']")
    WebElement priceFilterButton;

    @FindBy(xpath = "//a[contains(@href, 'udhi=35')]")
    WebElement priceUnder35FilterLink;

    @FindBy(xpath = "//span[@class='s-item__price']")
    List<WebElement> itemPrices;

    public CameraDronesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAuctionTab() {
        auctionTab.click();
    }

    public int countItemsWithBids() {
        return bidsLabels.size();
    }

    public void clickOnPriceFilterButton() {
        priceFilterButton.click();
    }

    public void clickOnPriceUnder35FilterLink() {
        priceUnder35FilterLink.click();
    }

    public List<Double> getItemPrices() {
        List<Double> itemPricesDoubles = new ArrayList<Double>();
        for (WebElement webElement : itemPrices) {
            itemPricesDoubles.add(parseDouble(webElement.getText().substring(1)));
        }
        return itemPricesDoubles;
    }

}

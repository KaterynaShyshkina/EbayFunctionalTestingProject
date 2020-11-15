package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CameraDronesPage extends AbstractPage {

    @FindBy(xpath = "//li[@class='fake-tabs__item btn']/a[contains(@href, 'Auction')]")
    WebElement auctionTab;

    @FindBy(xpath = "//span[contains(@class, 'bids')]")
    List<WebElement> bidsLabels;

    @FindBy(id = "s0-29-13_2-0-1[1]-0-6-0-3[2]-1[0]")
    WebElement priceUnder35FilterLink;

    @FindBy(xpath = "//span[@class='s-item__price']")
    List<WebElement> itemPrices;

    public CameraDronesPage(WebDriver driver) {
        super(driver);
    }

    public CameraDronesPage clickOnAuctionTab() {
        auctionTab.click();
        return this;
    }

    public int countItemsWithBids() {
        return bidsLabels.size();
    }

    public CameraDronesPage clickOnPriceUnder35FilterLink() {
        priceUnder35FilterLink.click();
        return this;
    }

    public List<Double> getItemPrices() {
        List<Double> itemPricesDoubles = new ArrayList<Double>();
        for (WebElement webElement : itemPrices) {
            itemPricesDoubles.add(parseDouble(webElement.getText()
                    .substring(1, webElement.getText().indexOf('.')+3)));
        }
        return itemPricesDoubles;
    }

}

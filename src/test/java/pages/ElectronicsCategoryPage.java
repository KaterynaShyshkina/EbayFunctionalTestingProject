package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsCategoryPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(), 'Camera Drones')]")
    WebElement cameraDronesCategoryLink;

    public ElectronicsCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCameraDronesCategoryLink() {
        cameraDronesCategoryLink.click();
    }

}

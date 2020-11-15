package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsCategoryPage extends AbstractPage {

    @FindBy(xpath = "//div[text()='Camera Drones']")
    WebElement cameraDronesCategoryLink;

    public ElectronicsCategoryPage(WebDriver driver) {
        super(driver);
    }

    public CameraDronesPage clickOnCameraDronesCategoryLink() {
        cameraDronesCategoryLink.click();
        return new CameraDronesPage(driver);
    }

}

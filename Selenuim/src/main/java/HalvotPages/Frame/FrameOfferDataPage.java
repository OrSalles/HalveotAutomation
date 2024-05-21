package HalvotPages.Frame;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameOfferDataPage extends BasePage {
    public FrameOfferDataPage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath = "(//b[contains(text(),'נתוני הצעה')])[2]")
    public WebElement offerDataTab;
    @FindBy(xpath = "//li[@class='nav-item ng-star-inserted']//a[@class='btn btn-warning nav-link form-footer-link p-3 ml-2 mr-2'][contains(text(),'שמירה')]")
    public WebElement saveButton;

    public String getOfferDataTab(){
        return offerDataTab.getText();
    }

    public void goToOfferDataTab(){
        offerDataTab.click();
    }
    public void saveFrame(){
        saveButton.click();
    }
}

package HalvotPages.Loan;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanOfferDataPage extends BasePage {
    public LoanOfferDataPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//popover-form-modal/div/onboarding/div/div/onboarding-tabs/div/*/*/*/*/*/ul/li/a/span/b[contains(text(),'נתוני הצעה')]")
    public WebElement offerDataTab;
    @FindBy(xpath = "//li[@class='nav-item ng-star-inserted']//a[@class='btn btn-warning nav-link form-footer-link p-3 ml-2 mr-2'][contains(text(),'שמירה')]")
    public WebElement saveButton;

    public String getOfferDataTab(){
        return offerDataTab.getText();
    }

    public void goToOfferDataTab(){
        offerDataTab.click();
    }
    public void saveLoan(){
        saveButton.click();
    }
}

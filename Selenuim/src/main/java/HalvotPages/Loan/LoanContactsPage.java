package HalvotPages.Loan;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanContactsPage extends BasePage {
    public LoanContactsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//popover-form-modal/div/onboarding/div/div/onboarding-tabs/div/*/*/*/*/*/ul/li/a/span/b[contains(text(),'אנשי קשר')]")
    public WebElement contactsTab;
    @FindBy(xpath = "//td[contains(@aria-label,'is template cell column header מספר סידורי')]")
    public WebElement SerialNumber;
    @FindBy(xpath = "//*[@data-fieldid='6817']")
    public WebElement ContactName;
    @FindBy(xpath = "(//option[@value='undefined'])[1]")
    public WebElement ContactPhone;
    @FindBy(xpath = "(//option[@class='ng-star-inserted'])[5]")
    public WebElement ContactEmail;
    @FindBy(xpath = "//option[contains(text(),'מנהל כספים')]")
    public WebElement ContactJob;

    public void goToContactsTab(){
        contactsTab.click();
    }

    public String getContactName(){
        return ContactName.getText();
    }
    public String getSerialNumber(){
        return SerialNumber.getText();
    }
    public String getContactPhone(){
        return ContactPhone.getText();
    }
    public String getContactEmail(){
        return ContactEmail.getText();
    }
    public String getContactJob(){
        return ContactJob.getText();
    }
}

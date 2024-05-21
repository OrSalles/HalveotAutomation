package HalvotPages.Loan;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanBorrowerPage extends BasePage {
    public LoanBorrowerPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//popover-form-modal/div/onboarding/div/div/onboarding-tabs/div/*/*/*/*/*/ul/li/a/span/b[contains(text(),'לווים')]")
    public WebElement borrowerTab;
    @FindBy(xpath = "//*[@data-fieldid='6401']")
    public WebElement BorrowerName;
    @FindBy(xpath = "//onboarding-field-readonly/*/span/*[@title='2']")
    public WebElement SerialNumber;
    @FindBy(xpath = "//option[@value='0']")
    public WebElement Contact;
    @FindBy(xpath = "//option[contains(text(),'054-5865412 (סלולר)')]")
    public WebElement BorrowerPhone;
    @FindBy(xpath = "(//option[@value='undefined'])[1]")
    public WebElement BorrowerEmail;

    public String getBorrowerName(){
        return BorrowerName.getText();
    }
    public String getSerialNumber(){
        return SerialNumber.getText();
    }
    public String getContact(){
        return Contact.getText();
    }
    public String getBorrowerPhone(){
        return BorrowerPhone.getText();
    }
    public String getBorrowerEmail(){
        return BorrowerEmail.getText();
    }

    public void goToBorrowerTab() throws InterruptedException {
        borrowerTab.click();
        Thread.sleep(1000);
    }
}

package HalvotPages.Frame;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameBorrowerPage extends BasePage {

    public FrameBorrowerPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "(//b[contains(text(),'לווים')])[3]")
    public WebElement borrowerTab;
    @FindBy(xpath = "//*[@data-fieldid='6401']")
    public WebElement borrowerName;
    @FindBy(xpath = "//onboarding-field-readonly[@title='1440']//div//span")
    public WebElement serialNumber;
    @FindBy(xpath = "//option[@value='0']")
    public WebElement contact;
    @FindBy(xpath = "//option[@value='1']")
    public WebElement borrowerPhone;
    @FindBy(xpath = "(//option[@class='ng-star-inserted'])[3]")
    public WebElement borrowerEmail;

    public String getBorrowerName(){
        return borrowerName.getText();
    }
    public String getSerialNumber(){
        return serialNumber.getText();
    }
    public String getContact(){
        return contact.getText();
    }
    public String getBorrowerPhone(){
        return borrowerPhone.getText();
    }
    public String getBorrowerEmail(){
        return borrowerEmail.getText();
    }

    public void goToBorrowerTab() throws InterruptedException {
        borrowerTab.click();
        Thread.sleep(1000);
    }

}

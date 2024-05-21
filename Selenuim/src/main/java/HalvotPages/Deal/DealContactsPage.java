package HalvotPages.Deal;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DealContactsPage extends BasePage {
    public DealContactsPage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath = "//b[contains(text(),'אנשי קשר')]")
    public WebElement contactTab;
    @FindBy(xpath = "//i[@class='text-dark fa fa-list']")
    public WebElement contactButton;
    @FindBy(xpath = "(//td[@aria-label=' is template cell column header שם'])[4]")
    public WebElement chosenContact;
    @FindBy(xpath = "//select[@aria-label='תפקיד']")
    public WebElement contactJob;

    public void goToContactTabAndFillingOutTheFields(){
        contactTab.click();
        contactButton.click();
        chosenContact.click();
        Select dropdown= new Select(contactJob);
        dropdown.selectByIndex(1);
    }
    public String getContactTab(){
        return contactTab.getText();
    }



}

package HalvotPages.LoanConsolidation;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsInTheLifeOfALoanTabPage extends BasePage {
    public EventsInTheLifeOfALoanTabPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//b[contains(text(),'אירועים בחיי הלוואה')]")
    public WebElement eventsInTheLifeOfALoanTab;
    @FindBy(xpath = "//*[@data-fieldid='30015']/*/*/*/*/*/*/*/*/a")
    public WebElement addEventButton;
    @FindBy(xpath = "//option[@value='2'][contains(text(),'העברה מחשבון לחשבון')]")
    public WebElement detailsCode_NISWithdrawal;
    @FindBy(xpath = "//option[@value='1'][contains(text(),'העברה מחשבון לחשבון')]")
    public WebElement detailsCode_realEstateDeposit;
    @FindBy(xpath = "//*[@data-fieldid='30024']//input")
    public WebElement commentBox;
    @FindBy(xpath = "//a[contains(text(),'אישור - שלב הבא')]")
    public WebElement nextStepButton;
    @FindBy(xpath = "//div[@title='איחוד הלוואות']")
    public WebElement eventType;


    public void addNewEvent() throws InterruptedException {
        eventsInTheLifeOfALoanTab.click();
        addEventButton.click();
        Thread.sleep(2000);
    }
    public String getEventType(){
        return eventType.getText();
    }
}


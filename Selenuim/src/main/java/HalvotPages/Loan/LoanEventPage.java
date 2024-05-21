package HalvotPages.Loan;

import HalvotPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LoanEventPage extends BasePage {
    public LoanEventPage(WebDriver driver){
        super(driver);
    }
    String date = "10/12/2023";

    @FindBy(xpath = "//popover-form-modal/div/onboarding/div/div/onboarding-tabs/div/*/*/*/*/*/ul/li/a/span/b[contains(text(),'אירועים')]")
    public WebElement dealEventTab;
    @FindBy(xpath = "(//i[@class='fa fa-plus'])[2]")
    public WebElement eventButton;
    @FindBy(xpath = "(//td[@aria-label=' is template cell column header סוג האירוע'])[6]")
    public WebElement chosenTypeEvent;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header בטיפול')])[135]")
    public WebElement chosenCare;
    @FindBy(xpath = "//select[@aria-label='סטאטוס']")
    public WebElement eventStatus;
    @FindBy(xpath = "//select[@aria-label='עדיפות']")
    public WebElement eventPriority;
    @FindBy(xpath = "(//a[@class='btn btn-warning nav-link form-footer-link p-3 ml-2 mr-2'][contains(text(),'שמירה')])[1]")
    public WebElement saveEvent;

    public String getDealEventTab(){
        return dealEventTab.getText();
    }

    public void eventTypeAndCare() {
        List<WebElement> formFields = driver.findElements(By.tagName("autocomplete-field"));
        WebElement[] formArray = formFields.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./*/*/*/a")).click();
        chosenTypeEvent.click();
        formArray[1].findElement(By.xpath("./*/*/*/a")).click();
        chosenCare.click();
    }

    public void eventDropdown() {
        Select dropdown = new Select(eventStatus);
        dropdown.selectByIndex(1);
        Select dropdown1 = new Select(eventPriority);
        dropdown1.selectByIndex(1);
    }

    public void eventDates(WebDriver driver, String date) {
        List<WebElement> formDates = driver.findElements(By.tagName("form-date-combo-2"));
        WebElement[] formArray = formDates.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[1].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);

    }
    public void openNewEvent(){
        dealEventTab.click();
        eventButton.click();
        eventTypeAndCare();
        eventDropdown();
        eventDates(driver, date);
        saveEvent.click();
    }
}

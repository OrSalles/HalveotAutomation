package HalvotPages.Deal;

import HalvotPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealOfferDataPage extends BasePage {

    public DealOfferDataPage(WebDriver driver) {
        super(driver);
    }

    String fieldsDealOffers = "5";
    @FindBy(xpath = "//button[@title='מעבר לטאב נתוני הצעות']")
    public WebElement offerData;
    @FindBy(xpath = "//b[contains(text(),'נתוני הצעה')]")
    public WebElement offerDataPageTitle;
    // ריבית
    @FindBy(xpath = "//onboarding-field/*[@data-fieldid='9750']/*/*/numeric-input/div/div/input")
    public WebElement interest;
    @FindBy(xpath = "//onboarding-field/*[@data-fieldid='9751']/*/*/numeric-input/div/div/input")
    public WebElement MHM;
    @FindBy(xpath = "//onboarding-field/*[@data-fieldid='9753']/*/*/numeric-input/div/div/input")
    public WebElement spacious;
    @FindBy(xpath = "//onboarding-field/*[@data-fieldid='9754']/*/*/numeric-input/div/div/input")
    public WebElement TLV;
    @FindBy(xpath = "//onboarding-field/*/*/*/numeric-input/div/div/input")
    public WebElement interestField;
    //ריבית משתנה
    @FindBy(xpath = "//td[contains(@aria-label,'is template cell column header ריבית משתנה (בתוספת)')]//div//div//div[@class='position-absolute bg-white right-0 px-2']")
    public WebElement variableInterestButton;
    @FindBy(xpath = "//body[1]/div[1]/app-root[1]/div[1]/ng-component[1]/login-guard[1]/div[1]/div[1]/div[2]/div[1]/div[3]/dashboard[1]/div[1]/div[1]/div[1]/div[1]/app-idash-widget[1]/div[1]/ng-component[1]/div[1]/div[3]/div[1]/compound-grid-new-entity-form[1]/div[1]/div[1]/onboarding[1]/div[1]/div[2]/div[1]/div[1]/onboarding-section[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/onboarding-field[1]/div[1]/div[1]/div[1]/grid-field[1]/div[1]/div[2]/compound-grid-ejs-grid[1]/div[1]/div[2]/ejs-grid[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/onboarding-field[1]/div[1]/div[1]/div[1]/autocomplete-field[1]/div[3]/div[1]/compound-grid-ejs-grid[1]/div[1]/div[1]/ejs-grid[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    public WebElement ChosenVariableInterest;
    //מח"מ
    @FindBy(xpath = "//onboarding-field/*/*/*/numeric-input/div/div/input")
    public WebElement MHMField;
    //הצמדה
    @FindBy(xpath = "//td[contains(@aria-label,'is template cell column header הצמדה')]//i[@class='text-dark fa fa-list']")
    public WebElement linkageButton;
    @FindBy(xpath = "//body[1]/div[1]/app-root[1]/div[1]/ng-component[1]/login-guard[1]/div[1]/div[1]/div[2]/div[1]/div[3]/dashboard[1]/div[1]/div[1]/div[1]/div[1]/app-idash-widget[1]/div[1]/ng-component[1]/div[1]/div[3]/div[1]/compound-grid-new-entity-form[1]/div[1]/div[1]/onboarding[1]/div[1]/div[2]/div[1]/div[1]/onboarding-section[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/onboarding-field[1]/div[1]/div[1]/div[1]/grid-field[1]/div[1]/div[2]/compound-grid-ejs-grid[1]/div[1]/div[2]/ejs-grid[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/onboarding-field[1]/div[1]/div[1]/div[1]/autocomplete-field[1]/div[3]/div[1]/compound-grid-ejs-grid[1]/div[1]/div[1]/ejs-grid[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    public WebElement chosenLinkage;
    //מרווח
    @FindBy(xpath = "//td[contains(@aria-label,'is template cell column header מרווח (%)')]")
    public WebElement spaciousField;
    @FindBy(xpath = "//td[contains(@aria-label,'is template cell column header LTV (%)')]")
    public WebElement TLVField;


    public void dealOffers(String fieldsDealOffers) throws InterruptedException {
        List<WebElement> formFields = driver.findElements(By.tagName("onboarding-field"));
        WebElement[] formArray = formFields.stream().toArray(WebElement[]::new);
        driver.findElement(By.xpath("//onboarding-field/*[@data-fieldid='9750']/*/*/numeric-input/div/div/input")).sendKeys(fieldsDealOffers);
        interestField.click();
        formArray[0].findElement(By.xpath("./*/*/*/numeric-input/div/div/input")).sendKeys(fieldsDealOffers);
        MHMField.click();
        formArray[2].findElement(By.xpath("./*/*/*/numeric-input/div/div/input")).sendKeys(fieldsDealOffers);
        spaciousField.click();
        formArray[4].findElement(By.xpath("./*/*/*/numeric-input/div/div/input")).sendKeys(fieldsDealOffers);
        TLVField.click();
        formArray[6].findElement(By.xpath("./*/*/*/numeric-input/div/div/input")).sendKeys(fieldsDealOffers);
    }

    public void choseFromListsOfferData() throws InterruptedException {
        Thread.sleep(1000);
        variableInterestButton.click();
        Thread.sleep(1000);
        ChosenVariableInterest.click();
        Thread.sleep(1000);
        linkageButton.click();
        Thread.sleep(2000);
        chosenLinkage.click();
    }

    public void goToOfferDataTabAndFillingOutTheFields() throws InterruptedException {
        offerData.click();
        Thread.sleep(2000);
        interest.sendKeys(fieldsDealOffers);
        MHM.sendKeys(fieldsDealOffers);
        spacious.sendKeys(fieldsDealOffers);
        TLV.sendKeys(fieldsDealOffers);
        //dealOffers(fieldsDealOffers);
        choseFromListsOfferData();
    }
    public String getOfferDataPageTitle(){
        return offerDataPageTitle.getText();
    }
}

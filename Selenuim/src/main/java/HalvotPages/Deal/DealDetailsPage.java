package HalvotPages.Deal;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static Utils.RandomID.generateRandomID;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class DealDetailsPage extends BasePage {

    public DealDetailsPage(WebDriver driver){
        super(driver);
    }

    String amount = "10,000";
    String explanation ="בדיקה";
    String date = "10/12/2023";
    String baseName = "עסקה אוטומציה";
    String randomID = generateRandomID();
    String nameWithRandomID = baseName + randomID;
    @FindBy(xpath = "//a[contains(text(),'עסקה חדשה +')]")
    public WebElement NewDealButton;

    @FindBy(xpath = "//input[@placeholder='שם העסקה']")
    public WebElement DealName;
    @FindBy(xpath = "//form-date-combo-2/div/mat-form-field/*/*/*/input")
    public WebElement dateDeal;

    @FindBy(xpath = "//i[@class='text-dark fa fa-list']")
    public WebElement CurrencyButton;

    @FindBy(xpath = "//td[@aria-label=' is template cell column header מטבע']")
    public WebElement CurrencyField;

    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header מטבע')])[2]")
    public WebElement ChosenCurrency;
    final private String DealAmountXpath=  "//input[@placeholder='סכום']";
    @FindBy(xpath = DealAmountXpath)
    public WebElement DealAmount;

    @FindBy(xpath = "//body[1]/div[1]/app-root[1]/div[1]/ng-component[1]/login-guard[1]/div[1]/div[1]/div[2]/div[1]/div[3]/dashboard[1]/div[1]/div[1]/div[1]/div[1]/app-idash-widget[1]/div[1]/ng-component[1]/div[1]/div[3]/div[1]/compound-grid-new-entity-form[1]/div[1]/div[1]/onboarding[1]/div[1]/div[2]/div[1]/div[1]/onboarding-section[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[2]/onboarding-field[1]/div[1]/div[1]/onboarding-field-readonly[1]/div[1]/span[1]/div[1]")
    public WebElement TotalAmountDeal;

    @FindBy(xpath = "//select[@aria-label='סוג האשראי']")
    public WebElement CreditType;

    @FindBy(xpath = "//select[@aria-label='מטרת האשראי']")
    public WebElement CreditPurpose;

    @FindBy(xpath = "//select[@aria-label='מעמדנו בעסקה']")
    public WebElement OurPositionInTheDeal;

    @FindBy(xpath = "//input[@id='checkbox6022']")
    public WebElement BIcodeButton;
    @FindBy(xpath = "//select[@aria-label='קוד BI']")
    public WebElement BIdropdown;
    @FindBy(xpath = "//textarea[@aria-label='הסבר לעסקה']")
    public WebElement explanationDeal;


    @FindBy(xpath = "//button[@title='מעבר לטאב לווים']")
    public WebElement borrowerButton;

    @FindBy(xpath = "//div[@class='position-absolute bg-white right-0 px-2']")
    public WebElement borrowerGridButton;

    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header מספר טלפון')])[2]")
    public WebElement ChosenBorrower;

    @FindBy(xpath = "//b[contains(text(),'פרטי עסקה')]")
    public WebElement dealDetailsTab;

    @FindBy(xpath = "//span[@title='חזי הראל']")
    public WebElement MainBorrowerField;
    @FindBy(xpath = "//input[@title='<span class=\"text-watermark\"></span>']")
    public WebElement borrowerPercent;

    @FindBy(xpath = "//i[@class='fa fa-floppy-o mr-2']")
    public WebElement saveDeal;
    @FindBy(xpath = "//tr[//span[contains(text(), 'עסקה אוטומציה')]]")
    public WebElement dealFromList;
    @FindBy(xpath = "//div[@role='heading'][contains(text(),'עסקה')]")
    public WebElement dealTitle;

    public boolean isPageLoaded(){
    return super.isPageLoaded(DealAmountXpath, 2);
    }



    public void DealFirstPart(String amount,String date) throws InterruptedException {
        dateDeal.sendKeys(date);
        Thread.sleep(2000);
        CurrencyButton.click();
        Thread.sleep(2000);
        ChosenCurrency.click();
        Thread.sleep(2000);
        DealAmount.sendKeys(amount);
    }
    public void DealSecondPart(String explanation){
        Select dropdown = new Select(CreditType);
        dropdown.selectByIndex(1);
        Select dropdown1 = new Select(CreditPurpose);
        dropdown1.selectByIndex(1);
        Select dropdown2 = new Select(OurPositionInTheDeal);
        dropdown2.selectByIndex(1);
        BIcodeButton.click();
        Select dropdown3 = new Select(BIdropdown);
        dropdown3.selectByIndex(1);
        explanationDeal.sendKeys("בדיקה");
    }
    public void saveFrameAndDeal(){
        saveDeal.click();
    }
    public void fillingOutDealDetailsFields() throws InterruptedException {
        generateRandomID();
        Thread.sleep(1000);
        DealName.sendKeys(nameWithRandomID);
        Thread.sleep(1000);
        DealFirstPart(amount,date);
        Thread.sleep(2000);
        DealSecondPart(explanation);
    }
    public void GoToBorrowerTabAndFillingOutTheFields(){
        borrowerButton.click();
        borrowerGridButton.click();
        ChosenBorrower.click();
        borrowerPercent.sendKeys("100");
        dealDetailsTab.click();
    }
    public void saveDeal(){
        saveDeal.click();
    }
    public String getTotalAmountDeal(){
        return TotalAmountDeal.getText();
    }
    public String getMainBorrowerField(){
        return MainBorrowerField.getText();
    }

    public String getDealTitle(){
        return dealTitle.getText();
    }























    }



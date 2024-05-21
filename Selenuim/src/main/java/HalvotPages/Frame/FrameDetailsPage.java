package HalvotPages.Frame;

import HalvotPages.BasePage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Utils.RandomID.generateRandomID;

public class FrameDetailsPage extends BasePage {
    private static String testData = "TestData.json";
    String date = "10/12/2023";
    String endDateFrame = "30/12/2023";
    String amountFrame = "5000";
    String baseName = "מסגרת אוטומציה";
    String randomID = generateRandomID();

    String FrameNameWithRandomID = baseName + randomID;

    public FrameDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Attachment(value = "page screenshot", type = "image/png")
    public byte[] saveScreenShot(WebDriver driver) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }



    @FindBy(xpath = "//onboarding-field/*/*/*/form-textbox/input")
    public WebElement frameName;
    @FindBy(xpath = "//select[@aria-label='סטטוס']")
    public WebElement status;
    @FindBy(xpath = "//api-combo-field[@class='ng-star-inserted']")
    public WebElement coin;
    @FindBy(xpath = "//option[@value='0']")
    public WebElement ILS;
    @FindBy(xpath = "//numeric-input/*/*/input")
    public WebElement frameAmountField;
    @FindBy(xpath = "//onboarding-field-readonly[@title='1']//div[@title='פונטנציאלית'][contains(text(),'פונטנציאלית')]")
    public WebElement dealStatus;
    @FindBy(xpath = "//option[contains(text(),'ישיר')]")
    public WebElement creditType;
    @FindBy(xpath = "//option[contains(text(),'רכישת שליטה')]")
    public WebElement creditPurpose;
    @FindBy(xpath = "//option[contains(text(),'משקיע עוגן')]")
    public WebElement dealPosition;
    @FindBy(xpath = "//onboarding-field-readonly/*/span/*/span[@title='חזי הראל']")
    public WebElement mainBorrower;
    @FindBy(xpath = "//div[@title='אחר 52534 - ']")
    public WebElement BorrowerID;
    @FindBy(xpath = "//div[@title='054-5865412 (סלולר)']")
    public WebElement BorrowerPhone;
    @FindBy(xpath = "//*[@data-fieldid='6243']//*[@class='mb-0 form-control border disabled px-1 ng-star-inserted']")
    public WebElement BorrowerEmail;
    @FindBy(xpath = "(//div[@title='5'][normalize-space()='5'])[1]")
    public WebElement interestField;
    @FindBy(xpath = "//div[@title='הלוואה10041 | 10041']")
    public WebElement variableInterest;
    @FindBy(xpath = "(//div[@title='5'][normalize-space()='5'])[2]")
    public WebElement MHMField;
    @FindBy(xpath = "//div[@title='הלוואה10 | 10']")
    public WebElement linkage;
    @FindBy(xpath = "(//div[@title='5'][normalize-space()='5'])[3]")
    public WebElement spaciousField;
    @FindBy(xpath = "(//div[@title='5'][normalize-space()='5'])[4]")
    public WebElement TLVField;
    @FindBy(xpath = "(//div[@title='5,000'][normalize-space()='5,000'])[1]")
    public WebElement frameAmountInShekel;
    @FindBy(xpath = "//span[normalize-space()='50']")
    public WebElement percentageFrameFromDeal;
    @FindBy(xpath = "(//div[@title='10,000'][normalize-space()='10,000'])[1]")
    public WebElement dealAmountBefore;
    @FindBy(xpath = "(//div[@title='5,000'][normalize-space()='5,000'])[2]")
    public WebElement dealAmountAfter;
    @FindBy(xpath = "//input[@id='checkbox6022']")
    public WebElement checkboxBI;
    @FindBy(xpath = "//option[@value='18']")
    public WebElement BICodeFromList;


    public void dates(String date, String endDateFrame) throws InterruptedException {
        List<WebElement> formDates = driver.findElements(By.tagName("form-date-combo-2"));
        WebElement[] formArray = formDates.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        Thread.sleep(1000);
        formArray[1].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        Thread.sleep(1000);
        formArray[2].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(endDateFrame);
        Thread.sleep(1000);
    }


    public void chooseFromListStatusAndCoin(WebDriver driver, String amountFrame) throws InterruptedException {
        Select dropdown = new Select(status);
        dropdown.selectByIndex(1);
        Thread.sleep(1000);
        coin.click();
        ILS.click();
        frameAmountField.sendKeys(amountFrame);
    }

    public String getFrameAmountInShekel() {
        return frameAmountInShekel.getText();
    }

    public String getPercentageFrameFromDeal() {
        return percentageFrameFromDeal.getText();
    }

    public String getDealAmountBefore() {
        return dealAmountBefore.getText();
    }

    public String getDealAmountAfter() {
        return dealAmountAfter.getText();
    }

    public String getDealStatus() {
        return dealStatus.getText();
    }

    public String getCreditType() {
        return creditType.getText();
    }

    public String getCreditPurpose() {
        return creditPurpose.getText();
    }

    public String getDealPosition() {
        return dealPosition.getText();
    }

    public String getMainBorrower() {
        return mainBorrower.getText();
    }

    public String getBorrowerID() {
        return BorrowerID.getText();
    }

    public String getBorrowerPhone() {
        return BorrowerPhone.getText();
    }

    public String getBorrowerEmail() {
        return BorrowerEmail.getText();
    }

    public String getInterestField() {
        return interestField.getText();
    }

    public String getVariableInterest() {
        return variableInterest.getText();
    }

    public String getMHMField() {
        return MHMField.getText();
    }

    public String getLinkage() {
        return linkage.getText();
    }

    public String getSpaciousField() {
        return spaciousField.getText();
    }

    public String getTLVField() {
        return TLVField.getText();
    }

    public String getBICodeFromList() {
        return BICodeFromList.getText();
    }

    public void InsertFrameNameDatesAndAmountFrame() throws InterruptedException {
        Thread.sleep(1000);
        frameName.sendKeys(FrameNameWithRandomID);
        dates(date, endDateFrame);
        Thread.sleep(1000);
        chooseFromListStatusAndCoin(driver, amountFrame);
    }


}



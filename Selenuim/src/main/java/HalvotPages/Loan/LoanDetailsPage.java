package HalvotPages.Loan;

import HalvotPages.BasePage;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LoanDetailsPage extends BasePage {
    public LoanDetailsPage(WebDriver driver) {
        super(driver);
    }

    String date = "10/12/2023";

    String endDateLoan = "01/01/2024";

    String amountLoan = "2000";




    @FindBy(xpath = "//div[@role='heading'][contains(text(),'הלוואה')]")
    public WebElement loanTitle;
    @FindBy(xpath = "//tbody/tr[@role='button']/td[contains(@aria-label,'is template cell column header')]/div[@class='ng-star-inserted']/onboarding-field/div/div[@class='ng-star-inserted']/div/popover-form[@class='ng-star-inserted']/popover-form-modal[@class='ng-star-inserted']/div[@class='formContainer']/onboarding/div[@class='d-flex flex-column position-absolute ng-star-inserted']/div[@class='h-100']/div[@class='onboardingTabbedMasterContainer pr-2']/div/onboarding-section[@class='ng-star-inserted']/form[@class='behaviorType_0 ng-untouched ng-pristine ng-valid ng-star-inserted']/div[@class='container']/div/div[@class='p-3 pl-2']/div/div[@class='onboardingSectionContainer position-relative ng-star-inserted']/div[@class='rounded editable-background- sectionField container behaviorType_0 subsectionBlock shadow mb-3 ng-star-inserted']/div[@class='row']/div[@class='col-md-12 ng-star-inserted']/div[@class='h-100']/div[@class='row py-2']/div[@class='p-2 mobile-input ng-star-inserted']/div[@class='ng-star-inserted']/div/onboarding-field/div/div[@class='mb-0 form-control border disabled px-1 ng-star-inserted']/onboarding-field-readonly[@title='!@#$%^&*)()']/div/span/div[@class='ng-star-inserted']/span[1]")
    public WebElement LoanName;
    @FindBy(xpath = "//select[@aria-label='סטטוס']")
    public WebElement status;
    @FindBy(xpath = "//api-combo-field[@class='ng-star-inserted']")
    public WebElement coin;
    @FindBy(xpath = "//option[@value='0']")
    public WebElement ILS;
    @FindBy(xpath = "//numeric-input/*/*/input")
    public WebElement LoanAmountField;
    @FindBy(xpath = "//*[@data-fieldid='6398']//*[@title='ILS']")
    public WebElement LoanCoin;

    @FindBy(xpath = "//onboarding-field-readonly[@title='1']//div[@title='פונטנציאלית'][contains(text(),'פונטנציאלית')]")
    public WebElement dealStatus;
    @FindBy(xpath = "//onboarding-field-readonly[@title='0.4']//div")
    public WebElement LoanPercentageFromFrame;
    @FindBy(xpath = "(//div[@title='5,000'][normalize-space()='5,000'])[2]")
    public WebElement RemainingFrameBefore;
    @FindBy(xpath = "//div[@title='3,000']")
    public WebElement RemainingFrameAfter;
    @FindBy(xpath = "//onboarding-field-readonly[@title='1']//div[@title='פונטנציאלית'][contains(text(),'פונטנציאלית')]")
    public WebElement DealStatus;
    @FindBy(xpath = "//option[contains(text(),'ישיר')]")
    public WebElement CreditType;
    @FindBy(xpath = "//option[contains(text(),'רכישת שליטה')]")
    public WebElement CreditPurpose;
    @FindBy(xpath = "//option[contains(text(),'משקיע עוגן')]")
    public WebElement DealPosition;
    @FindBy(xpath = "//span[@title='לווה 4741']")
    public WebElement MainBorrower;
    @FindBy(xpath = "//div[@title='ח\"פ 54648854 - ']")
    public WebElement BorrowerID;
    @FindBy(xpath = "//div[@title='0525865412 (סלולר)']")
    public WebElement BorrowerPhone;
    @FindBy(xpath = "//*[@data-fieldid='6243']//*[@class='mb-0 form-control border disabled px-1 ng-star-inserted']")
    public WebElement BorrowerEmail;
    @FindBy(xpath = "(//onboarding-field-readonly[@title='5'])[1]")
    public WebElement InterestField;
    @FindBy(xpath = "//div[@title=' | 697']")
    public WebElement VariableInterest;
    @FindBy(xpath = "(//div[@title='5'][normalize-space()='5'])[2]")
    public WebElement MHMField;
    @FindBy(xpath = "//div[@title=' | 320000001']")
    public WebElement Linkage;
    @FindBy(xpath = "(//div[@title='5'][normalize-space()='5'])[3]")
    public WebElement SpaciousField;
    @FindBy(xpath = "(//div[@title='5'][normalize-space()='5'])[4]")
    public WebElement TLVField;


    public void LoanNum(String firstValue) throws InterruptedException {
        List<WebElement> formFields = driver.findElements(By.tagName("autocomplete-field"));
        WebElement[] formArray = formFields.stream().toArray(WebElement[]::new);
        Thread.sleep(1000);
        formArray[0].findElement(By.xpath("./*/*/input")).sendKeys(firstValue);
        Thread.sleep(1000);
    }

    private void removeFromCSV(List<String[]> allRows) throws IOException {
        String csvFilePath = "S:\\Danel_HB_Halvaot_COPY\\Assets_for_automation\\Assets.csv";
        CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath));
        csvWriter.writeAll(allRows);
        csvWriter.close();
    }

    private List<String[]> readCSV() throws IOException, CsvException {
        String csvFilePath = "S:\\Danel_HB_Halvaot_COPY\\Assets_for_automation\\Assets.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
        List<String[]> allRows = csvReader.readAll();
        csvReader.close();
        return allRows;
    }

    public void ChoosePaper() throws InterruptedException, IOException, CsvException {
        List<String[]> allRows = readCSV();
        if (allRows.size() >= 2) {
            String[] secondRow = allRows.get(1);
            String firstValue = secondRow[0];
            LoanNum(firstValue);
            clickTheFirstNumLoan();
            Thread.sleep(1000);
            allRows.remove(1);
            removeFromCSV(allRows);
        }

    }


    public void clickTheFirstNumLoan() {
        WebElement tableAsset = driver.findElement(By.className("table")); // Assuming this is the table containing assets
        List<WebElement> rows = tableAsset.findElements(By.tagName("tr"));
        if (!rows.isEmpty()) {
            WebElement firstRowAsset = rows.get(0); // First row
            List<WebElement> cells = firstRowAsset.findElements(By.tagName("td"));
            if (!cells.isEmpty()) {
                WebElement firstClickableElement = cells.get(0); // First cell
                firstClickableElement.click();
            } else {
                System.out.println("No cells found in the first row of the asset table.");
            }
        } else {
            System.out.println("No rows found in the asset table.");
        }
    }

    public void dates(String date, String endDateLoan) throws InterruptedException {
        List<WebElement> formDates = driver.findElements(By.tagName("form-date-combo-2"));
        WebElement[] formArray = formDates.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        Thread.sleep(1000);
        formArray[1].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        Thread.sleep(1000);
        formArray[2].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(endDateLoan);
        Thread.sleep(1000);
    }

    public void amount(String amountLoan) throws InterruptedException {
        List<WebElement> formAmounts = driver.findElements(By.tagName("onboarding-field"));
        WebElement[] formArray = formAmounts.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./*/*/*/numeric-input/*/*/input")).sendKeys(amountLoan);
        Thread.sleep(1000);
        formArray[1].findElement(By.xpath("./*/*/*/numeric-input/*/*/input")).sendKeys(amountLoan);
        Thread.sleep(1000);
        formArray[2].findElement(By.xpath("./*/*/*/numeric-input/*/*/input"));
        Thread.sleep(1000);
    }

    public void InsertStatusDatesAndAmountLoan() throws InterruptedException {
        Select dropdown = new Select(status);
        dropdown.selectByIndex(1);
        Thread.sleep(1000);
        dates(date, endDateLoan);
        Thread.sleep(1000);
        //amount(amountLoan);
        LoanAmountField.sendKeys(amountLoan);
    }

    public String getLoanTitle() {
        return loanTitle.getText();
    }

    public String getLoanCoin() {
        return LoanCoin.getText();
    }

    public String getLoanPercentageFromFrame() {
        return LoanPercentageFromFrame.getText();

    }

    public String getRemainingFrameBefore() {
        return RemainingFrameBefore.getText();
    }

    public String getRemainingFrameAfter() {
        return RemainingFrameAfter.getText();
    }

    public String getDealStatus() {
        return dealStatus.getText();
    }

    public String getCreditType() {
        return CreditType.getText();
    }

    public String getCreditPurpose() {
        return CreditPurpose.getText();
    }

    public String getDealPosition() {
        return DealPosition.getText();
    }
    public String getMainBorrower() {
        return MainBorrower.getText();
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
        return InterestField.getText();
    }

    public String getVariableInterest() {
        return VariableInterest.getText();
    }

    public String getMHMField() {
        return MHMField.getText();
    }

    public String getLinkage() {
        return Linkage.getText();
    }

    public String getSpaciousField() {
        return SpaciousField.getText();
    }

    public String getTLVField() {
        return TLVField.getText();
    }
}



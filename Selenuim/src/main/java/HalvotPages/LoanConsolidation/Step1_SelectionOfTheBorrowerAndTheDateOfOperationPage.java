package HalvotPages.LoanConsolidation;

import HalvotPages.BasePage;
import Utils.JsonUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class Step1_SelectionOfTheBorrowerAndTheDateOfOperationPage extends BasePage {
    public Step1_SelectionOfTheBorrowerAndTheDateOfOperationPage(WebDriver driver){
        super(driver);
    }
    String testData = "TestData.json";
    String urlData = "urlData.json";
    @FindBy(xpath = "//div[@title='חזי הראל - (אחר 52534)']")
    public WebElement mainBorrower;
    @FindBy(xpath = "//div[@title='פוטנציאלי']")
    public WebElement status;
    @FindBy(xpath = "//option[@value='2'][contains(text(),'העברה מחשבון לחשבון')]")
    public WebElement detailsCode_NISWithdrawal;
    @FindBy(xpath = "//option[@value='1'][contains(text(),'העברה מחשבון לחשבון')]")
    public WebElement detailsCode_realEstateDeposit;
    @FindBy(xpath = "//*[@data-fieldid='30024']//input")
    public WebElement commentBox;
    @FindBy(xpath = "//a[contains(text(),'אישור - שלב הבא')]")
    public WebElement nextStepButton;

    public void chooseDetailsCode_NISWithdrawal(){
        detailsCode_NISWithdrawal.click();
    }
    public void chooseDetailsCode_realEstateDeposit(){
        detailsCode_realEstateDeposit.click();
    }
    public void insertComment() throws IOException {
        JSONObject stepOne = JsonUtils.returnJsonObject(testData, "Step1_SelectionOfTheBorrowerAndTheDateOfOperation");
        commentBox.sendKeys(stepOne.getString("commentBox"));
    }
    public void clickNextStep(){
        nextStepButton.click();
    }
    public String getMainBorrower(){
        return mainBorrower.getText();
    }

}

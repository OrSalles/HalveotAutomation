package HalvotPages.LoanConsolidation;

import HalvotPages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

public class Step3_CreateNewLoanPage extends BasePage {
    public Step3_CreateNewLoanPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//api-combo-field[@class='ng-star-inserted']")
    public WebElement listOfLoans;
    @FindBy(xpath = "//*[@data-fieldid='30040']//option [2]")
    public WebElement chosenLoan;
    @FindBy(xpath = "//*[@data-fieldid='30043']//input")
    public WebElement numberOfNewLoan;
    @FindBy(xpath = "//*[@data-fieldid='30044']//input")
    public WebElement nameOfNewLoan;
    @FindBy(xpath = "(//a[contains(text(),'אישור - שלב הבא')])[1]")
    public WebElement nextButton;


    public void selectLoan() throws InterruptedException {
        listOfLoans.click();
        Thread.sleep(2000);
        chosenLoan.click();
    }
    public void pressNextButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
        nextButton.click();
    }
    public String getNumberOfNewLoan(){
        return numberOfNewLoan.getText();
    }

}

package HalvotPages.LoanConsolidation;

import HalvotPages.BasePage;
import HalvotPages.PageLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step4_CreatingMovementsAndPerformingTheUnionPage extends BasePage {
    public Step4_CreatingMovementsAndPerformingTheUnionPage(WebDriver driver) {
        super(driver);
    }

    protected PageLoader pageLoader;

    @FindBy(xpath = "//b[contains(text(),'אירועים בחיי הלוואה')]")
    public WebElement eventsInTheLifeOfALoanTab;
    @FindBy(xpath = "//b[contains(text(),'הלוואות')]")
    public WebElement loanTab;
    @FindBy(xpath = "(//td[contains(@aria-label,\"is template cell column header מס' הלוואה\")]/*/*/span)[1]")
    public WebElement Loan1OnStep4;
    @FindBy(xpath = "//div[@title='לווה 4741 - (ח\"פ 54648854)']")
    public WebElement mainBorrower;
    @FindBy(xpath = "(//td[contains(@aria-label,\"is template cell column header מס' הלוואה\")]/*/*/span)[2]")
    public WebElement Loan2OnStep4;
    @FindBy(xpath = "//td[@class='e-rowcell e-templatecell cursor-pointer e-lastrowcell e-focus']")
    public WebElement newNumOfLoanInPage4;
    @FindBy(xpath = "//h2[contains(text(),'הלוואה חדשה שתיווצר')]")
    public WebElement newLoanTitle;
    @FindBy(xpath = "//h2[contains(text(),'פעולות שצפויות להיווצר')]")
    public WebElement actionsToBeOccur;
    @FindBy(xpath = "(//a[@href='javascript:;'][contains(text(),'שמירה')])[2]")
    public WebElement saveButton;
    @FindBy(xpath = "//*[@data-fieldid='30070']")
    public WebElement editButton;
    @FindBy(xpath = "//button[contains(text(),'אישור ביצוע איחוד')]")
    public WebElement saveConsolidationButton;


    public String getNewNunOfLoanFromPage4() {
        return newNumOfLoanInPage4.getText();
    }
    public String getMainBorrower(){
        return mainBorrower.getText();
    }
    public String getNewLoanTitle(){
        return newLoanTitle.getText();
    }
    public String getActionsToBeOccur(){
        return actionsToBeOccur.getText();
    }

    //    public String getLoan1OnStep4Text(){
//        return Loan1OnStep4.getText();
//    }
//    public String getLoan2OnStep4Text(){
//        return Loan2OnStep4T.getText();
//    }
    public String getLoan1OnStep4Value() {
        // Use getText() to get the visible text from the <td> element
        String loan1Text = Loan1OnStep4.getText();

        // Return the extracted value
        return loan1Text;
    }


    public String getLoan2OnStep4Value() {
        // Use getText() to get the visible text from the <td> element
        String loan1Text = Loan2OnStep4.getText();

        // Return the extracted value
        return loan1Text;
    }
    public void navigateToLoanTabAndSaveLoansNames() throws InterruptedException {
        pageLoader = new PageLoader(driver);
        LoansTabPage LoansTab = pageLoader.LoansTab;
        saveButton.click();
        loanTab.click();
        Thread.sleep(2000);
        LoansTab.getLoan1Value();
        System.out.println(LoansTab.loan1.getText());
        System.out.println(LoansTab.loan2.getText());
        LoansTab.getLoan1Value();
        eventsInTheLifeOfALoanTab.click();
        editButton.click();
        Thread.sleep(2000);

    }
    public void clickTheSaveConsolidationButton(){
        saveConsolidationButton.click();
    }

}

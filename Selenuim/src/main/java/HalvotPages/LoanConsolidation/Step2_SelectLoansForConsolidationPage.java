package HalvotPages.LoanConsolidation;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step2_SelectLoansForConsolidationPage extends BasePage {
    public Step2_SelectLoansForConsolidationPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "(//input[@id='checkbox30037'])[1]")
    public WebElement firstLoanCheckbox;
    @FindBy(xpath = "(//input[@id='checkbox30037'])[2]")
    public WebElement secondLoanCheckbox;
    @FindBy(xpath = "//a[contains(text(),'אישור - שלב הבא')]")
    public WebElement nextButton;

    public void pressNextButton(){
        nextButton.click();
    }

}

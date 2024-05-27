package HalvotPages.LoanConsolidation;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step2_SelectLoansForConsolidationPage extends BasePage {
    public Step2_SelectLoansForConsolidationPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//td[@class='e-rowcell e-templatecell cursor-pointer']//div//input[@id='checkbox30037']")
    public WebElement firstLoanCheckbox;
    @FindBy(xpath = "//td[@class='e-rowcell e-templatecell cursor-pointer e-lastrowcell']//div//input[@id='checkbox30037']")
    public WebElement secondLoanCheckbox;
}

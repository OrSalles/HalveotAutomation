package HalvotPages.LoanConsolidation;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoansTabPage extends BasePage {
    public LoansTabPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[contains(text(),'הלוואות')]")
    public WebElement loanTab;
    @FindBy(xpath = "(//td[@aria-label=\" is template cell column header מס' הלוואה\"])[1]")
    public WebElement loan1;
    @FindBy(xpath = "(//td[@aria-label=\" is template cell column header מס' הלוואה\"])[2]")
    public WebElement loan2;
    @FindBy(xpath = "//onboarding-field-readonly[@title='2']//div[@title='פעיל - מאוחד'][contains(text(),'פעיל - מאוחד')]")
    public WebElement activityStatus;


     public String getActivityStatus(){
         return activityStatus.getText();
     }
    public String getLoan1Value() {
        // Using getText() to retrieve the text content from the element
        String loan1Text = loan1.getText();

        // If the value is stored as an attribute (e.g., "value" or other), you can retrieve it using getAttribute()
        // String loan1Value = loan1.getAttribute("value");

        // Returning the value or saving it for later use
        return loan1Text;
    }

    public String getLoan2Value() {
        // Using getText() to retrieve the text content from the element
        String loan1Text = loan2.getText();

        // If the value is stored as an attribute (e.g., "value" or other), you can retrieve it using getAttribute()
        // String loan1Value = loan1.getAttribute("value");

        // Returning the value or saving it for later use
        return loan1Text;

//    public String getLoan2(){
//        return loan2.getText();
//    }

    }
    public void goToLoanTab(){
         loanTab.click();
    }
}

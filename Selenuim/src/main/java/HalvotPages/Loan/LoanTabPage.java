package HalvotPages.Loan;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoanTabPage extends BasePage {
    public LoanTabPage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath = "//b[contains(text(),'הלוואות')]")
    public WebElement loanTab;
    @FindBy(xpath = "//i[@class='fa fa-plus']")
    public WebElement addLoanButton;
    @FindBy(xpath = "//div[@title='ILS']")
    public WebElement coinField;
    @FindBy(xpath = "(//div[@title='5,000'][normalize-space()='5,000'])[1]")
    public WebElement amountFrame;
    @FindBy(xpath = "(//div[@title='5,000'][normalize-space()='5,000'])[2]")
    public WebElement leftToExploit;
    @FindBy(xpath = "(//div[@title='5,000'][normalize-space()='5,000'])[3]")
    public WebElement amountFrameInShekel;
    @FindBy(xpath = "(//div[@title='5,000'][normalize-space()='5,000'])[4]")
    public WebElement leftToExploitInShekel;

    public void clickOnThePlusButton(){
        addLoanButton.click();

    }




    }










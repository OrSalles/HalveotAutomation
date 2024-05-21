package HalvotPages.Loan;

import HalvotPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoanAdditionalConditionPage extends BasePage {
    public LoanAdditionalConditionPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//popover-form-modal/div/onboarding/div/div/onboarding-tabs/div/*/*/*/*/*/ul/li/a/span/b[contains(text(),'תנאים נוספים')]")
    public WebElement AdditionalConditionTab;

    public void goToAdditionalConditionTab(){
        AdditionalConditionTab.click();
    }

    public void YesNoRadioButtonLoanPart1() {
        List<WebElement> formRadioButton = driver.findElements(By.tagName("form-yes-no"));
        WebElement[] formArray = formRadioButton.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[1].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[2].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[3].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[4].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[5].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[6].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[7].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[8].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[9].findElement(By.xpath("./*/*/*/*/label/input"));
    }
    public void YesNoRadioButtonLoanPart2() {
        List<WebElement> formRadioButton = driver.findElements(By.tagName("form-yes-no"));
        WebElement[] formArray = formRadioButton.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[1].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[2].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[3].findElement(By.xpath("./*/*/*/*/label/input"));
    }
}

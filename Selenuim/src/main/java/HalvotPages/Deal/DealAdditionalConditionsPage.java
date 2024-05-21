package HalvotPages.Deal;

import HalvotPages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DealAdditionalConditionsPage extends BasePage {

    public DealAdditionalConditionsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//b[contains(text(),'תנאים נוספים')]")
    public WebElement AdditionalConditionsTab;
    @FindBy(xpath = "//select[@aria-label='נחיתות חוזית']")
    public WebElement contractualInferiority;
    public void YesNoRadioButton(){
        List<WebElement> formRadioButton= driver.findElements(By.tagName("form-yes-no"));
        WebElement[]formArray=formRadioButton.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[1].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[2].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[3].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[4].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[5].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[6].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[7].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[8].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[9].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[10].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[11].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[12].findElement(By.xpath("./*/*/*/*/label/input")).click();
        formArray[13].findElement(By.xpath("./*/*/*/*/label/input")).click();
    }
    public void goToAdditionalConditionsAndFillingOutAllTheFields(){
        AdditionalConditionsTab.click();
        YesNoRadioButton();
        Select dropdown = new Select(contractualInferiority);
        dropdown.selectByIndex(2);
    }
    public String getAdditionalConditionsTab(){
        return AdditionalConditionsTab.getText();
    }





















        }


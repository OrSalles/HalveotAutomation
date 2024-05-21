package HalvotPages.Frame;

import HalvotPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FrameAdditionalConditionPage extends BasePage {
    public FrameAdditionalConditionPage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath = "(//b[contains(text(),'תנאים נוספים')])[2]")
    public WebElement AdditionalConditionTab;
    @FindBy(xpath = "(//input[@class='form-check-input ng-pristine ng-valid ng-touched'])[1]")
    public WebElement yesCheckbox1;
    @FindBy(xpath = "(//input[@name='radiogroup__9950'])[1]")
    public WebElement yesCheckbox2;
    @FindBy(xpath = "(//input[@name='radiogroup__9960'])[1]")
    public WebElement yesCheckbox3;

    public void goToAdditionalConditionTab(){
        AdditionalConditionTab.click();
    }



    public void YesNoRadioButtonFrame() {
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
        formArray[10].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[11].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[12].findElement(By.xpath("./*/*/*/*/label/input"));
        formArray[13].findElement(By.xpath("./*/*/*/*/label/input"));
    }
}

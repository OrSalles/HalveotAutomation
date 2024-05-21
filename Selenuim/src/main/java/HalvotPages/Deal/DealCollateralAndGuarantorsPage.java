package HalvotPages.Deal;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DealCollateralAndGuarantorsPage extends BasePage {

    public DealCollateralAndGuarantorsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "(//b[contains(text(),'בטחונות וערבים')])[1]")
    public WebElement CollateralAndGuarantorsTab;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement SafeDetail;
    @FindBy(xpath = "//select[@aria-label='סוג בטוחה']")
    public WebElement safeType;

    public void goToCollateralAndGuarantorsAndFillingOutTheFields(){
        CollateralAndGuarantorsTab.click();
        SafeDetail.sendKeys("בדיקה");
        Select dropdown = new Select(safeType);
        dropdown.selectByIndex(1);
    }
    public String getCollateralAndGuarantorsTab(){
        return CollateralAndGuarantorsTab.getText();
    }

}




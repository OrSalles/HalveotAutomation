package HalvotPages.Frame;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameCollateralAndGuarantorsPage extends BasePage {

    public FrameCollateralAndGuarantorsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "(//b[contains(text(),'בטחונות וערבים')])[2]")
    public WebElement CollateralAndGuarantorsTab;
    @FindBy(xpath = "//input[@type='text']")
    public WebElement SafeDetail;
    @FindBy(xpath = "//option[@value='1']")
    public WebElement safeType;

    public void goToCollateralAndGuarantorsTab(){
        CollateralAndGuarantorsTab.click();
    }

    public String getSafeDetail(){
        return SafeDetail.getAttribute("value");
    }
    public String getSafeType(){
        return safeType.getAttribute("value");
    }



}

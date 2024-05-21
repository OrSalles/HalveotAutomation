package HalvotPages.Frame;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameTabPage extends BasePage {
    public FrameTabPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//b[contains(text(),'מסגרות')]")
    public WebElement frameTab;
    @FindBy(xpath = "//i[@class='fa fa-plus']")
    public WebElement plusButton;

}

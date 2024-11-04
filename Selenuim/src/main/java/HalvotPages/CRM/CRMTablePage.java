package HalvotPages.CRM;

import HalvotPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRMTablePage extends BasePage {
    public CRMTablePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//i[@class='fa fa-inbox']")
    public WebElement inboxButton;
    @FindBy(xpath = "//span[@class='d-inline-block']")
    public WebElement CRMTableTitle;

    public String getCRMTableTitle(){
        return CRMTableTitle.getText();
    }
}

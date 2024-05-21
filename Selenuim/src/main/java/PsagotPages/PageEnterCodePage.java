package PsagotPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageEnterCodePage {
    @FindBy(xpath = "//h1[contains(text(),'הזדהות לצפיה בפרטי החשבונות')]")
    public WebElement SecondPageTitle;

    @FindBy(xpath = "//a[contains(text(),'כניסה לפרטי החשבון')]")
    public WebElement EnterAccountButton;

    @FindBy(xpath = "//input[@placeholder='קוד כניסה למערכת']")
    public WebElement OTPNum;

    public void enterCode(String codeNum) throws InterruptedException {
        OTPNum.sendKeys(codeNum);
        Thread.sleep(1000);
        EnterAccountButton.click();
    }


}


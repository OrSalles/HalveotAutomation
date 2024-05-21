package HalvotPages.Deal;

import HalvotPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DealDocumentsPage extends BasePage {

    public DealDocumentsPage(WebDriver driver){
        super(driver);
    }
    String date = "10/12/2023";
    String path ="X:\\פריוריטי\\Or Baron\\1.docx";
    @FindBy(xpath = "//b[contains(text(),'מסמכים')]")
    public WebElement documentsTab;
    @FindBy(xpath = "//i[@data-addtype='InGrid']")
    public WebElement documentsButton;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadFileButton;
    @FindBy(xpath = "//select[@aria-label='סוג מסמך']")
    public WebElement documentsType;
    @FindBy(xpath = "//select[@aria-label='תדירות תוקף']")
    public WebElement frequency;

    public void documentsDates(String date) {
        List<WebElement> formDates = driver.findElements(By.tagName("form-date-combo-2"));
        WebElement[] formArray = formDates.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[1].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[2].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);

    }
    public void documentsFields(String path) throws InterruptedException {
        Thread.sleep(2000);
        uploadFileButton.sendKeys(path);
        Thread.sleep(5000);
        Select dropdown= new Select(documentsType);
        dropdown.selectByIndex(1);
        Select dropdown1= new Select(frequency);
        dropdown1.selectByIndex(1);
    }
    public void upLoadFileInDocumentsTab() throws InterruptedException {
        Thread.sleep(1000);
        documentsTab.click();
        Thread.sleep(1000);
        documentsButton.click();
        documentsFields(path);
        Thread.sleep(5000);
        documentsDates(date);
    }
    public String getDocumentsTab(){
        return documentsTab.getText();
    }
}

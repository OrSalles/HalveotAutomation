package HalvotPages.Deal;

import HalvotPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealTablePage extends BasePage {
    public DealTablePage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath = "//th[2]//compound-grid-ejs-grid-generic-filter[1]//div[1]//input[1]")
    public WebElement searchDealName;
    @FindBy(xpath = "//span[@class='e-headertext'][contains(text(),'מס')]")
    public WebElement DealNum;
    @FindBy(xpath = "//span[@class='e-headertext'][contains(text(),'מס')]")
    public WebElement actualDealNun;
    @FindBy(xpath ="//table[@id='grid_1500417120_0_content_table']")
    public WebElement table;
    @FindBy(xpath = "//div[@class='alert alert-success mb-1 mx-2 fade show ng-star-inserted']")
    public WebElement alert;
//    @FindBy(xpath = "(//table[@id='grid_1500417120_0_content_table']/tbody/tr)[last()]")
//    public WebElement lastRow;
    @FindBy(xpath = "(//table[@id='grid_695134662_0_content_table']/tbody/tr)[last()]")
    public WebElement lastRow;

    public String getAlert(){
        return alert.getText();
    }


    public void openDealFromList (String NameOfDeal) throws InterruptedException {
        List<WebElement> formFieldsTable = driver.findElements(By.tagName("compound-grid-ejs-grid-generic-filter"));
        WebElement[] formArray = formFieldsTable.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./div/input"));
        formArray[1].findElement(By.xpath("./div/input")).sendKeys(NameOfDeal);
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.doubleClick(DealNum);
        Thread.sleep(3000);
        actualDealNun.click();
    }
    public void openTheLestDeal() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(3000);
        lastRow.click();
        Thread.sleep(5000);
    }



    }













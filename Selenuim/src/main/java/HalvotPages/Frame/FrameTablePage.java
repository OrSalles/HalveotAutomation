package HalvotPages.Frame;

import HalvotPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameTablePage extends BasePage {
    public FrameTablePage(WebDriver driver){

        super(driver);
    }
    @FindBy(xpath = "//i[@class='fa fa-clone']")
    public WebElement frameButton;
    @FindBy(xpath = "(//table[@id='grid_676145156_0_content_table']/tbody/tr)[last()]]")
    public WebElement lastRow;
    @FindBy(xpath = "//div[@role='heading'][contains(text(),'מסגרת')]")
    public WebElement frameTitle;


    public void clickLastRow() {
        // Find the table element
        WebElement table = driver.findElement(By.id("grid_803765790_0_content_table"));

        // Find all rows in the table
        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Click the last row
        WebElement lastRow = rows.get(rows.size() - 1);
        lastRow.click();
    }
        }

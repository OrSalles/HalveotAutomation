package HalvotPages.BP;

import HalvotPages.BasePage;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Field;
import javax.swing.*;
import javax.swing.text.html.Option;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utils.RandomID.generateRandomID;

public class BPCompanyDetailsPage extends BasePage {
    public BPCompanyDetailsPage(WebDriver driver) {
        super(driver);
    }

    String name = "Danel";
    String corporationNum = "100";
    String randomID = generateRandomID();
    String date = "01/01/1990";
    public String comment = "בדיקה";


    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement companyName;
    //    @FindBy(xpath = "//*[@data-fieldid='500']//input")
//    public WebElement companyName;
    @FindBy(xpath = "//option[@value='1'][contains(text(),'חברה')]")
    public WebElement formOfIncorporation;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement texCorporationNum;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[1]")
    public WebElement countryToTaxButton;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header מדינה למס')])[266]")
    public WebElement countryToTax;

    @FindBy(xpath = "//*[@data-fieldid='53']//input[@title='ישראל']")
    public WebElement countryToTaxField;
    @FindBy(xpath = "//option[@value='7']")
    public WebElement BnNumber;
    @FindBy(xpath = "//*[@data-fieldid='31']//input[@type='text']")
    public WebElement IDNumber;
    @FindBy(xpath = "//*[@data-fieldid='32']//a[@class='ng-star-inserted']//i[@class='text-dark fa fa-list']")
    public WebElement stateOfIssueButton;
    @FindBy(xpath = "(//td[@aria-label=' is template cell column header מדינת הנפקה'])[267]")
    public WebElement stateIsrael;
    @FindBy(xpath = "//input[@title='ישראל']")
    public WebElement stateOfIssueField;
    @FindBy(xpath = "//input[@id='mat-input-1']")
    public WebElement dateOfIssue;
    @FindBy(xpath = "//*[@data-fieldid='49']//textarea")
    public WebElement generalComments;
    @FindBy(xpath = "//i[@class='fa fa-floppy-o mr-2']")
    public WebElement saveButton;


    public void insertCompanyDetails() {
        companyName.sendKeys(name);
        formOfIncorporation.click();
        texCorporationNum.sendKeys(corporationNum);
        countryToTaxButton.click();
        countryToTax.click();
        BnNumber.click();
        generateRandomID();
        IDNumber.sendKeys(randomID);
        stateOfIssueButton.click();
        stateIsrael.click();
        dateOfIssue.sendKeys(date);
        generalComments.sendKeys(comment);

    }

    public void saveBPCompany() {
        saveButton.click();
    }

    public void chooseLastBPCompany() throws InterruptedException {
        driver.navigate().refresh();
        clickLastRow();
        Thread.sleep(10000);
    }


    public void clickLastRow() {
        // Find the table element
        WebElement table = driver.findElement(By.id("grid_1201724131_0_content_table"));

        // Find all rows in the table
        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Click the last row
        WebElement lastRow = rows.get(rows.size() - 1);
        lastRow.click();
    }

    public void assertBPCompanyDetails(JSONObject jsonObject) throws IllegalAccessException {
        Map<String, Object> map = jsonObject.toMap();
        List<Field> fields = Arrays.asList(this.getClass().getDeclaredFields());
        SoftAssert softAssert = new SoftAssert();

        for (Field x : fields) {
            String name = x.getName();
            if (!map.containsKey(name)) {
                continue;
            }
            x.setAccessible(true); // Allow accessing private fields
            Object fieldObject = x.get(this);
            if (fieldObject instanceof WebElement) {
                WebElement element = (WebElement) fieldObject;
                String tagName = element.getTagName();
                String expectedValue = map.get(name).toString();
                if (tagName.equals("option") || tagName.equals("span")) {
                    softAssert.assertEquals(element.getText(), expectedValue, "Field: " + name + " has incorrect value");
                } else {
                    softAssert.assertEquals(element.getAttribute("value"), expectedValue, "Field: " + name + " has incorrect value");
                }
            } else {
                // Handle other types of elements as needed
                // For example, if there are other types of elements that need special handling
                // You can add logic here to handle those cases
            }
        }
        softAssert.assertAll(); // Assert all soft assertions after processing all fields
    }

}










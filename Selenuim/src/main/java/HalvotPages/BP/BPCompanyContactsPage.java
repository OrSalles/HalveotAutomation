package HalvotPages.BP;

import HalvotPages.BasePage;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BPCompanyContactsPage extends BasePage {
    public BPCompanyContactsPage(WebDriver driver){
        super(driver);
    }
    String name = "ניקולה";
    @FindBy(xpath = "//b[contains(text(),'אנשי קשר')]")
    public WebElement contactsTab;
    @FindBy(xpath = "//i[@class='text-dark fa fa-list']")
    public WebElement contactsListButton;
    @FindBy(xpath = "//tr//th[@e-mappinguid='grid-column2402']//compound-grid-ejs-grid-generic-filter//*//input[@class='form-control bg-white border ng-star-inserted']")
    public WebElement searchContact;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header מספר טלפון')])[4]")
    public WebElement chooseContact;
    @FindBy(xpath = "//option[contains(text(),'מנהל כספים')]")
    public WebElement role;
    @FindBy(xpath = "//a[@class='btn btn-warning nav-link form-footer-link p-3 ml-2 mr-2']")
    public WebElement saveButton;
    @FindBy(xpath = "//form-label[@class='ng-star-inserted']//div//div//div[@class='ng-star-inserted'][normalize-space()='4']")
    public WebElement serialNumber;
    @FindBy(xpath = "//div[@class='mt-2']")
    public WebElement contactName;
    @FindBy(xpath = "//option[contains(text(),'רישיון נהיגה 1234567 - ישראל')]")
    public WebElement ID;
    @FindBy(xpath = "//option[contains(text(),'fff - 05222222 (סלולר)')]")
    public WebElement phoneNumber;
    @FindBy(xpath = "//option[normalize-space()='fff@gmail.com']")
    public WebElement email;

    public void moveToContactTab(){
        contactsTab.click();
    }

    public void chooseContact() throws InterruptedException {
        contactsTab.click();
        contactsListButton.click();
        //searchContact.sendKeys(name);
        chooseContact.click();
        role.click();
    }
    public void saveBPCompany(){
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

    public void assertBPCompanyContact(JSONObject jsonObject) throws IllegalAccessException {
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



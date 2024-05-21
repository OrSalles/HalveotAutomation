package HalvotPages.BP;

import HalvotPages.BasePage;
import Utils.JsonConvert;
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

public class BPPrivateContactInformationPage extends BasePage {
    public BPPrivateContactInformationPage(WebDriver driver){
        super(driver);
    }
    String state = "ישראל | 10";
    String phoneNumber = "098911772";
    String phoneText= "אישי";
    String website= "www.danel.com";
    String websiteName= "Danel";
    String emailAddress = "or@gmail.com";
    String emailInfo = "אישי";

    @FindBy(xpath = "//b[contains(text(),'פרטי התקשרות')]")
    public WebElement contactInformationTab;
    @FindBy(xpath = "//i[@class='text-dark fa fa-list']")
    public WebElement stateButton;
    @FindBy(xpath = "//div[@title='19']//input[@class='form-control bg-white border ng-star-inserted']")
    public WebElement stateField;
    @FindBy(xpath = "//td[@aria-label=' is template cell column header ארץ/מדינה']")
    public WebElement chooseState;
    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement district;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement city;
    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement street;
    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement houseNum;
    @FindBy(xpath = "(//input[@type='text'])[5]")
    public WebElement entrance;
    @FindBy(xpath = "(//input[@type='text'])[6]")
    public WebElement apartment;
    @FindBy(xpath = "(//input[@type='text'])[7]")
    public WebElement registeredMailAddress;
    @FindBy(xpath = "(//input[@type='text'])[8]")
    public WebElement postalCode;
    @FindBy(xpath = "(//input[@type='text'])[9]")
    public WebElement addressDescription;
    @FindBy(xpath = "//option[@value='10000']")
    public WebElement geographicArea;
    @FindBy(xpath = "//a[contains(text(),'הוספת כתובת')]")
    public WebElement addAddressButton;
    @FindBy(xpath = "//option[@value='1']")
    public WebElement typePhone;
    @FindBy(xpath = "(//input[@type='text'])[10]")
    public WebElement phoneNum;
    @FindBy(xpath = "(//input[@type='text'])[11]")
    public WebElement phoneDescription;
    @FindBy(xpath = "(//input[@type='text'])[12]")
    public WebElement webAddress;
    @FindBy(xpath = "(//input[@type='text'])[13]")
    public WebElement webName;
    @FindBy(xpath = "(//input[@type='text'])[14]")
    public WebElement email;
    @FindBy(xpath = "(//input[@type='text'])[15]")
    public WebElement emailDescription;
    @FindBy(xpath = "//a[@class='btn btn-warning nav-link form-footer-link p-3 ml-2 mr-2']")
    public WebElement saveButton;
    @FindBy(xpath = "//*[@data-fieldid='18']//input[@title='ישראל']")
    public WebElement stateIsrael;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[2]")
    public WebElement stateButton2;
    @FindBy(xpath = "(//option[@value='10000'][contains(text(),'ישראל')])[2]")
    public WebElement geographicArea2;
    @FindBy(xpath = "(//input[@type='text'])[10]")
    public WebElement district2;
    @FindBy(xpath = "(//input[@type='text'])[11]")
    public WebElement city2;
    @FindBy(xpath = "(//input[@type='text'])[12]")
    public WebElement street2;
    @FindBy(xpath = "(//input[@type='text'])[13]")
    public WebElement houseNum2;
    @FindBy(xpath = "(//input[@type='text'])[14]")
    public WebElement entrance2;
    @FindBy(xpath = "(//input[@type='text'])[15]")
    public WebElement apartment2;
    @FindBy(xpath = "(//input[@type='text'])[16]")
    public WebElement registeredMailAddress2;
    @FindBy(xpath = "(//input[@type='text'])[17]")
    public WebElement postalCode2;
    @FindBy(xpath = "(//input[@type='text'])[18]")
    public WebElement addressDescription2;
    @FindBy(xpath = "//*[@data-fieldid='18']//input[@title='ישראל']")
    public WebElement stateIsrael2;



    public String getStateIsrael(){
        return stateIsrael.getAttribute("value");
    }
    public String getGeographicArea(){
        return geographicArea.getText();
    }
    public String getTypePhone(){
        return typePhone.getText();
    }
    public String getStateIsrael2(){
        return stateIsrael.getAttribute("value");
    }
    public String getGeographicArea2() {
        return geographicArea.getText();
    }

    public void goToContactInformationTab(){
        contactInformationTab.click();
    }
    public void chooseStateAndGeographicArea(){
        stateButton.click();
        stateField.sendKeys(state);
        chooseState.click();
        geographicArea.click();
    }
    public void chooseStateAndGeographicArea2(){
        stateButton2.click();
        stateField.sendKeys(state);
        chooseState.click();
        geographicArea2.click();
    }

    public void insertBPPrivateContactInfo(JSONObject jsonObject) throws IllegalAccessException {
        Map<String, Object> map = jsonObject.toMap();
        List<Field> fields = Arrays.asList(this.getClass().getDeclaredFields());

        for(Field x: fields){
            String name = x.getName();
            if(!map.containsKey(name)){
                continue;
            };
            WebElement element = (WebElement) x.get(this);
            String value = map.get(name).toString();
            element.sendKeys(value);

        }

    }
    public void insetPhoneWebAndEmail(){
        typePhone.click();
    }
    public void saveBPPrivate() throws InterruptedException {
        saveButton.click();
        driver.navigate().refresh();
        clickLastRow();
        Thread.sleep(5000);
    }
    public void clickLastRow() {
        // Find the table element
        WebElement table = driver.findElement(By.id("grid_1575537353_0_content_table"));

        // Find all rows in the table
        java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Click the last row
        WebElement lastRow = rows.get(rows.size() - 1);
        lastRow.click();
    }
    public void assertBPPrivateContactInfo(JSONObject jsonObject) throws IllegalAccessException {
        Map<String, Object> map = jsonObject.toMap();
        //Map<String, Object> map = JsonConvert.jsonToMap(jsonObject);
        List<Field> fields = Arrays.asList(this.getClass().getDeclaredFields());

        SoftAssert softAssert = new SoftAssert();

        for (Field x : fields) {
            String name = x.getName();
            if (!map.containsKey(name)) {
                continue;
            }
            WebElement element = (WebElement) x.get(this);
            String value = map.get(name).toString();

            softAssert.assertEquals(element.getAttribute("value"), value, "Value not inserted correctly for element: " + name);
        }

        softAssert.assertAll();
    }

    public void pressAddAddressButton(){
        addAddressButton.click();
    }


}

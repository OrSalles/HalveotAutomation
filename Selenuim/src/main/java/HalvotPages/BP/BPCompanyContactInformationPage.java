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

public class BPCompanyContactInformationPage extends BasePage {
    public BPCompanyContactInformationPage(WebDriver driver){
        super(driver);
    }
    String state = "ישראל | 10";
    String districtName = "השרון";
    String cityName = "נתניה";
    String streetName = "הזית";
    String houseNumber = "4";
    String entranceNumber = "1";
    String apartmentNumber = "1";
    String registeredMailAddressNumber = "456123";
    String postalCodeNumber = "40599";
    String address= "פרטי";
    String cellNum= "0508903336";
    String cellDescription= "פרטי";
    String web = "www.danel.con";
    String webName= "Danel";
    String mailAddress = "danel@gmail.com";
    String mailDescription = "עסקי";
    @FindBy(xpath = "//b[contains(text(),'פרטי התקשרות')]")
    public WebElement contactTab;
    @FindBy(xpath = "//i[@class='text-dark fa fa-list']")
    public WebElement stateButton;
    @FindBy(xpath = "//input[@data-fielddataentrytype='19']")
    public WebElement stateField;
    @FindBy(xpath = "(//td[@aria-label=' is template cell column header ארץ/מדינה'])[1]")
    public WebElement selectedState;
    @FindBy(xpath = "//*[@data-fieldid='18']//input[@title='ישראל']")
    public WebElement stateIsrael;
    @FindBy(xpath = "//option[@value='10000']")
    public WebElement geographicArea;
    @FindBy(xpath = "//*[@data-fieldid='19']//input[@type='text']")
    public WebElement district;
    @FindBy(xpath = "//*[@data-fieldid='20']//input[@type='text']")
    public WebElement city;
    @FindBy(xpath = "//*[@data-fieldid='22']//input[@type='text']")
    public WebElement street;
    @FindBy(xpath = "//*[@data-fieldid='23']//input[@type='text']")
    public WebElement houseNum;
    @FindBy(xpath = "//*[@data-fieldid='24']//input[@type='text']")
    public WebElement entrance;
    @FindBy(xpath = "//*[@data-fieldid='25']//input[@type='text']")
    public WebElement apartment;
    @FindBy(xpath = "//*[@data-fieldid='26']//input[@type='text']")
    public WebElement registeredMailAddress;
    @FindBy(xpath = "//*[@data-fieldid='27']//input[@type='text']")
    public WebElement postalCode;
    @FindBy(xpath = "//*[@data-fieldid='17']//input[@type='text']")
    public WebElement addressDescription;
    @FindBy(xpath = "//option[@value='1']")
    public WebElement phoneType;
    @FindBy(xpath = "//*[@data-fieldid='14']//input[@type='text']")
    public WebElement phoneNum;
    @FindBy(xpath = "//*[@data-fieldid='12']//input[@type='text']")
    public WebElement phoneDescription;
    @FindBy(xpath = "//*[@data-fieldid='29']//input[@type='text']")
    public WebElement website;
    @FindBy(xpath = "//*[@data-fieldid='28']//input[@type='text']")
    public WebElement websiteName;
    @FindBy(xpath = "//*[@data-fieldid='16']//input[@type='text']")
    public WebElement email;
    @FindBy(xpath = "//*[@data-fieldid='15']//input[@type='text']")
    public WebElement emailDescription;
    @FindBy(xpath = "//a[@class='btn btn-warning nav-link form-footer-link p-3 ml-2 mr-2']")
    public WebElement saveButton;

    public void moveToContactTab(){
        contactTab.click();
    }

    public void insertAddress(){
        stateButton.click();
        stateField.sendKeys(state);
        selectedState.click();
        geographicArea.click();
        district.sendKeys(districtName);
        city.sendKeys(cityName);
        street.sendKeys(streetName);
        houseNum.sendKeys(houseNumber);
        entrance.sendKeys(entranceNumber);
        apartment.sendKeys(apartmentNumber);
        registeredMailAddress.sendKeys(registeredMailAddressNumber);
        postalCode.sendKeys(postalCodeNumber);
        addressDescription.sendKeys(address);
    }
    public void insertPhoneDetails(){
        phoneType.click();
        phoneNum.sendKeys(cellNum);
        phoneDescription.sendKeys(cellDescription);
    }
    public void insertWebsite(){
        website.sendKeys(web);
        websiteName.sendKeys(webName);
    }
    public void insertEmail(){
        email.sendKeys(mailAddress);
        emailDescription.sendKeys(mailDescription);
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

    public void assertBPCompanyContactInfo(JSONObject jsonObject) throws IllegalAccessException {
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

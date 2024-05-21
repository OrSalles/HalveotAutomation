package HalvotPages.BP;

import HalvotPages.BasePage;
import Utils.JsonConvert;
import Utils.JsonUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static Utils.RandomID.generateRandomID;

public class BPPrivateDetailsPage extends BasePage {
    public BPPrivateDetailsPage(WebDriver driver){
        super(driver);
    }

    String baseName = "שם פרטי";
    String randomID = generateRandomID();

    String FirstNameWithRandomID = baseName + randomID;
    String state = "ישראל | 10";
    String date = "01/01/1990";

    public String comment = "בדיקה";

    @FindBy(xpath = "//div[@class='h1 container mb-1 pt-3 p-2 ng-star-inserted']")
    public WebElement privateBPTitle;
    @FindBy(xpath = "//*[@data-fieldid='3']//input[@type='text']")
    public WebElement firsName;
    @FindBy(xpath = "//*[@data-fieldid='4']//input[@type='text']")
    public WebElement secondName;
    @FindBy(xpath = "//*[@data-fieldid='5']//input[@type='text']")
    public WebElement lastName;
    @FindBy(xpath = "//*[@data-fieldid='7']//input[@type='text']")
    public WebElement nickName;
    @FindBy(xpath = "//*[@data-fieldid='9']//input[@type='text']")
    public WebElement fatherName;
    @FindBy(xpath = "//select[@aria-label='מין']")
    public WebElement gender;
    @FindBy(xpath = "//select[@aria-label='סוג זיהוי']")
    public WebElement typeID;
    @FindBy(xpath = "//*[@data-fieldid='31']//input[@type='text']")
    public WebElement IDField;
    @FindBy(xpath = "//input[@class='form-control bg-white border ng-star-inserted']")
    public WebElement stateOfIssueField;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header מדינת הנפקה')])[2]")
    public WebElement stateIsrael;
    @FindBy(xpath = "//td[contains(@aria-label,'is template cell column header מדינת הנפקה')]//i[@class='text-dark fa fa-list']")
    public WebElement stateOfIssueButton;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[2]")
    public WebElement countryOfBirthButton;
    @FindBy(xpath = "//compound-grid-ejs-grid-generic-filter[@class='ng-star-inserted']//input[@class='form-control bg-white border ng-star-inserted']")
    public WebElement countryOfBirthField;
    @FindBy(xpath = "(//td[@aria-label=' is template cell column header מדינת לידה'])[1]")
    public WebElement countryOfBirthIsrael;
    @FindBy(xpath = "//*[@data-fieldid='49']//textarea[@class='form-control border border-secondary ng-untouched ng-pristine ng-valid ng-star-inserted']")
    public WebElement generalComments;
    @FindBy(xpath = "//a[@class='btn btn-warning nav-link form-footer-link p-3 ml-2 mr-2']")
    public WebElement saveButton;
    @FindBy(xpath = "//*[@data-fieldid='32']//input[@title='ישראל']")
    public WebElement stateOfIssue;
    @FindBy(xpath = "//*[@data-fieldid='51']//input[@title='ישראל']")
    public WebElement countryOfBirth;
    @FindBy(xpath = "//option[contains(text(),'זכר')]")
    public WebElement genderMale;
    @FindBy(xpath = "//option[contains(text(),'ת\"ז')]")
    public WebElement ID;


    public void insertBPPrivateDetails(JSONObject jsonObject) throws IllegalAccessException {
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

    public void selectGender(){
        genderMale.click();
//        Select dropdown = new Select(gender);
//        dropdown.selectByIndex(2);
    }

    public void insertIDStatesAndDates(){
//        Select dropdown2 = new Select(typeID);
//        dropdown2.selectByIndex(8);
        ID.click();
        generateRandomID();
        IDField.sendKeys(randomID);
        stateOfIssueButton.click();
        stateOfIssueField.sendKeys(state);
        stateIsrael.click();
        dates(date);
        countryOfBirthButton.click();
        countryOfBirthField.sendKeys(state);
        countryOfBirthIsrael.click();
    }
    public void chooseStateOfIssue() throws InterruptedException {
        stateOfIssueButton.click();
        stateOfIssueField.sendKeys(state);
        stateIsrael.click();
    }
    public void dates(String date) {
        List<WebElement> formDates = driver.findElements(By.tagName("form-date-combo-2"));
        WebElement[] formArray = formDates.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[1].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
    }
    public void chooseDatesAndCountryOfBirth() throws InterruptedException {
        dates(date);
        countryOfBirthButton.click();
        countryOfBirthField.sendKeys(state);
        countryOfBirthIsrael.click();
    }
    public void insertCommentAndSave() throws InterruptedException {
        generalComments.sendKeys(comment);
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

    public void assertBPPrivateDetails(JSONObject jsonObject) throws IllegalAccessException {
        Map<String, Object> map = jsonObject.toMap();
        List<Field> fields = Arrays.asList(this.getClass().getDeclaredFields());

        // Create a SoftAssert instance
        SoftAssert softAssert = new SoftAssert();

        for (Field x : fields) {
            String name = x.getName();
            if (!map.containsKey(name)) {
                continue;
            }
            WebElement element = (WebElement) x.get(this);
            String value = map.get(name).toString();

            // Perform soft assertions
            softAssert.assertEquals(element.getAttribute("value"), value, "Value not inserted correctly for element: " + name);
        }

        // Assert all soft assertions
        softAssert.assertAll();
    }
    public String getGenderMale(){
        return genderMale.getText();
    }
    public String getID(){
        return ID.getText();
    }
    public String getStateOfIssue(){
        return stateOfIssue.getAttribute("value");
    }
    public String getCountryOfBirth(){
        return countryOfBirth.getAttribute("value");
    }
    public String getGeneralComments(){
        return generalComments.getAttribute("value");
    }
    public void assertBPPrivateIDTypeAndCountry(JSONObject jsonObject) throws IllegalAccessException {
        Map<String, Object> map = jsonObject.toMap();
        List<Field> fields = Arrays.asList(this.getClass().getDeclaredFields());

        // Create a SoftAssert instance
        SoftAssert softAssert = new SoftAssert();

        for (Field x : fields) {
            String name = x.getName();
            if (!map.containsKey(name)) {
                continue;
            }
            WebElement element = (WebElement) x.get(this);
            String value = map.get(name).toString();

            // Perform soft assertions
            softAssert.assertEquals(element.getAttribute("value"), value, "Value not inserted correctly for element: " + name);
        }

        // Assert all soft assertions
        softAssert.assertAll();
    }








}


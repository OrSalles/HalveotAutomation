package HalvotPages.Loan;

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

public class LoanExtraDetailsPage extends BasePage {
    public LoanExtraDetailsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//div[@class='formContainer']//onboarding//div[@class='d-flex flex-column position-absolute ng-star-inserted']//div//b[contains(text(),'פרטים נוספים')]")
    public WebElement ExtraDetailsTab;
    @FindBy(xpath = "//input[@title='אג\"ח להמרה לא סחיר | 2800']")
    public WebElement TatAfik;
    @FindBy(xpath = "//span[@title='אג\"ח להמרה לא סחיר']")
    public WebElement Afik;
    @FindBy(xpath = "//onboarding-field-readonly[@title='1036']//*//span")
    public WebElement Manpik;
    @FindBy(xpath = "//input[@title='Energy | 42']")
    public WebElement Anaf;
    @FindBy(xpath = "//input[@title='ACADIAN']")
    public WebElement IssuingCountry;
    @FindBy(xpath = "//input[@title='אלביט']")
    public WebElement TradingCountry;
    @FindBy(xpath = "//input[@title='א. לוי']")
    public WebElement ExposureState;
    @FindBy(xpath = "//option[@value='10000']")
    public WebElement GeographicArea;
    @FindBy(xpath = "//input[@title='בדיקה | 1']")
    public WebElement Borsa;
    @FindBy(xpath = "//input[@title='GOLDMAN SACHS | 80']")
    public WebElement Konzrn;
    @FindBy(xpath = "//input[@title='1אלקטרה נדלן אג | 1094051']")
    public WebElement Property;
    @FindBy(xpath = "//input[@title='5']")
    public WebElement BaseAssetMultiplier;
    @FindBy(xpath = "//input[@title=' | 397']")
    public WebElement CoinExposure;
    @FindBy(xpath = "//option[@value='23']")
    public WebElement TypeForRiskManagement;
    @FindBy(xpath = "//input[contains(@title,'להמרה-אחר | 28')]")
    public WebElement AttachmentType;

    public void goToExtraDetailsTab() throws InterruptedException {
        //tabs();
        Thread.sleep(2000);
        ExtraDetailsTab.click();
    }
    public void tabs() throws InterruptedException {
        List<WebElement> formTabs = driver.findElements(By.tagName("popover-form-modal"));
        WebElement[] formArray = formTabs.stream().toArray(WebElement[]::new);
            formArray[1].findElement(By.xpath("./div/onboarding/div/div/onboarding-tabs/div/*/*/*/*/*/ul/li/a/span/b")).click();
    }

    public void assertLoanExtraDetails(JSONObject jsonObject) throws IllegalAccessException {
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
    public String getTatAfik(){
        return TatAfik.getAttribute("value");
    }
    public String getAfik(){
        return Afik.getText();
    }
    public String getManpik(){
        return Manpik.getAttribute("value");
    }
    public String getAnaf(){
        return Anaf.getAttribute("value");
    }
    public String getIssuingCountry(){
        return IssuingCountry.getAttribute("value");
    }
    public String getTradingCountry(){
        return TradingCountry.getAttribute("value");
    }
    public String getExposureState(){
        return ExposureState.getAttribute("value");
    }
    public String getGeographicArea(){
        return GeographicArea.getText();
    }
    public String getBorsa(){
        return Borsa.getAttribute("value");
    }
    public String getKonzrn(){
        return Konzrn.getAttribute("value");
    }
    public String getProperty(){
        return Property.getAttribute("value");
    }
    public String getBaseAssetMultiplier(){
        return BaseAssetMultiplier.getAttribute("value");
    }
    public String getCoinExposure(){
        return CoinExposure.getAttribute("value");
    }
    public String getTypeForRiskManagement(){
        return TypeForRiskManagement.getText();
    }
    public String getAttachmentType(){
        return AttachmentType.getAttribute("value");
    }


}

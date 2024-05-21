package HalvotPages.Deal;

import HalvotPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DealExtraDetailsPage extends BasePage {

    public DealExtraDetailsPage(WebDriver driver){
        super(driver);
    }
    String date = "10/12/2023";
    String BaseAssetMultiplier= "5";
    String anafName= "Energy | 42";

    @FindBy(xpath = "//b[contains(text(),'פרטים נוספים')]")
    public WebElement extraDetailsTab;
    @FindBy(xpath = "//autocomplete-field/*/*/*/*/I")
    public WebElement tatAfikButton;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header תת אפיק')])[1]")
    public WebElement chosenTatAfik;
    @FindBy(xpath = "//input[@type='number']")
    public WebElement baseAssetMultiplier;
    @FindBy(xpath = "//span[@title='אג\"ח להמרה לא סחיר']")
    public WebElement afik;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[2]")
    public WebElement manpikButton;
    @FindBy(xpath = "(//td[@aria-label=' is template cell column header מנפיק'])[3]")
    public WebElement chosenManpik;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[2]")
    public WebElement anafButton;
    @FindBy(xpath = "(//th[contains(@class,'e-filterbarcell')])[6]")
    public WebElement anafField;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header ענף')])[4]")
    public WebElement chosenAnaf;
    @FindBy(xpath ="(//i[@class='text-dark fa fa-list'])[3]")
    public WebElement medinaManpika;
    @FindBy(xpath = "//tr[@class='e-row e-altrow']//td[contains(@aria-label,'is template cell column header מדינה מנפיקה')]")
    public WebElement chosenMedinaManpika;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[4]")
    public WebElement medinaNisheret;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header מדינה נסחרת')])[244]")
    public WebElement chosenMedinaNisheret;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[5]")
    public WebElement medinatHasifa;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header מדינת חשיפה')])[233]")
    public WebElement chsenMedinatHasifa;
    @FindBy(xpath = "//select[@aria-label='אזור גאוגרפי']")
    public WebElement GeographicArea;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[6]")
    public WebElement borsa;
    @FindBy(xpath = "//td[@aria-label=' is template cell column header בורסה']")
    public WebElement chosenBorsa;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[7]")
    public WebElement konzren;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header קונצרן')])[4]")
    public WebElement chosenKonzren;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[8]")
    public WebElement nehesBasis;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header נכס בסיס')])[18]")
    public WebElement chosenNehesBasis;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[9]")
    public WebElement madadMatbeaHasifa;
    @FindBy(xpath = "(//td[contains(@aria-label,'is template cell column header מדד מטבע חשיפה')])[1]")
    public WebElement chosenMadadMatbeaHasifa;
    @FindBy(xpath = "//select[@aria-label='סוג לניהול סיכונים']")
    public WebElement sogNiholSiconim;
    @FindBy(xpath = "(//i[@class='text-dark fa fa-list'])[10]")
    public WebElement sogHatzmada;
    @FindBy(xpath = "(//td[@aria-label=' is template cell column header סוג הצמדה'])[1]")
    public WebElement chosenSogHatzmada;

    public void dates(String date){
        List<WebElement> formDates= driver.findElements(By.tagName("form-date-combo-2"));
        WebElement[]formArray=formDates.stream().toArray(WebElement[]::new);
        formArray[0].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[1].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[2].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[3].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[4].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[5].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[6].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[7].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
        formArray[8].findElement(By.xpath("./div/mat-form-field/*/*/*/input")).sendKeys(date);
    }
    public void general() throws InterruptedException {
        tatAfikButton.click();
        chosenTatAfik.click();
//        manpikButton.click();
//        chosenManpik.click();
        anafButton.click();
        //anafField.click();
//        anafField.sendKeys(anafName);
//        Thread.sleep(1000);
        chosenAnaf.click();
        medinaManpika.click();
        chosenMedinaManpika.click();
        medinaNisheret.click();
        chosenMedinaNisheret.click();
        medinatHasifa.click();
        chsenMedinatHasifa.click();
        Select dropdown = new Select(GeographicArea);
        dropdown.selectByIndex(1);
        borsa.click();
        chosenBorsa.click();
        konzren.click();
        chosenKonzren.click();
    }
    public void exposure(String BaseAssetMultiplier){
        nehesBasis.click();
        chosenNehesBasis.click();
        baseAssetMultiplier.sendKeys(BaseAssetMultiplier);
        madadMatbeaHasifa.click();
        chosenMadadMatbeaHasifa.click();
        Select dropdown1 = new Select(sogNiholSiconim);
        dropdown1.selectByIndex(1);
        sogHatzmada.click();
        chosenSogHatzmada.click();
    }
    public void goToExtraDetailsTabAndFillingOutTheFields() throws InterruptedException {
        extraDetailsTab.click();
        dates(date);
        general();
        exposure(BaseAssetMultiplier);
    }
    public String getAfik(){
        return afik.getText();
    }









}

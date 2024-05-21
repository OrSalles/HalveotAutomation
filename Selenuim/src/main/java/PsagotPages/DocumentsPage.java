package PsagotPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocumentsPage {
    @FindBy(xpath = "//side-bar/*/*/*/*[contains(text(),' מסמכים ' )]")
    public WebElement documentsButton;
    @FindBy(xpath = "//td[@title='ReportToCustomer_1.pdf__23082022..pdf']")
    public WebElement file;
    @FindBy(xpath = "//dashboard-header/ul/li/a[contains(text(),'טפסים')]")
    public WebElement formsTab;
    @FindBy(xpath = "(//td[contains(@aria-label,'אפיון צרכי לקוח תקופתי column header Header')][contains(text(),'אפיון צרכי לקוח תקופתי')])[1]")
    public WebElement formFromList;
    @FindBy(xpath = "//div[contains(@class,'py-4')]")
    public WebElement titleForm;
    @FindBy(xpath = "//a[contains(text(),'המשך')]")
    public WebElement continuedButtonForm;
    @FindBy(xpath = "//a[@class='btn btn-primary pull-right']")
    public WebElement doneButtonForm;
    @FindBy(xpath = "//h1[contains(text(),'סיום')]")
    public WebElement doneFormButton;
    @FindBy(xpath = "//a[normalize-space()='×']")
    public WebElement closeButton;
    @FindBy(xpath = "//i[@class='fa fa-plus']")
    public WebElement plusButton;
    @FindBy(xpath = "//a[contains(text(),'אפיון צרכי לקוח תקופתי')]")
    public WebElement openForm;
    @FindBy(xpath = "//a[contains(text(),'המשך')]")
    public WebElement continuedButton;
    @FindBy(xpath = "//a[@class='btn btn-primary pull-right']")
    public WebElement doneButton;
    @FindBy(xpath = "//h1[contains(text(),'סיום')]")
    public WebElement doneTitle;
    @FindBy(xpath = "//a[normalize-space()='×']")
    public WebElement closeWindowButton;











}

package PsagotPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage {
    @FindBy(xpath = "//side-bar/*/*/*/*[contains(text(), ' פרטים אישיים ')]")
    public WebElement personalDetailsButton;
    @FindBy(xpath = "//fieldset/*/*/input[@id='firstName']")
    public WebElement firstNameField;
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameField;
    @FindBy(xpath = "//input[@id='id']")
    public WebElement IdField;
    @FindBy(xpath = "//input[@id='bank']")
    public WebElement bankField;
    @FindBy(xpath = "//input[@id='branch']")
    public WebElement branchField;
    @FindBy(xpath = "//input[@id='account']")
    public WebElement accountField;
    @FindBy(xpath = "//input[@id='street']")
    public WebElement streetField;
    @FindBy(xpath = "//input[@id='houseNum']")
    public WebElement houseNum;
    @FindBy(xpath = "//input[@id='entrance']")
    public WebElement entrance;
    @FindBy(xpath = "//input[@id='apartment']")
    public WebElement apartment;
    @FindBy(xpath = "//select[@id='country']")
    public WebElement countryDropdown;
    @FindBy(xpath = "//button[contains(text(),'שמירת שינויים')]")
    public WebElement saveButton;
    @FindBy(xpath = "//dashboard-header/ul/li/a[contains(text(),'בעלי חשבון')]")
    public WebElement accountHoldersTab;
    @FindBy(xpath = "//td[contains(@title,'007767437')]")
    public WebElement ID1;
    @FindBy(xpath = "//td[@title='999061112']")
    public  WebElement ID2;
    @FindBy(xpath = "//td[@title='999066756']")
    public WebElement ID3;
    @FindBy(xpath = "//td[@title='999111388']")
    public WebElement ID4;
    @FindBy(xpath = "//td[@title='999125834']")
    public WebElement ID5;
    @FindBy(xpath = "//td[@title='999897614']")
    public WebElement ID6;




    }



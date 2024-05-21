package PsagotPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InquiriesPage {
    @FindBy(xpath = "//side-bar/*/*/*/*[contains(text(), ' הודעות ')]")
    public WebElement messagesButton;
    @FindBy(xpath = "//h2[contains(text(),'הודעות')]")
    public WebElement messagesPageTitle;
    @FindBy(xpath = "//a[contains(text(),'היי , אנא הסתכל על הסקירות')]")
    public WebElement message;
    @FindBy(xpath = "//button[contains(text(),'אישור')]")
    public WebElement closeMessageButton;
    @FindBy(xpath = "//dashboard-header/ul/li/a[contains(text(),'הפניות שלי')]")
    public WebElement myReference;
    @FindBy(xpath = "//i[@class='mr-2 fa fa-edit']")
    public WebElement newAppeal;
    @FindBy(xpath = "//div[@id='crmModalLabel']")
    public WebElement ContactUsTitle;
    @FindBy(xpath = "//select[@id='chatType_crm']")
    public WebElement selectType;
    @FindBy(xpath = "//td[@aria-label='jhgj column header נושא הפניה']")
    public WebElement appealSubject;
    @FindBy(xpath = "//div[contains(@class,'message px-2 py-1 mb-1 card text-white bg-primary text-left')]")
    public WebElement appealText;
    @FindBy(xpath = "//textarea-fluid[@id='chatTopic']//textarea[@aria-label='נא ציין את נושא הפניה ופרט בקצרה']")
    public WebElement theSubject;
    @FindBy(xpath = "//div[@id='crmModal']//button[@type='button'][contains(text(),'שליחה')]")
    public WebElement sendButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alert;
    @FindBy(xpath = "//dashboard-header/ul/li/a[contains(text(),'סקירות')]")
    public WebElement reviewsTab;
    @FindBy(xpath = "//td[@title='ReportToCustomer_100.pdf']")
    public WebElement downloadButton;






}

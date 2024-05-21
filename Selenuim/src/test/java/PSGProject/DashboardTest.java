package PSGProject;

import PsagotPages.*;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DashboardTest {
    WebDriver driver;
    Actions actions;
    LoginPage login;
    PageEnterCodePage EnterCode;
    TopBarAccountPage TopBar;
    InquiriesPage inquiries;
    DocumentsPage documents;
    MyAccountPage MyAccount;
    PersonalDetailsPage personalDetails;
    String ID = "999125834";
    String Phone = "0528903336";
    String codeNum = "123";

    @BeforeClass
    public void startSession() throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://danel-db:5200/");
        java.awt.Robot robot = new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_K);
        Thread.sleep(4000);
        robot.keyRelease(KeyEvent.VK_K);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("http://danel-db:5201/api/");
        driver.switchTo().alert().accept();
        login = PageFactory.initElements(driver, LoginPage.class);
        EnterCode = PageFactory.initElements(driver, PageEnterCodePage.class);
        TopBar = PageFactory.initElements(driver, TopBarAccountPage.class);
        MyAccount = PageFactory.initElements(driver, MyAccountPage.class);
        inquiries = PageFactory.initElements(driver, InquiriesPage.class);
        documents = PageFactory.initElements(driver, DocumentsPage.class);
        personalDetails = PageFactory.initElements(driver, PersonalDetailsPage.class);
        login.SignIn(ID, Phone);
        login.btn_SENDCODEBUTTON.click();
        EnterCode.enterCode(codeNum);
        Thread.sleep(1000);
    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }

    @Attachment(value = "page screenshot",type = "image/png")
    public byte[] saveScreenShot(WebDriver driver){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        return scrShot.getScreenshotAs(OutputType.BYTES);

    }

    @Test(description = "Verify TopBar Titles")
    @Description("Verify name account,account value,account yield, date,level of risk,policy,investment policy")
    public void test01VerifyTopBar() throws InterruptedException {
        Thread.sleep(3000);
        String actualTitle1 = TopBar.LevelOfRisk.getText();
        String expectedTitle1 = "רמת סיכון: בינונית גבוהה\n" +
                "הצג רמז צץ";
        Assert.assertEquals(actualTitle1, expectedTitle1);
        TopBar.LevelOfRisk.click();
        String actualTitle2 = TopBar.PolicyName.getText();
        String expectedTitle2 = "שם המדיניות: תיק 50% -פרטיים ועדה";
        Assert.assertEquals(actualTitle2, expectedTitle2);
        String actualTitle3 = TopBar.InvestmentPolicy.getText();
        String expectedTitle3 = "מדיניות השקעה: תיק 50% פרטיים ועדה";
        Assert.assertEquals(actualTitle3, expectedTitle3);
        String expectedTitle4 = "חשבון100 *לא לגעת בבעלי חשבון נרקיס**-";
        String actualTitle4 = TopBar.NameAccount.getText();
        Assert.assertEquals(actualTitle4, expectedTitle4);
        String actualTitle5 = TopBar.AccountValue.getText();
        String expectedTitle5 = "₪1,394,625";
        Assert.assertEquals(actualTitle5, expectedTitle5);
        String actualTitle6 = TopBar.AccountYield.getText();
        System.out.println(TopBar.AccountYield.getText());
        String expectedTitle6 = "0.01%\n" +
                "Up";
        Assert.assertEquals(actualTitle6, expectedTitle6);
        String actualTitle7 = TopBar.Date.getText();
        String expectedTitle7 = "14/12/2023";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle7, expectedTitle7);
        }



    @Test(description = "Verify MyAccount page titles")
    @Description("Titles=הרכב תיק, פירוט אחזקות ")
    public void test02VerifyTitleAccountComposition() throws InterruptedException {
        MyAccount.MyAccountButton.click();
        String actualTitle1 = MyAccount.AccountComposition.getText();
        String expectedTitle1 = "הרכב תיק";
        Assert.assertEquals(actualTitle1, expectedTitle1);
        String actualTitle2 = MyAccount.DetailsOfHoldings.getText();
        String expectedTitle2 = "פירוט אחזקות";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle2, expectedTitle2);

    }


    @Test(description = "Verify Pie image")
    @Description("Verify PieAccount IsDisplayed")
    public void test03VerifyPieAccountIsDisplayed() throws InterruptedException {
        if (MyAccount.PieAccount.isDisplayed()) {
            System.out.println("Image is displayed.");
        } else {
            System.out.println("Image is not displayed.");
        }
    }

    @Test(description = "Verify parts in the Pie ")
    @Description("Verify elements in the pie")
    public void test04VerifyPieStock() throws InterruptedException {
        Thread.sleep(2000);
        actions = new Actions(driver);
        actions.moveToElement(MyAccount.pieElement01).click();
        actions.build().perform();
        Assert.assertTrue(MyAccount.pieElement01.isDisplayed());
        Thread.sleep(1000);
        actions.moveToElement(MyAccount.pieElement02).click();
        actions.build().perform();
        Assert.assertTrue(MyAccount.pieElement02.isDisplayed());
        Thread.sleep(1000);
        actions.moveToElement(MyAccount.pieElement03).click();
        actions.build().perform();
        saveScreenShot(driver);
        Assert.assertTrue(MyAccount.pieElement03.isDisplayed());
    }

    @Test(description = "Verify Annual return page Titles")
    @Description("Verify titles page= תשואה שנתית, פירוט תשואות")
    public void test05VerifyTitleAnnualReturn() throws InterruptedException {
        Thread.sleep(1000);
        MyAccount.AccountReturnsTab.click();
        String actualTitle = MyAccount.AnnualReturn.getText();
        String expectedTitle = "תשואה שנתית";
        Assert.assertEquals(actualTitle, expectedTitle);
        String actualTitle1 = MyAccount.DetailsOfReturns.getText();
        String expectedTitle1 = "פירוט תשואות";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle1, expectedTitle1);

    }


    @Test(description = "Verify movements page")
    @Description("Verify titles in movements page")
    public void test06VerifyFromMovementsTab() throws InterruptedException {
        Thread.sleep(1000);
        MyAccount.movementsTab.click();
        MyAccount.fromBeginningOfTheMonth.click();
        Assert.assertTrue(MyAccount.fromBeginningOfTheMonth.isEnabled());
        Thread.sleep(1000);
        MyAccount.fromBeginningOgTheYear.click();
        Assert.assertTrue(MyAccount.fromBeginningOgTheYear.isEnabled());
        Thread.sleep(1000);
        MyAccount.theLest12Months.click();
        saveScreenShot(driver);
        Assert.assertTrue(MyAccount.theLest12Months.isEnabled());
    }

    @Test(description = "Verify messages page")
    @Description("Verify messages titles page")
    public void test07VerifyMessagesPageTitle() {
        inquiries.messagesButton.click();
        String actualTitle = inquiries.messagesPageTitle.getText();
        String expectedTitle = "הודעות";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

   @Test(description = "Verify messages from the list")
   @Description("Verify open message from the list")
    public void test08penMessageFromList() throws InterruptedException {
        inquiries.messagesButton.click();
        inquiries.message.click();
        Assert.assertTrue(inquiries.message.isEnabled());
       Thread.sleep(2000);
        Actions actions1 = new Actions(driver);
        actions1.moveToElement( inquiries.closeMessageButton).doubleClick(inquiries.closeMessageButton).perform();
        Thread.sleep(6000);
       saveScreenShot(driver);
        Assert.assertTrue(inquiries.closeMessageButton.isEnabled());

    }

    @Test(description = "open new appeal")
    @Description("Save new appeal and verify alert")
    public void test09openNewAppeal() throws InterruptedException {
        Thread.sleep(3000);
        inquiries.messagesButton.click();
        inquiries.myReference.click();
        inquiries.newAppeal.click();
        Select dropdown = new Select(inquiries.selectType);
        dropdown.selectByIndex(1);
        inquiries.theSubject.sendKeys("test");
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(inquiries.sendButton).doubleClick(inquiries.sendButton).perform();
        Thread.sleep(10000);
        String actualTitle = inquiries.alert.getText();
        String expectedTitle = "ההודעה נשלחה בהצלחה\n" +
                "×";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Verify download review")
    @Description("Download review to folder")
    public void test10VerifyDownloadReview() throws InterruptedException {
        inquiries.messagesButton.click();
        inquiries.reviewsTab.click();
        inquiries.downloadButton.click();
        String downloadDir = "C:\\Users\\or\\Downloads";
        File downloadedFile = getLatestFileFromDirectory(downloadDir);
    }

    private static File getLatestFileFromDirectory(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            throw new RuntimeException("No files found in the directory: " + dirPath);
        }
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }



    @Test(description = "Verify download document")
    @Description("Download document to folder")
    public void test11VerifyDownloadDocument(){
        documents.documentsButton.click();
        documents.file.click();
        String downloadDir1 = "C:\\Users\\or\\Downloads";
        File downloadedFile = getLatestFileFromDirectory(downloadDir1);
    }

    private static File getLatestFileFromDirectory1(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            throw new RuntimeException("No files found in the directory: " + dirPath);
        }
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;

    }
    @Test(description = "Verify form from the list")
    @Description("verify title of form from the list")
    public void test12VerifyFormFromList() throws InterruptedException {
        documents.documentsButton.click();
        Thread.sleep(1000);
        documents.formsTab.click();
        Thread.sleep(1000);
        documents.formFromList.click();
        Thread.sleep(1000);
        String actualTitle =documents.titleForm.getText();
        String expectedTitle = "מערכת הטפסים המקוונים של פסגות";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle, expectedTitle);
        documents.continuedButtonForm.click();
        Thread.sleep(1000);
        documents.doneButtonForm.click();
        Thread.sleep(1000);
        documents.closeButton.click();
    }
    @Test(description = "Open new form")
    @Description("Verify the end of the new form")
    public void test13OpenNewForm() throws InterruptedException {
        documents.documentsButton.click();
        documents.formsTab.click();
        Thread.sleep(1000);
        documents.plusButton.click();
        Thread.sleep(1000);
        documents.openForm.click();
        Thread.sleep(1000);
        documents.continuedButton.click();
        Thread.sleep(1000);
        documents.doneButton.click();
        Thread.sleep(1000);
        String actualTitle =documents.doneTitle.getText();
        String expectedTitle = "סיום";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle, expectedTitle);
        documents.closeWindowButton.click();
    }
    @Test(description = "Changing Fields PersonalDetails")
    @Description("Verify Changing Fields PersonalDetails and save")
    public void test14ChangingFieldsPersonalDetails() throws InterruptedException {
        personalDetails.personalDetailsButton.click();
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        personalDetails.streetField.clear();
        Thread.sleep(1000);
        String address =  " ויטק " + randomNumber;
        personalDetails.streetField.sendKeys(address);
        Thread.sleep(1000);
        personalDetails.houseNum.clear();
        Thread.sleep(1000);
        String house =" " + randomNumber;
        personalDetails.houseNum.sendKeys(house);
        Thread.sleep(1000);
        personalDetails.entrance.clear();
        Thread.sleep(1000);
        String entrance =" " + randomNumber;
        personalDetails.entrance.sendKeys(entrance);
        Thread.sleep(1000);
        personalDetails.apartment.clear();
        Thread.sleep(1000);
        String apartment =" " + randomNumber;
        personalDetails.apartment.sendKeys(apartment);
        Select select = new Select(personalDetails.countryDropdown);
        List<WebElement> options = select.getOptions();
        int randomIndex = random.nextInt(options.size());
        select.selectByIndex(randomIndex);
        personalDetails.saveButton.click();
        saveScreenShot(driver);
        Assert.assertTrue(personalDetails.saveButton.isEnabled());
    }
    @Test(description = "Verify PersonalDetails page")
    @Description("Verify fields in PersonalDetails page")
    public void test15VerifyPersonalDetailsFields(){
        personalDetails.personalDetailsButton.click();
        String actualTitle1 =personalDetails.firstNameField.getAttribute("value");
        String expectedTitle1 = "בעל";
        Assert.assertEquals(actualTitle1, expectedTitle1);
        String actualTitle2 =personalDetails.lastNameField.getAttribute("value");
        String expectedTitle2 = "חשבון100";
        Assert.assertEquals(actualTitle2, expectedTitle2);
        String actualTitle3 =personalDetails.IdField.getAttribute("value");
        String expectedTitle3 = ID;
        Assert.assertEquals(actualTitle3, expectedTitle3);
        String actualTitle4 =personalDetails.bankField.getAttribute("value");
        String expectedTitle4 = "פסגות";
        Assert.assertEquals(actualTitle4, expectedTitle4);
        String actualTitle5 =personalDetails.branchField.getAttribute("value");
        String expectedTitle5 = "1";
        Assert.assertEquals(actualTitle4, expectedTitle4);
        String actualTitle6 =personalDetails.accountField.getAttribute("value");
        String expectedTitle6 = "0000050098";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle6, expectedTitle6);
    }
    @Test(description = "Verify account holders")
    @Description("Verify holders id numbers")
    public void test16VerifyAccountHolders() {
        personalDetails.personalDetailsButton.click();
        personalDetails.accountHoldersTab.click();
        String actualTitle1 = personalDetails.ID1.getText();
        String expectedTitle1 = "007767437";
        Assert.assertEquals(actualTitle1, expectedTitle1);
        String actualTitle2 = personalDetails.ID2.getText();
        String expectedTitle2 = "999061112";
        Assert.assertEquals(actualTitle2, expectedTitle2);
        String actualTitle3 = personalDetails.ID3.getText();
        String expectedTitle3 = "999066756";
        Assert.assertEquals(actualTitle3, expectedTitle3);
        String actualTitle4 = personalDetails.ID4.getText();
        String expectedTitle4 = "999111388";
        Assert.assertEquals(actualTitle4, expectedTitle4);
        String actualTitle5 = personalDetails.ID5.getText();
        String expectedTitle5 = "999125834";
        Assert.assertEquals(actualTitle5, expectedTitle5);
        String actualTitle6 = personalDetails.ID6.getText();
        String expectedTitle6 = "999897614";
        saveScreenShot(driver);
        Assert.assertEquals(actualTitle6, expectedTitle6);
    }




}









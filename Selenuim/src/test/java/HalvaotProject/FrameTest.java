package HalvaotProject;

import HalvotPages.Deal.DealDetailsPage;
import HalvotPages.Deal.DealTablePage;
import HalvotPages.Frame.*;
import Utils.JsonUtils;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

import org.testng.asserts.SoftAssert;
import HalvotPages.*;

import java.io.IOException;

import static Utils.RandomID.generateRandomID;
import static Utils.ReportUtils.saveScreenShot;


public class FrameTest extends BaseFrameTest {

    String NameOfDeal = "עסקה אוטומציה";
    String amountDeal = "10,000";
    String amountFrame = "5000";
    String explanation = "בדיקה";
    String fieldsDealOffers = "5";
    String date = "10/12/2023";
    String endDateFrame = "30/12/2023";
    String BaseAssetMultiplier = "5";
    String path = "X:\\פריוריטי\\Or Baron\\1.docx";
    String baseName = "מסגרת אוטומציה";
    String randomID = generateRandomID();

    String FrameNameWithRandomID = baseName + randomID;
    private String csvFilePath = "S:\\Danel_HB_022023\\Assets_for_automation\\Assets.csv";

    private CSVReader csvReader;
    private CSVWriter csvWriter;
    private static String testData = "TestData.json";
    private static  String urlData = "urlData.json";
    String websiteUrl = "";
    String APIUrl = "";




    @Test(description = "בדיקת שדות חישוביים של סכום מסגרת, % מסגרת מעסקה, יתרת עסקה לפני, יתרת עסקה לאחר")
    @Description("בדיקת שדות-סכום מסגרת=5,000 ,% מסגרת מעסקה= 50,יתרת עסקה לפני=10,000,יתרת עסקה לאחר=5,000 ")
    public void test01VerifyAmountsFields() throws InterruptedException, IOException {
        JSONObject test1Data = JsonUtils.returnJsonObject(testData, "testFrame1");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        FrameDetailsPage frameDetails= pageLoader.frameDetails;
        frameDetails.InsertFrameNameDatesAndAmountFrame();
        softAssert.assertEquals(frameDetails.getFrameAmountInShekel(), test1Data.get("frameAmountInShekel"));
        softAssert.assertEquals(frameDetails.getPercentageFrameFromDeal(), test1Data.get("percentageFrameFromDeal"));
        softAssert.assertEquals(frameDetails.getDealAmountBefore(), test1Data.get("dealAmountBefore"));
        softAssert.assertEquals(frameDetails.getDealAmountAfter(), test1Data.get("dealAmountAfter"));
        softAssert.assertAll();
    }

    @Test(description = "בדיקת הורשה- פרטי מסגרת")
    @Description("בדיקת סטטוס עסקה= פוטנציאלית,סוג אשראי= ישיר, מטרת האשראי= רכישת שליטה, מעמדנו בעסקה= משקיע הוגן")
    public void test02OpenNewFrame() throws InterruptedException, IOException {
        JSONObject tes2Data = JsonUtils.returnJsonObject(testData, "testFrame2");
        pageLoader = new PageLoader(driver);
        FrameDetailsPage frameDetails= pageLoader.frameDetails;
        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(1000);
        softAssert.assertEquals(frameDetails.getDealStatus(), tes2Data.get("dealStatus"));
        softAssert.assertEquals(frameDetails.getCreditType(), tes2Data.get("creditType"));
        softAssert.assertEquals(frameDetails.getCreditPurpose(), tes2Data.get("creditPurpose"));
        softAssert.assertEquals(frameDetails.getDealPosition(), tes2Data.get("dealPosition"));
        softAssert.assertAll();
    }

    @Test(description = "בדיקת הורשה- לווה ראשי")
    @Description("בדיקת לווה ראשי= מיאמי בעמ, זיהוי לווה= ח\"פ 12345679 - ישראל, טלפון לווה= ייי - 052336666 (סלולר), אימייל לווה= miamigmail.com ")
    public void test03VerifyBorrower() throws InterruptedException, IOException {
        JSONObject tes3Data = JsonUtils.returnJsonObject(testData, "testFrame3");
        pageLoader = new PageLoader(driver);
        FrameDetailsPage frameDetails= pageLoader.frameDetails;
        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(5000);
        softAssert.assertEquals(frameDetails.getMainBorrower(), tes3Data.get("mainBorrower"));
        softAssert.assertEquals(frameDetails.getBorrowerID(), tes3Data.get("BorrowerID"));
        softAssert.assertEquals(frameDetails.getBorrowerPhone(), tes3Data.get("BorrowerPhone"));
        softAssert.assertEquals(frameDetails.getBorrowerEmail(), tes3Data.get("BorrowerEmail"));
        softAssert.assertAll();
    }

    @Test(description = "בדיקת הורשה- נתוני הצעה")
    @Description("בדיקת נתוני הצעה: ריבית= 5, ריבית משתנה= ליבור|215, מח מ= 5, הצמדה= נייר100|100, מרווח= 5, LTV= 5 ")
    public void test04VerifyOfferData() throws InterruptedException, IOException {
        JSONObject tes4Data = JsonUtils.returnJsonObject(testData, "testFrame4");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        FrameDetailsPage frameDetails= pageLoader.frameDetails;
        Thread.sleep(5000);
        softAssert.assertEquals(frameDetails.getInterestField(), tes4Data.get("interestField"));
        softAssert.assertEquals(frameDetails.getVariableInterest(), tes4Data.get("variableInterest"));
        softAssert.assertEquals(frameDetails.getMHMField(), tes4Data.get("MHMField"));
        softAssert.assertEquals(frameDetails.getLinkage(), tes4Data.get("linkage"));
        softAssert.assertEquals(frameDetails.getSpaciousField(), tes4Data.get("spaciousField"));
        softAssert.assertEquals(frameDetails.getTLVField(), tes4Data.get("TLVField"));
        softAssert.assertAll();
    }

    @Test(description = "בדיקת הורשה-קוד BI")
    @Description("בדיקת קוד BI- עסקת סינדיקציה/קונסורציום מסומן, קוד BI מתוך רשימה= 18 - הלוואה ממונפת ריקורס לא קונסורציום ")
    public void test05VerifyBICode() throws InterruptedException, IOException {
        JSONObject tes5Data = JsonUtils.returnJsonObject(testData, "testFrame5");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        FrameDetailsPage frameDetails= pageLoader.frameDetails;
        softAssert.assertTrue(frameDetails.checkboxBI.isSelected());
        softAssert.assertEquals(frameDetails.getBICodeFromList(), tes5Data.get("BICodeFromList"));
        softAssert.assertAll();
    }
    @Test(description = "בלשונית פרטים נוספים- בחירת נכס")
    @Description(" בחירת נכס למסגרת שלא מקושר ליישות אחרת ")
    public void test06ChooseAsset () throws IOException, CsvException, InterruptedException {
       pageLoader = new PageLoader(driver);
        FrameExtraDetailsPage ExtraDetailsPage= pageLoader.ExtraDetailsPage;
        ExtraDetailsPage.ChooseTheFirstAsset();
        }


        @Test(description = "בלשונית פרטים נוספים- בחירת התחייבות")
        @Description(" בחירת התחייבות למסגרת שלא מקושר ליישות אחרת ")
        public void test07ChooseObligation () throws IOException, CsvException, InterruptedException {
            pageLoader = new PageLoader(driver);
            FrameExtraDetailsPage ExtraDetailsPage= pageLoader.ExtraDetailsPage;
            ExtraDetailsPage.ChooseTheFirstObligation();
            }


        @Test(description = "לשונית פרטים נוספים- בחירת נכס והתחייבות ובדיקת שדות הורשה מעסקה")
        @Description("בדיקת שדות תת אפיק = אג\"ח להמרה לא סחיר | 2800 , אפיק=אג\"ח להמרה לא סחיר, מנפיק=איסתא ליינס חברת נסיעות בישראל בע\"מ | 1036, ענף= 1 בנקים למשכנתאות | 2 , מדינה מנפיקה= ACADIAN , מדינה נסחרת=אפריקה ישראל, מדינת חשיפה= אירופה, אזור גאוגרפי= ישראל, בורסה= בדיקה | 1 , קונצרן= בזק | 10, נכס בסיס= נייר1000321 | 1000321, מכפיל נכס בסיס= 5 , מדד מטבע חשיפה= דולר | 20001, סוג לניהול סיכונים =אג ח להמרה, סוג הצמדה= אג ח לא סחיר להמרה- אחר")
        public void test08VerifyExtraDetailsPage () throws InterruptedException, IOException, IllegalAccessException {
            JSONObject tes6Data = JsonUtils.returnJsonObject(testData, "testFrame6");
            pageLoader = new PageLoader(driver);
            SoftAssert softAssert = new SoftAssert();
            FrameExtraDetailsPage ExtraDetailsPage= pageLoader.ExtraDetailsPage;
            ExtraDetailsPage.goToExtraDetailsTab();
            ExtraDetailsPage.assertFrameExtraDetails(tes6Data);
        }

        @Test(description = "לשונית תנאים נוספים- בדיקת שדות הורשה")
        @Description("בדיקת צ'אקבוקסים מסומנים ושדות מלאים בהגדרות כללי, הגדרות מסגרת הגדרות ריבית")
        public void test09VerifyAdditionalConditionPage () throws InterruptedException {
            pageLoader = new PageLoader(driver);
            FrameAdditionalConditionPage FAdditionalCondition = pageLoader.FAdditionalCondition;
            SoftAssert softAssert = new SoftAssert();
            Thread.sleep(1000);
            FAdditionalCondition.goToAdditionalConditionTab();
            FAdditionalCondition.YesNoRadioButtonFrame();
            List<WebElement> formRadioButton = driver.findElements(By.tagName("form-yes-no"));
            for (WebElement element : formRadioButton.toArray(new WebElement[0])) {
                softAssert.assertTrue(element.isDisplayed());
                softAssert.assertAll();
            }
        }

        @Test(description = "בדיקת הורשה- לשונית לווים")
        @Description("מספר סידורי =5, בדיקת שם לווה= מיאמי בעמ, טלפון לווה= ייי - 052336666 (סלולר), אימייל לווה= miamigmail.com ")
        public void test10VerifyBorrower () throws InterruptedException, IOException {
            JSONObject tes7Data = JsonUtils.returnJsonObject(testData, "testFrame7");
            pageLoader = new PageLoader(driver);
            SoftAssert softAssert = new SoftAssert();
            FrameBorrowerPage borrowerPage= pageLoader.borrowerPage;
            Thread.sleep(1000);
            borrowerPage.goToBorrowerTab();
            Thread.sleep(1000);
            softAssert.assertEquals(borrowerPage.getBorrowerName(), tes7Data.get("borrowerName"));
            softAssert.assertEquals(borrowerPage.getSerialNumber(), tes7Data.get("serialNumber"));
            softAssert.assertEquals(borrowerPage.getContact(), tes7Data.get("contact"));
            softAssert.assertEquals(borrowerPage.getBorrowerPhone(), tes7Data.get("borrowerPhone"));
            softAssert.assertEquals(borrowerPage.getBorrowerEmail(), tes7Data.get("borrowerEmail"));
            softAssert.assertAll();
        }

        @Test(description = "בדיקת הורשה- בטחונות וערבים")
        @Description("פירוט בטוחה = בדיקה , סוג בטוחה = אנרגיה ")
        public void test11VerifyCollateralAndGuarantorsPage () throws InterruptedException, IOException {
            JSONObject tes8Data = JsonUtils.returnJsonObject(testData, "testFrame8");
            pageLoader = new PageLoader(driver);
            SoftAssert softAssert = new SoftAssert();
            FrameCollateralAndGuarantorsPage collateralAndGuarantors= pageLoader.collateralAndGuarantors;
            collateralAndGuarantors.goToCollateralAndGuarantorsTab();
            Thread.sleep(1000);
            softAssert.assertEquals(collateralAndGuarantors.getSafeDetail(), tes8Data.get("SafeDetail"));
            softAssert.assertEquals(collateralAndGuarantors.getSafeType(), tes8Data.get("safeType"));
        }

        @Test(description = "בדיקת הורשה- לשונית אנשי קשר")
        @Description("מספר סידורי =4, בדיקת שם לווה= ניקולה יוקיץ, טלפון= fff - 05222222 (סלולר), אימייל= fff@gmail.com, תפקיד= מנהל כספים")
        public void test12VerifyBorrower () throws InterruptedException, IOException {
            JSONObject tes9Data = JsonUtils.returnJsonObject(testData, "testFrame9");
            pageLoader = new PageLoader(driver);
            SoftAssert softAssert = new SoftAssert();
            FrameContactsPage contactsPage = pageLoader.contactsPage;
            contactsPage.goToContactsTab();
            softAssert.assertEquals(contactsPage.getContactName(), tes9Data.get("contactName"));
            softAssert.assertEquals(contactsPage.getSerialNumber(), tes9Data.get("serialNumber"));
            softAssert.assertEquals(contactsPage.getContactPhone(), tes9Data.get("contactPhone"));
            softAssert.assertEquals(contactsPage.getContactEmail(), tes9Data.get("contactEmail"));
            softAssert.assertEquals(contactsPage.getContactJob(), tes9Data.get("contactJob"));
            softAssert.assertAll();
        }

        @Test(description = "בדיקת לשונית מסמכים")
        @Description("בדיקת לשונית מסמכים והוספת מסמך")
        public void test13VerifyDocumentsPage () throws InterruptedException, IOException {
            JSONObject tes10Data = JsonUtils.returnJsonObject(testData, "testFrame10");
            pageLoader = new PageLoader(driver);
            SoftAssert softAssert = new SoftAssert();
            FrameDocumentsPage documentsPage= pageLoader.documentsPage;
            documentsPage.uploadDocument();
            softAssert.assertEquals(documentsPage.getDocumentsTab(), tes10Data.get("documentsTab"));
            softAssert.assertAll();
        }

        @Test(description = "בדיקת לשונית אירועים")
        @Description("בדיקת הוספת אירוע")
        public void test14VerifyEventsPage () throws InterruptedException, IOException {
            JSONObject tes11Data = JsonUtils.returnJsonObject(testData, "testFrame11");
            pageLoader = new PageLoader(driver);
            SoftAssert softAssert = new SoftAssert();
            FrameEventsPage eventsPage = pageLoader.eventsPage;
            eventsPage.openNewEvent();
            softAssert.assertEquals(eventsPage.getDealEventTab(), tes11Data.get("dealEventTab"));
            softAssert.assertAll();
        }

        @Test(description = "בדיקת לשונית נתוני הצעה")
        @Description("בדיקת כותרת נתוני הצעה")
        public void test15VerifyOfferDataPage () throws InterruptedException, IOException {
            pageLoader = new PageLoader(driver);
            SoftAssert softAssert = new SoftAssert();
            JSONObject tes12Data = JsonUtils.returnJsonObject(testData, "testFrame12");
            FrameOfferDataPage offerDataPage = pageLoader.offerDataPage;
            offerDataPage.goToOfferDataTab();
            softAssert.assertEquals(offerDataPage.getOfferDataTab(), tes12Data.get("offerDataTab"));
            offerDataPage.saveFrame();
            softAssert.assertAll();
        }

        @Test(description = "שמירה מסגרת ועסקה")
        @Description("בדיקת שמירה עד הסוף (מסגרת ועסקה)")
        public void test16VerifyOfferDataPage () throws InterruptedException {
            pageLoader = new PageLoader(driver);
            SoftAssert softAssert = new SoftAssert();
            DealTablePage table = pageLoader.table;
            DealDetailsPage deal = pageLoader.deal;
            deal.saveFrameAndDeal();
            String expectedTitle = "נשמר בהצלחה!\n" +
                    "×";
            softAssert.assertEquals(table.getAlert(), expectedTitle);
            softAssert.assertAll();
        }
    }

























































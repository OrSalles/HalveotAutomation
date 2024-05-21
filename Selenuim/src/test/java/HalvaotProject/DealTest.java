package HalvaotProject;


import HalvotPages.Deal.*;
import Utils.JsonUtils;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import HalvotPages.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static Utils.RandomID.generateRandomID;

public class DealTest extends BaseDealTest {

    String NameOfDeal = "עסקה אוטומציה";
    String amount = "10,000";
    String path ="X:\\פריוריטי\\Or Baron\\1.docx";
    String baseName = "עסקה אוטומציה";
   String randomID = generateRandomID();
   String nameWithRandomID = baseName + randomID;
    private static String testData= "TestData.json";
    private static  String urlData = "urlData.json";
    String websiteUrl = "";
    String APIUrl = "";



    @Test(description = "בדיקת לשונית פרטי עסקה")
    @Description("בדיקת לשונית פרטי עסקה- סכום עסקה = 10000")
    public void test01dealDetails() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        pageLoader = new PageLoader(driver);
        DealDetailsPage deal = pageLoader.deal;
        Assert.assertTrue(deal.isPageLoaded(),"Deal Page Not Loaded");
        deal.fillingOutDealDetailsFields();
        softAssert.assertEquals(deal.getTotalAmountDeal(), amount);
        softAssert.assertAll();
    }

    @Test(description = "בדיקת לשונית לווים")
    @Description("בדיקת לשונית לווה- לווה = מיאמי בע מ")
    public void test02borrowerPage() throws IOException {
        JSONObject test1Data= JsonUtils.returnJsonObject(testData, "testDeal1");
        SoftAssert softAssert = new SoftAssert();
        pageLoader = new PageLoader(driver);
        DealDetailsPage deal = pageLoader.deal;
        deal.GoToBorrowerTabAndFillingOutTheFields();
        softAssert.assertEquals(deal.getMainBorrowerField(), test1Data.get("MainBorrowerField"));
        softAssert.assertAll();

    }

    @Test(description = "בדיקת לשונית נתוני הצעה")
    @Description("מעבר ללשונית נתוני הצעה והזנת הנתונים")
    public void test03offerDataPage() throws InterruptedException, IOException {
        pageLoader = new PageLoader(driver);
        JSONObject test2Data= JsonUtils.returnJsonObject(testData, "testDeal2");
        SoftAssert softAssert = new SoftAssert();
        DealOfferDataPage offerData = pageLoader.OfferData;
        offerData.goToOfferDataTabAndFillingOutTheFields();
        softAssert.assertEquals(offerData.getOfferDataPageTitle(), test2Data.get("offerDataPageTitle"));
        softAssert.assertAll();

    }

    @Test(description = "בדיקת לשונית תנאים נוספים")
    @Description("הזנת נתונים בלשונית פרטים נוספים")
    public void test04extraDetailsPage() throws InterruptedException, IOException {
        JSONObject test3Data= JsonUtils.returnJsonObject(testData, "testDeal3");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        DealExtraDetailsPage extraDetails = pageLoader.extraDetails;
        extraDetails.goToExtraDetailsTabAndFillingOutTheFields();
        softAssert.assertEquals(extraDetails.getAfik(), test3Data.get("afik"));
        softAssert.assertAll();
    }
    @Test(description = "בדיקת לשונית תנאים נוספים")
    @Description("בדיקת כותרות וסימון השדות בלשונית םרטים נוספים")
    public void test05additionalConditionsPage() throws IOException {
        JSONObject test4Data= JsonUtils.returnJsonObject(testData, "testDeal4");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        DealAdditionalConditionsPage additionalConditions = pageLoader.additionalConditions;
        additionalConditions.goToAdditionalConditionsAndFillingOutAllTheFields();
        softAssert.assertEquals(additionalConditions.getAdditionalConditionsTab(), test4Data.get("AdditionalConditionsTab"));
        softAssert.assertAll();
    }
    @Test(description = "בדיקת לשונית בטחונות וערבים")
    @Description("בדיקת מעבר ללשונית בטחונות וערבים והזנת השדות")
    public void test06CollateralAndGuarantorsPage() throws IOException {
        JSONObject test5Data= JsonUtils.returnJsonObject(testData, "testDeal5");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        DealCollateralAndGuarantorsPage CollateralAndGuarantors = pageLoader.CollateralAndGuarantors;
        CollateralAndGuarantors.goToCollateralAndGuarantorsAndFillingOutTheFields();
        softAssert.assertEquals(CollateralAndGuarantors.getCollateralAndGuarantorsTab(), test5Data.get("CollateralAndGuarantorsTab"));
        softAssert.assertAll();
    }
    @Test(description = "בדיקת לשונית אנשי קשר")
    @Description("בדיקת לשונית אנשי קשר ובחירת איש קשר מהרשימה")
    public void test07contactsPage() throws IOException {
        JSONObject test6Data= JsonUtils.returnJsonObject(testData, "testDeal6");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        DealContactsPage contacts = pageLoader.contacts;
        contacts.goToContactTabAndFillingOutTheFields();
        softAssert.assertEquals(contacts.getContactTab(), test6Data.get("contactTab"));
        softAssert.assertAll();


    }
    @Test(description = "בדיקת לשונית מסמכים")
    @Description("בדיקת העלאת מסמך בלשונית מסמכים")
    public void test08documentsPage() throws InterruptedException, IOException {
        JSONObject test7Data= JsonUtils.returnJsonObject(testData, "testDeal7");
        pageLoader = new PageLoader(driver);
        DealDocumentsPage documents = pageLoader.documents;
        SoftAssert softAssert = new SoftAssert();
        documents.upLoadFileInDocumentsTab();
        softAssert.assertEquals(documents.getDocumentsTab(), test7Data.get("documentsTab"));
        softAssert.assertAll();
    }
    @Test(description = "בדיקת לשונית אירועים")
    @Description("בדיקת לשונית אירועים והקמת אירוע חדש")
    public void test09eventsPage() throws IOException {
        JSONObject test8Data= JsonUtils.returnJsonObject(testData, "testDeal8");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        DealEventPage dealEvent = pageLoader.dealEvent;
        dealEvent.goToEventsAndOpenNewEvent();
        softAssert.assertEquals(dealEvent.getDealEventTab(), test8Data.get("dealEventTab"));
        softAssert.assertAll();
    }
    @Test(description = "בדיקת שמירה עסקה")
    @Description("בדיקת שמירה עסקה עם הודעה = נשמר בהצלחה")
    public void test10closeDeal() throws InterruptedException {
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        DealDetailsPage deal = pageLoader.deal;
        DealTablePage table = pageLoader.table;
        deal.saveDeal();
        String expectedTitle = "נשמר בהצלחה!\n" +
                "×";
        softAssert.assertEquals(table.getAlert(), expectedTitle);
        softAssert.assertAll();
    }
    @Test(description = "פתיחה של העסקה החדשה")
    @Description("פתיחת העסקה האחרונה שנוספה לרשימת העסקאות")
    public void test11openTheDeal() throws InterruptedException, IOException {
        JSONObject test9Data= JsonUtils.returnJsonObject(testData, "testDeal9");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        DealTablePage table = pageLoader.table;
        DealDetailsPage deal = pageLoader.deal;
        table.openTheLestDeal();
        softAssert.assertEquals(deal.getDealTitle(), test9Data.get("dealTitle"));
        softAssert.assertAll();


    }


}













































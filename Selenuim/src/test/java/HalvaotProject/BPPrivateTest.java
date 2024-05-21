package HalvaotProject;

import HalvotPages.BP.BPPrivateContactInformationPage;
import HalvotPages.BP.BPPrivateDetailsPage;
import HalvotPages.PageLoader;
import Utils.JsonUtils;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.json.JSONObject;

import java.io.IOException;

public class BPPrivateTest extends BaseBPPrivateTest {

    private static String testData = "TestData.json";
    private static String urlData = "urlData.json";
    String websiteUrl = "";
    String APIUrl = "";

    @Attachment(value = "page screenshot", type = "image/png")
    public byte[] saveScreenShot(WebDriver driver) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }

    @Test(description = "פתיחת לשונית פרטים כלליים נפתח תקין")
    @Description("בדיקה כי הנתונים שהוזנו בלשונית פרטים כלליים נשמרו תקין")
    public void test01VerifyBPPrivatePageOpen() throws IllegalAccessException, InterruptedException, IOException {
        JSONObject BPPrivateNames = JsonUtils.returnJsonObject(testData, "BPPrivateDetails1");
        JSONObject BPPrivateMainPage = JsonUtils.returnJsonObject(testData, "BPPrivateDetails2");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        BPPrivateDetailsPage BPPrivateDetails = pageLoader.BPPrivateDetails;
        saveScreenShot(driver);
        BPPrivateDetails.insertBPPrivateDetails(BPPrivateNames);
        BPPrivateDetails.selectGender();
        BPPrivateDetails.insertIDStatesAndDates();
        BPPrivateDetails.insertCommentAndSave();
        BPPrivateDetails.assertBPPrivateDetails(BPPrivateNames);
        softAssert.assertEquals(BPPrivateDetails.getGenderMale(),BPPrivateMainPage.get("genderMale"));
        softAssert.assertEquals(BPPrivateDetails.getID(),BPPrivateMainPage.get("ID"));
        softAssert.assertEquals(BPPrivateDetails.getStateOfIssue(),BPPrivateMainPage.get("stateOfIssue"));
        softAssert.assertEquals(BPPrivateDetails.getCountryOfBirth(),BPPrivateMainPage.get("countryOfBirth"));
        softAssert.assertEquals(BPPrivateDetails.getGeneralComments(),BPPrivateMainPage.get("generalComments"));
        softAssert.assertAll();
    }
    @Test(description = "פתיחת לשונית פרטי התקשרות נפתח תקין")
    @Description("בדיקה כי הנתונים שהוזנו בלשונית פרטי התקשרות נשמרו תקין")
    public void test02VerifyBPPrivateContactInformation() throws IllegalAccessException, InterruptedException, IOException {
        JSONObject BPContactInformation = JsonUtils.returnJsonObject(testData, "BPPContactInfo");
        JSONObject BPContactInformation1 = JsonUtils.returnJsonObject(testData, "BPPContactInfo1");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        BPPrivateContactInformationPage BPPrivateContactInformation = pageLoader.BPPrivateContactInformation;
        BPPrivateContactInformation.goToContactInformationTab();
        BPPrivateContactInformation.chooseStateAndGeographicArea();
        BPPrivateContactInformation.insertBPPrivateContactInfo(BPContactInformation);
        BPPrivateContactInformation.insetPhoneWebAndEmail();
        BPPrivateContactInformation.saveBPPrivate();
        BPPrivateContactInformation.goToContactInformationTab();
        saveScreenShot(driver);
        BPPrivateContactInformation.assertBPPrivateContactInfo(BPContactInformation);
        softAssert.assertEquals(BPPrivateContactInformation.getStateIsrael(),BPContactInformation1.get("stateIsrael"));
        softAssert.assertEquals(BPPrivateContactInformation.getGeographicArea(),BPContactInformation1.get("geographicArea"));
        softAssert.assertEquals(BPPrivateContactInformation.getTypePhone(),BPContactInformation1.get("typePhone"));
        softAssert.assertAll();
    }

}


package HalvaotProject;

import HalvotPages.CRM.CRMTablePage;
import HalvotPages.PageLoader;
import Utils.JsonUtils;
import io.qameta.allure.Description;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class CRMTest extends BaseCRMTest{
    private static String testData= "TestData.json";
    private static  String urlData = "urlData.json";
    String websiteUrl = "";
    String APIUrl = "";

    @Test(description = "פתיחת רשימת אירועים")
    @Description("מעבר לרשימת אירועים, כותרת הרשימה = inbox")
    public void test01CRMTable() throws IOException {
        JSONObject CRMList= JsonUtils.returnJsonObject(testData, "CRMTable");
        SoftAssert softAssert = new SoftAssert();
        pageLoader = new PageLoader(driver);
        CRMTablePage CRMTable = pageLoader.CRMTable;
        softAssert.assertEquals(CRMTable.getCRMTableTitle(),CRMList.get("CRMTableTitle"));

    }

}

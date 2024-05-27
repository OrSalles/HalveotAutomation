package HalvaotProject;

import HalvotPages.LoanConsolidation.EventsInTheLifeOfALoanTabPage;
import HalvotPages.LoanConsolidation.Step1_SelectionOfTheBorrowerAndTheDateOfOperationPage;
import HalvotPages.LoanConsolidation.Step2_SelectLoansForConsolidationPage;
import HalvotPages.PageLoader;
import Utils.JsonUtils;
import io.qameta.allure.Description;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoanConsolidationTest extends BaseFrameTest {
    private static String testData = "TestData.json";

    @Test(description = "פתיחת אירוע חדש")
    @Description("בפתיחת אירוע חדש נראה בעמוד הראשון הורשה של הלווה הראשי מהמסגרת")
    public void test01openNewEvent() throws IOException {
        JSONObject stepOne = JsonUtils.returnJsonObject(testData, "Step1_SelectionOfTheBorrowerAndTheDateOfOperation");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        EventsInTheLifeOfALoanTabPage EventsInTheLifeOfALoan = pageLoader.EventsInTheLifeOfALoan;
        Step1_SelectionOfTheBorrowerAndTheDateOfOperationPage Step1_SelectionOfTheBorrowerAndTheDateOfOperation = pageLoader.Step1_SelectionOfTheBorrowerAndTheDateOfOperation;
        EventsInTheLifeOfALoan.addNewEvent();
        Step1_SelectionOfTheBorrowerAndTheDateOfOperation.chooseDetailsCode_NISWithdrawal();
        Step1_SelectionOfTheBorrowerAndTheDateOfOperation.chooseDetailsCode_realEstateDeposit();
        Step1_SelectionOfTheBorrowerAndTheDateOfOperation.insertComment();
        softAssert.assertEquals(Step1_SelectionOfTheBorrowerAndTheDateOfOperation.getMainBorrower(),stepOne.get("mainBorrower"));
    }
    @Test(description = "מעבר לעמוד השני לבחירת הלוואות לאיחוד")
    @Description("בעמוד השני- ההלוואת שהוקמו מסומנות לאיחוד")
    public void test02goToStep2AndChooseLoans() throws IOException, InterruptedException {
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(2000);
        Step1_SelectionOfTheBorrowerAndTheDateOfOperationPage Step1_SelectionOfTheBorrowerAndTheDateOfOperation = pageLoader.Step1_SelectionOfTheBorrowerAndTheDateOfOperation;
        Step2_SelectLoansForConsolidationPage Step2_SelectLoansForConsolidation = pageLoader.Step2_SelectLoansForConsolidation;
        Step1_SelectionOfTheBorrowerAndTheDateOfOperation.clickNextStep();
        softAssert.assertTrue(Step2_SelectLoansForConsolidation.firstLoanCheckbox.isSelected(), "Checkbox is selected");
        softAssert.assertTrue(Step2_SelectLoansForConsolidation.secondLoanCheckbox.isSelected(), "Checkbox is selected");


    }

}

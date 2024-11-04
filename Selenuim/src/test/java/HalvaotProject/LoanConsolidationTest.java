package HalvaotProject;

import HalvotPages.LoanConsolidation.*;
import HalvotPages.PageLoader;
import Utils.JsonUtils;
import io.qameta.allure.Description;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoanConsolidationTest extends BaseLoanConsolidationTest {
    private static String testData = "TestData.json";

    @Test(description = "פתיחת אירוע חדש")
    @Description("בפתיחת אירוע חדש נראה בעמוד הראשון הורשה של הלווה הראשי מהמסגרת")
    public void test01openNewEvent() throws IOException, InterruptedException {
        JSONObject stepOne = JsonUtils.returnJsonObject(testData, "Step1_SelectionOfTheBorrowerAndTheDateOfOperation");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        LoansTabPage LoansTab = pageLoader.LoansTab;
        EventsInTheLifeOfALoanTabPage EventsInTheLifeOfALoan = pageLoader.EventsInTheLifeOfALoan;
        Step1_SelectionOfTheBorrowerAndTheDateOfOperationPage Step1_SelectionOfTheBorrowerAndTheDateOfOperation = pageLoader.Step1_SelectionOfTheBorrowerAndTheDateOfOperation;
        LoansTab.loanTab.click();
        System.out.println(LoansTab.loan1.getText());
        EventsInTheLifeOfALoan.addNewEvent();
        Step1_SelectionOfTheBorrowerAndTheDateOfOperation.chooseDetailsCode_NISWithdrawal();
        Step1_SelectionOfTheBorrowerAndTheDateOfOperation.chooseDetailsCode_realEstateDeposit();
        Step1_SelectionOfTheBorrowerAndTheDateOfOperation.insertComment();
        softAssert.assertEquals(Step1_SelectionOfTheBorrowerAndTheDateOfOperation.getMainBorrower(),stepOne.get("mainBorrower"));
        softAssert.assertAll();

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
        softAssert.assertAll();

    }
    @Test(description = "מעבר לעמוד השלישי- ליצירת  הלוואה חדשה")
    @Description("בעמוד השלישי- בחירת ההלוואה שממנה יועתקו הנתונים ויצירת מספר ושם להלוואה החדשה")
    public void test03goToStep3AndCreateNewLoan() throws IOException, InterruptedException {
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        Step2_SelectLoansForConsolidationPage Step2_SelectLoansForConsolidation = pageLoader.Step2_SelectLoansForConsolidation;
        Step3_CreateNewLoanPage Step3_CreateNewLoan = pageLoader.Step3_CreateNewLoan;
        Step2_SelectLoansForConsolidation.pressNextButton();
        Step3_CreateNewLoan.selectLoan();
        softAssert.assertTrue(Step3_CreateNewLoan.numberOfNewLoan.isDisplayed());
        softAssert.assertTrue(Step3_CreateNewLoan.nameOfNewLoan.isDisplayed());
         softAssert.assertAll();

    }
    @Test(description = "מעבר לעמוד הרביעי- ליצירת תנועות וביצוע האיחוד")
    @Description("בעמוד הרביעי-ההלוואות שבוצעו איתן את האיחוד מופיעות בשלב 4 , לווה ראשי מופיע בעמוד , הלוואה מאוחדת ופעולות שהולכות להיווצר ")
    public void test04goToStep3AndCreateNewLoan() throws IOException, InterruptedException {
        JSONObject stepOne = JsonUtils.returnJsonObject(testData, "Step1_SelectionOfTheBorrowerAndTheDateOfOperation");
        JSONObject stepFour = JsonUtils.returnJsonObject(testData,"Step4_CreatingMovementsAndPerformingTheUnion");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        Step3_CreateNewLoanPage Step3_CreateNewLoan = pageLoader.Step3_CreateNewLoan;
        Step4_CreatingMovementsAndPerformingTheUnionPage step4_creatingMovementsAndPerformingTheUnion = pageLoader.Step4_CreatingMovementsAndPerformingTheUnion;
        LoansTabPage LoansTab = pageLoader.LoansTab;
        Step3_CreateNewLoan.pressNextButton();
        step4_creatingMovementsAndPerformingTheUnion.navigateToLoanTabAndSaveLoansNames();
        softAssert.assertEquals(step4_creatingMovementsAndPerformingTheUnion.getMainBorrower(),stepOne.get("mainBorrower"));
        softAssert.assertEquals(LoansTab.getLoan1Value(),step4_creatingMovementsAndPerformingTheUnion.getLoan1OnStep4Value());
        softAssert.assertEquals(LoansTab.getLoan2Value(),step4_creatingMovementsAndPerformingTheUnion.getLoan2OnStep4Value());
        softAssert.assertEquals(step4_creatingMovementsAndPerformingTheUnion.getNewLoanTitle(),stepFour.get("newLoanTitle"));
        softAssert.assertEquals(step4_creatingMovementsAndPerformingTheUnion.getActionsToBeOccur(),stepFour.get("actionsToBeOccur"));
        softAssert.assertAll();
    }
    @Test(description = "לחיצה על אישור ביצוע איחוד הלוואות")
    @Description("בלשונית אירועים בחיי הלוואה מופיע אירוע איחוד הלוואות ")
    public void test05saveConsolidationLoan() throws IOException, InterruptedException {
        JSONObject eventsLifeOfALoan = JsonUtils.returnJsonObject(testData, "EventInTheLifeOfALoanTab");
        JSONObject loan = JsonUtils.returnJsonObject(testData,"LoanTab");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        EventsInTheLifeOfALoanTabPage EventsInTheLifeOfALoan = pageLoader.EventsInTheLifeOfALoan;
        Step4_CreatingMovementsAndPerformingTheUnionPage step4_creatingMovementsAndPerformingTheUnion = pageLoader.Step4_CreatingMovementsAndPerformingTheUnion;
        LoansTabPage LoansTab = pageLoader.LoansTab;
        step4_creatingMovementsAndPerformingTheUnion.clickTheSaveConsolidationButton();
        softAssert.assertEquals(EventsInTheLifeOfALoan.getEventType(),eventsLifeOfALoan.get("eventType"));
        softAssert.assertAll();
}
    @Test(description = "לחיצה על אישור ביצוע איחוד הלוואות- יוצר הלוואה מאוחדת")
    @Description("בלשונית הלוואות מופיעה הלוואה עם סטטוס פעיל- מאוחד")
    public void test06verifyTypeEvent() throws IOException, InterruptedException {
        JSONObject loan = JsonUtils.returnJsonObject(testData,"LoanTab");
        pageLoader = new PageLoader(driver);
        SoftAssert softAssert = new SoftAssert();
        LoansTabPage LoansTab = pageLoader.LoansTab;
        LoansTab.goToLoanTab();
        softAssert.assertEquals(LoansTab.getActivityStatus(),loan.get("activityStatus"));
        softAssert.assertAll();
    }

}

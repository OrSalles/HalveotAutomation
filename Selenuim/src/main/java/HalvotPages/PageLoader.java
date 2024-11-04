package HalvotPages;

import HalvotPages.BP.*;
import HalvotPages.CRM.CRMTablePage;
import HalvotPages.Deal.*;
import HalvotPages.Frame.*;
import HalvotPages.Loan.*;
import HalvotPages.LoanConsolidation.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageLoader {
    public DealDetailsPage deal;
    public DealExtraDetailsPage extraDetails;
    public DealAdditionalConditionsPage additionalConditions;
    public DealCollateralAndGuarantorsPage CollateralAndGuarantors;
    public DealContactsPage contacts;
    public DealDocumentsPage documents;
    public DealEventPage dealEvent;
    public DealOfferDataPage OfferData;
    public DealTablePage table;
    public FrameTabPage Frame;
    public FrameDetailsPage frameDetails;
    public FrameExtraDetailsPage ExtraDetailsPage;
    public FrameAdditionalConditionPage FAdditionalCondition;
    public FrameBorrowerPage borrowerPage;
    public FrameCollateralAndGuarantorsPage collateralAndGuarantors;
    public FrameContactsPage contactsPage;
    public FrameDocumentsPage documentsPage;
    public FrameEventsPage eventsPage;
    public FrameOfferDataPage offerDataPage;
    public FrameTablePage listOfFrames;
    public LoanTabPage loanTab;
    public LoanDetailsPage loanDetails;
    public LoanExtraDetailsPage loanExtraDetails;
    public LoanAdditionalConditionPage loanAdditionalCondition;
    public LoanBorrowerPage loanBorrower;
    public LoanCollateralAndGuarantorsPage loanCollateralAndGuarantors;
    public LoanContactsPage LoanContacts;
    public LoanDocumentsPage loanDocuments;
    public LoanEventPage loanEvent;
    public LoanOfferDataPage loanOfferData;
    public BPTablePage BPTable;
    public BPPrivateDetailsPage BPPrivateDetails;
    public BPPrivateContactInformationPage BPPrivateContactInformation;
    public BPCompanyDetailsPage BPCompanyDetails;
    public BPCompanyContactInformationPage BPContactInfo;
    public  BPCompanyContactsPage BPCompanyContacts;
    public EventsInTheLifeOfALoanTabPage EventsInTheLifeOfALoan;
    public LoansTabPage LoansTab;
    public Step1_SelectionOfTheBorrowerAndTheDateOfOperationPage Step1_SelectionOfTheBorrowerAndTheDateOfOperation;
    public Step2_SelectLoansForConsolidationPage Step2_SelectLoansForConsolidation;
    public Step3_CreateNewLoanPage Step3_CreateNewLoan;
    public Step4_CreatingMovementsAndPerformingTheUnionPage Step4_CreatingMovementsAndPerformingTheUnion;
    public CRMTablePage CRMTable;




    public PageLoader(WebDriver driver){
        deal = PageFactory.initElements(driver, DealDetailsPage.class);
        extraDetails = PageFactory.initElements(driver, DealExtraDetailsPage.class);
        additionalConditions = PageFactory.initElements(driver, DealAdditionalConditionsPage.class);
        CollateralAndGuarantors = PageFactory.initElements(driver, DealCollateralAndGuarantorsPage.class);
        contacts = PageFactory.initElements(driver, DealContactsPage.class);
        documents = PageFactory.initElements(driver, DealDocumentsPage.class);
        dealEvent = PageFactory.initElements(driver, DealEventPage.class);
        OfferData = PageFactory.initElements(driver, DealOfferDataPage.class);
        table = PageFactory.initElements(driver, DealTablePage.class);
        Frame = PageFactory.initElements(driver, FrameTabPage.class);
        frameDetails = PageFactory.initElements(driver, FrameDetailsPage.class);
        ExtraDetailsPage = PageFactory.initElements(driver, FrameExtraDetailsPage.class);
        FAdditionalCondition = PageFactory.initElements(driver, FrameAdditionalConditionPage.class);
        borrowerPage = PageFactory.initElements(driver, FrameBorrowerPage.class);
        collateralAndGuarantors = PageFactory.initElements(driver, FrameCollateralAndGuarantorsPage.class);
        contactsPage = PageFactory.initElements(driver, FrameContactsPage.class);
        documentsPage = PageFactory.initElements(driver, FrameDocumentsPage.class);
        eventsPage = PageFactory.initElements(driver, FrameEventsPage.class);
        offerDataPage = PageFactory.initElements(driver, FrameOfferDataPage.class);
        listOfFrames = PageFactory.initElements(driver, FrameTablePage.class);
        loanTab = PageFactory.initElements(driver, LoanTabPage.class);
        loanDetails = PageFactory.initElements(driver,LoanDetailsPage.class);
        loanExtraDetails = PageFactory.initElements(driver, LoanExtraDetailsPage.class);
        loanAdditionalCondition = PageFactory.initElements(driver,LoanAdditionalConditionPage.class);
        loanBorrower = PageFactory.initElements(driver, LoanBorrowerPage.class);
        loanCollateralAndGuarantors = PageFactory.initElements(driver,LoanCollateralAndGuarantorsPage.class);
        LoanContacts = PageFactory.initElements(driver,LoanContactsPage.class);
        loanDocuments = PageFactory.initElements(driver,LoanDocumentsPage.class);
        loanEvent = PageFactory.initElements(driver,LoanEventPage.class);
        loanOfferData = PageFactory.initElements(driver,LoanOfferDataPage.class);
        BPTable = PageFactory.initElements(driver,BPTablePage.class);
        BPPrivateDetails = PageFactory.initElements(driver,BPPrivateDetailsPage.class);
        BPPrivateContactInformation = PageFactory.initElements(driver, BPPrivateContactInformationPage.class);
        BPCompanyDetails = PageFactory.initElements(driver, BPCompanyDetailsPage.class);
        BPContactInfo = PageFactory.initElements(driver,BPCompanyContactInformationPage.class);
        BPCompanyContacts = PageFactory.initElements(driver,BPCompanyContactsPage.class);
        EventsInTheLifeOfALoan = PageFactory.initElements(driver, EventsInTheLifeOfALoanTabPage.class);
        Step1_SelectionOfTheBorrowerAndTheDateOfOperation = PageFactory.initElements(driver, Step1_SelectionOfTheBorrowerAndTheDateOfOperationPage.class);
        Step2_SelectLoansForConsolidation = PageFactory.initElements(driver, Step2_SelectLoansForConsolidationPage.class);
        Step3_CreateNewLoan = PageFactory.initElements(driver,Step3_CreateNewLoanPage.class);
        Step4_CreatingMovementsAndPerformingTheUnion = PageFactory.initElements(driver, Step4_CreatingMovementsAndPerformingTheUnionPage.class);
        LoansTab = PageFactory.initElements(driver,LoansTabPage.class);
        CRMTable= PageFactory.initElements(driver, CRMTablePage.class);

    }

}


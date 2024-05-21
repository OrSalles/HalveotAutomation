package PsagotPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MyAccountPage {
    @FindBy(xpath = "//*[name()='rect' and @id='acc_chart_57724_1_border']")
    public WebElement PieAccount;

    @FindBy(xpath = "//div[@role='list']//a[@class='nav-link active'][contains(text(),'התיק שלי')]")
    public WebElement MyAccountButton;

    @FindBy(xpath = "//h2[contains(text(),'הרכב תיק')]")
    public WebElement AccountComposition;

    @FindBy(xpath = "//*[name()='path' and @id='acc_chart_57724_1_Series_0_Point_2']")
    public WebElement pieElement01;
    @FindBy(xpath = "//*[name()='path' and @id='acc_chart_57724_1_Series_0_Point_3']")
    public WebElement pieElement02;
    @FindBy(xpath = "//*[name()='path' and @id='acc_chart_57724_1_Series_0_Point_1']")
    public WebElement pieElement03;

    @FindBy(xpath = "//h2[contains(text(),'פירוט אחזקות')]")
    public WebElement DetailsOfHoldings;

    @FindBy(xpath = "/html/body/div[1]/app-root/div/ng-component/login-guard/div/div/div[2]/div/div[3]/dashboard-header/ul/li[2]/a")
    public WebElement AccountReturnsTab;

    @FindBy(xpath = "//h2[contains(text(),'תשואה שנתית')]")
    public WebElement AnnualReturn;

    @FindBy(xpath = "//h2[contains(text(),'פירוט תשואות')]")
    public WebElement DetailsOfReturns;
    @FindBy(xpath = "//ejs-grid[@id='GRID_39a7161f-a79d-4cb0-9e35-4e4f2a3f0060']")
    public WebElement DetailsOfReturnsTable;

    @FindBy(xpath = "/html/body/div[1]/app-root/div/ng-component/login-guard/div/div/div[2]/div/div[3]/dashboard-header/ul/li[3]/a")
    public WebElement movementsTab;

    @FindBy(xpath = "/html/body/div[1]/app-root/div/ng-component/login-guard/div/div/div[2]/div/div[1]/div/side-bar/div/div/div[1]/a[3]")
    public WebElement movementsButton;

   // @FindBy(xpath = "//*[name()='path' and @id='acc_chart_57724_1_Series_0_Point_3']")
   // public WebElement pieElement03;
    @FindBy(xpath = "//a[contains(text(),'מתחילת החודש')]")
    public WebElement fromBeginningOfTheMonth;
    @FindBy(xpath = "//a[contains(text(),'מתחילת השנה')]")
    public WebElement fromBeginningOgTheYear;
    @FindBy(xpath = "//a[contains(text(),'12 חודשים אחרונים')]")
    public WebElement theLest12Months;







}

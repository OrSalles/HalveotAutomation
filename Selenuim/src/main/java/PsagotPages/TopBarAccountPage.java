package PsagotPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class TopBarAccountPage {

    @FindBy(xpath = "//div[@role='presentation h6']")
    public WebElement NameAccount;

    @FindBy(xpath = "//span[contains(text(),'₪1,394,625')]")
    public WebElement AccountValue;

    @FindBy(xpath = "//body/div[@class='masterContainer']/app-root/div[@role='main']/ng-component/login-guard/div[@class='pr-2 main-dashboard-pane-container']/div[@class='p-0 container']/div[@class='fixed-top bg-white topbarContainer shadow']/top-nav-bar/div[@class='container']/div[@class='row pl-1 pr-2 pt-3 pb-3 topBarComponent']/div[@class='col-12 pt-1']/dashboard/div/div[@class='row']/div[4]/div[1]/app-idash-widget[1]/div[1]/ng-component[1]/div[1]/div[1]/span[1]")
    public WebElement AccountYield;

    @FindBy(xpath = "//div[@class='h5 m-0 font-weight-bold']")
    public WebElement Date;

    @FindBy(xpath = "//div[@class='small']")
    public WebElement LevelOfRisk;

    @FindBy(xpath = "//div[@class='px-2']//div[1]")
    public WebElement PolicyName;
    //span[contains(text(),'₪1,394,625')]
    @FindBy(xpath = "//div[@class=' mb-2 text-center pr-4 pl-4 col-6 col-md']//div[3]")
    public WebElement InvestmentPolicy;




}

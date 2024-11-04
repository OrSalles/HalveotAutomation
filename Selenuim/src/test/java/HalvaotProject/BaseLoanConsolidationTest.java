package HalvaotProject;

import HalvotPages.PageLoader;
import Utils.JsonUtils;
import Utils.ReportUtils;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseLoanConsolidationTest {
    protected WebDriver driver;
    protected PageLoader pageLoader;

    private static String testData = "TestData.json";
    private static  String urlData = "urlData.json";
    String websiteUrl = "";
    String APIUrl = "";

    @BeforeClass
    public void startSession() throws InterruptedException, AWTException, IOException {
        JSONObject urlHalvaot = JsonUtils.returnJsonObject(urlData, "urlHalvaot");
        websiteUrl = (String) urlHalvaot.get("website");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(websiteUrl);
        changeAPI();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.navigate().refresh();
        pageLoader = new PageLoader(driver);
        Thread.sleep(2000);
        pageLoader.listOfFrames.frameButton.click();
        Thread.sleep(2000);
        pageLoader.listOfFrames.clickLastRow();
    }


    private void changeAPI() throws AWTException, InterruptedException, IOException {
        JSONObject urlAPI = JsonUtils.returnJsonObject(urlData, "urlAPI");
        APIUrl = (String) urlAPI.get("API");
        Robot robot = new Robot();
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
        alert.sendKeys(APIUrl);
        driver.switchTo().alert().accept();
    }
    @AfterMethod
    public void saveScreenShot(){
        ReportUtils.saveScreenShot(driver);
    }



    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();

    }
}

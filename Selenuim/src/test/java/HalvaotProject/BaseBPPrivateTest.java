package HalvaotProject;

import HalvotPages.BasePage;
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
import org.openqa.selenium.Dimension;

public class BaseBPPrivateTest {
    protected WebDriver driver;
    protected PageLoader pageLoader;
    protected BasePage basePage;

    private static String testData = "TestData.json";
    private static String urlData = "urlData.json";
    String websiteUrl = "";
    String APIUrl = "";

    @BeforeClass
    public void startSession() throws InterruptedException, AWTException, IOException {
        JSONObject urlHalvaot = JsonUtils.returnJsonObject(urlData, "urlHalvaot");
        websiteUrl = (String) urlHalvaot.get("website");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(2560, 1600));
        driver.manage().window().maximize();
        driver.get(websiteUrl);
        changeAPI();
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
//        double zoomLevel = 0.8;
//        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='" + zoomLevel + "'");
        basePage = new BasePage(driver);
        pageLoader = new PageLoader(driver);
//        basePage.wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
//        double zoomLevel = 0.8;
//        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='" + zoomLevel + "'");
        pageLoader.BPTable.BPButton.click();
        pageLoader.BPTable.AddButton.click();
        pageLoader.BPTable.PrivateBPButton.click();
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


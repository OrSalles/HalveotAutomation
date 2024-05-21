package PsagotPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;
import java.awt.event.KeyEvent;



public class LoginPage {

        @FindBy(how = How.XPATH, using = "//input[@placeholder=\"מס' ת.ז. 9 ספרות\"]")
        public WebElement txt_ID;

        @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,\"מספר טלפון נייד\")]")
        public WebElement txt_PHONE;

        @FindBy(how = How.XPATH, using = "//a[@role='button']")
        public WebElement btn_SENDCODEBUTTON;







        public void changeApi(WebDriver driver) throws AWTException, InterruptedException {
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
                alert.sendKeys("http://danel-db:7575/api/");
                driver.switchTo().alert().accept();

                }

         public void SignIn(String ID,String Phone) {
                 txt_ID.sendKeys(ID);
                 txt_PHONE.sendKeys(Phone);



         }




}



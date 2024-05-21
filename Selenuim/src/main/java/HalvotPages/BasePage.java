package HalvotPages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BasePage {
    public WebDriverWait wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver= driver;

        wait = new WebDriverWait(driver, 30);
    }
    public boolean isPageLoaded(String Xpath, int Iterations){
        for(int i=0;i<Iterations;i++){
            try {
                wait.until(elementToBeClickable(By.xpath(Xpath)));
            } catch (TimeoutException e) {
                return false;
            }
        }
        return true;
    }


}

package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperLib {

    public static void waitHelper(By locator, int timeseconds, WebDriver driver){
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(timeseconds));
        mywait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}

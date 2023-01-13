import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.HelperLib.waitHelper;
@DisplayName("Second set of JUnit 5 tests")

public class SecondJUnit5Tests extends TestBase {

    @Test
    @DisplayName("End to end login logout cycle")
    void loginlogout() {
        driver.get("http://www.edgewordstraining.co.uk/webdriver2/");
        driver.findElement(By.linkText("Login To Restricted Area")).click();
        driver.findElement(By.id("username")).sendKeys("edgewords");
        driver.findElement(By.id("password")).sendKeys("edgewords123");
        driver.findElement(By.linkText("Submit")).click();

        waitHelper(By.linkText("Log Out"), 3, driver);

        driver.findElement(By.linkText("Log Out")).click();
        driver.switchTo().alert().accept();

        waitHelper(By.id("username"), 10, driver);

        driver.findElement(By.id("username")).sendKeys("finished");
    }



}
import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;


public class FirstJUnit5Test extends TestBase {

    @Test
    void firstTest(){

        driver.get("http://www.edgewordstraining.co.uk/webdriver2/");
        driver.findElement(By.linkText("Login To Restricted Area")).click();
        driver.quit();
    }

    @Test
    void secondTest(){
        // Test name: SelIDEDemo
        // Step # | name | target | value
        // 1 | open | /webdriver2/ |
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        // 2 | setWindowSize | 945x1020 |
        driver.manage().window().setSize(new Dimension(945, 1020));
        // 3 | click | linkText=Access Basic Examples Area |
        driver.findElement(By.linkText("Access Basic Examples Area")).click();
        // 4 | click | css=li:nth-child(3) span |
        driver.findElement(By.cssSelector("li:nth-child(3) span")).click();
        // 5 | click | id=textInput |
        driver.findElement(By.id("textInput")).click();
        // 7 | type | id=textInput | Andrew Gordon
        driver.findElement(By.id("textInput")).sendKeys("Andrew Gordon");
        // 8 | type | id=textArea | was\nhere
        driver.findElement(By.id("textArea")).sendKeys("was\nhere");
        // 9 | click | id=checkbox |
        driver.findElement(By.id("checkbox")).click();
        // 10 | click | id=select |
        driver.findElement(By.id("select")).click();
        // 11 | select | id=select | label=Selection Two
        {
            WebElement dropdown = driver.findElement(By.id("select"));
            dropdown.findElement(By.xpath("//option[. = 'Selection Two']")).click();
        }
        // 12 | click | linkText=Submit |
        driver.findElement(By.linkText("Submit")).click();
        // 13 | click | id=textInputValue |
        driver.findElement(By.id("textInputValue")).click();
        // 14 | click | id=textInputValue |
        driver.findElement(By.id("textInputValue")).click();
        // 15 | doubleClick | id=textInputValue |
        {
            WebElement element = driver.findElement(By.id("textInputValue"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        // 16 | click | id=textInputValue |
        driver.findElement(By.id("textInputValue")).click();
        // 17 | click | css=tr:nth-child(2) > td:nth-child(3) |
        driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).click();
        // 18 | assertText | id=textInputValue | Andrew Gordon
        assertThat(driver.findElement(By.id("textInputValue")).getText(), is("Andrew Gordon"));
        // 19 | click | id=textAreaValue |
        driver.findElement(By.id("textAreaValue")).click();
        // 20 | verifyText | id=textAreaValue | was here
        try{
            //driver.findElement(By.linkText("Not there"));
            assertThat(driver.findElement(By.id("textAreaValue")).getText(), is("was here"));
        } catch (AssertionError e){
            //verificationerrors.append(e.toString());
        }

        // 21 | click | linkText=Back to form |

        driver.findElement(By.linkText("Back to form")).click();
        // 22 | click | linkText=CSS/XPath |
        driver.findElement(By.linkText("CSS/XPath")).click();
        // 23 | mouseDownAt | css=.ui-slider-handle | -65.5625,7.453125
        {
            WebElement element = driver.findElement(By.cssSelector(".ui-slider-handle"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().moveByOffset(100, 0).release();
            builder.perform();
        }
        // 24 | mouseMoveAt | id=slider | 234,9.5
        {
            //Drag and Drop using Actions
            WebElement element = driver.findElement(By.id("slider"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        // 25 | mouseUpAt | id=slider | 234,9.5
        {
            WebElement element = driver.findElement(By.id("slider"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
            try {
                Thread.sleep(3000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 26 | click | css=.ui-slider-handle |
        driver.findElement(By.cssSelector(".ui-slider-handle")).click();
        // 27 | click | linkText=Home |
        driver.findElement(By.linkText("Home")).click();
    }
}

package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    StringBuffer verificationerrors = new StringBuffer();

    @BeforeEach
    void setUp(){
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterEach
    void tearDown(){
        driver.quit();

        if(verificationerrors.toString().length() > 0){
            Assert.fail(verificationerrors.toString());
        }
    }

}

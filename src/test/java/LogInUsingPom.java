import base.TestBase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import poms.homePOM;
import poms.loginPOM;

public class LogInUsingPom extends TestBase {

    @ParameterizedTest
    @CsvFileSource(files = "test-data.csv", useHeadersInDisplayName = true)

    void Login(String username, String password) throws InterruptedException {
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        homePOM homepage = new homePOM(driver);
        homepage.goLogin();

        loginPOM loginPage = new loginPOM(driver);

        Assert.assertTrue(loginPage.LoginExpectSuccess(username, password));






        //Thread.sleep(3000);

    }

}

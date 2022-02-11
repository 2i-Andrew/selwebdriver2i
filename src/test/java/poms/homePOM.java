package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePOM {

    // Field to work with web driver instance
    WebDriver driver;

    // Constructor to accept driver from test and run PageFactory
    public homePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(linkText = "Login To Restricted Area")
    WebElement loginlink;

    //Service Methods
    public void goLogin(){
        loginlink.click();
    }
}

package tests;

import core.DriverManager;
import core.Environment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void adjustDriver() throws InterruptedException {
        driver= DriverManager.setDriver();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Environment(driver).selectEnvironment();
    }

    public WebDriver getDriver() {
        return driver;
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

}

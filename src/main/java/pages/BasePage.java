package pages;

import com.github.javafaker.Faker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    Faker faker;
    Actions actions;

        private static final Logger log = LogManager.getLogger(BasePage.class.getName());
    private long waitTime = Long.parseLong(Utils.dotEnv().get("EXPLICIT_WAIT"));

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        faker = new Faker(new Locale("en-us"));
    }

    protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    protected void typeIn(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public  void clickElement(By locator){
        WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));

        actions = new Actions(driver);
        actions.moveToElement(getElement(locator)).click().build().perform();

    }

    //  metoda getText()  nije koriscena nigde u testu
//    protected String getText(WebElement element, String log){
//        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(20));
//        webDriverWait.until(ExpectedConditions.visibilityOf(element));
//
//        System.out.println("We are getting text from element: " + " " + log);
//
//       return element.getText();
//    }


}

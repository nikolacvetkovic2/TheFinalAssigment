package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class RegisterPage extends BasePage {

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By signInLink = By.xpath("//*[@class='fa fa-lock']/..");

    By nameSignUp = By.cssSelector("[name=\"name\"]");
    By emailSignUp = By.xpath("//input[@data-qa='signup-email']");
    By signUpButton = By.xpath("//*[text()='Signup']");

    By title = By.id("id_gender1");
    By password = By.id("password");
    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By address = By.id("address1");
    By country = By.id("country");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");

    By createAccountButton = By.xpath("//*[text()='Create Account']");

    public void selectTitle() {
        clickElement(title);
    }

    public void enterPassword() {
        typeIn(password, "Lozinka11234!");
    }

    public void firstName() {
        typeIn(firstName, "Nikola1234567");
    }


    public void lastName() {
        typeIn(lastName, "Cvetkovic");
    }

    public void selectAddress() {
        typeIn(address, "Route 48, New York");
    }

    public void selectDoB() {
        Select selectDays = new Select(getElement(days));
        selectDays.selectByIndex(4);
        Select selectMonth = new Select(getElement(months));
        selectMonth.selectByIndex(4);
        Select selectYears = new Select(getElement(years));
        selectYears.selectByIndex(4);
    }

    public void selectCounty() {
        Select selectCountry = new Select(getElement(country));
        selectCountry.selectByValue("Israel");
    }

    public void selectState() {
        typeIn(state, "USA");
    }

    public void selectCity() {
        typeIn(city, "Miami");
    }

    public void selectZIP() {
        typeIn(zipcode, "0125");
    }

    public void mobileNumber() {
        typeIn(mobileNumber, "12346789");
    }

    public void clickOnCreateAccountButton() {
        clickElement(createAccountButton);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public RegisterPage goToSignInPage() {
        clickElement(signInLink);
        return this;
    }

    public void signUpNewUser() {
        typeIn(nameSignUp, "Nikol123467890 1234");
        typeIn(emailSignUp, System.currentTimeMillis() + "@gmail.com");
        clickElement(signUpButton);
        log.info("New user has been signed up. ");

    }

    public RegisterPage registerUser() {

        signUpNewUser();
        selectTitle();
        enterPassword();
        selectDoB();
        firstName();
        lastName();
        selectAddress();
        scrool();
        selectCounty();
        selectState();
        selectCity();
        selectZIP();
        mobileNumber();
        clickOnCreateAccountButton();
        log.info("New account has been created.");

        return this;

    }

    public void scrool(){
        JavascriptExecutor scrool=(JavascriptExecutor) driver;
        scrool.executeScript("window.scrollBy(0,-300)","");
    }
}



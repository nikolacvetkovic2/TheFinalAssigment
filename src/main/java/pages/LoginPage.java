package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class LoginPage extends BasePage {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    String emailInput= Utils.dotEnv().get("EMAIL");
    String passwordInput= Utils.dotEnv().get("PASSWORD");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By loginEmail=By.cssSelector("[data-qa=\"login-email\"]");
    By password =By.cssSelector("[data-qa=\"login-password\"]");
    By loginButton=By.cssSelector("[data-qa=\"login-button\"]");

    By logoutButton=By.cssSelector("[href=\"/logout\"]");

    By error=By.xpath("//*[text()='Your email or password is incorrect!']");

    public void clickLoginButton(){
        clickElement(loginButton);
    }

    public LoginPage loginUser(){
        typeIn(loginEmail,emailInput);
        typeIn(password,passwordInput);
        clickLoginButton();
        log.info("User has been successfully logged in. ");
        return  this;
    }

    public boolean isElementDisplayed(){
       return driver.findElement(logoutButton).isDisplayed();
    }

    public LoginPage logoutUser(){
        clickElement(logoutButton);
        log.info("User has been successfully logged out. ");
        return this;
    }

    public boolean errorMessage() {
        return driver.findElement(error).isDisplayed();
    }
}

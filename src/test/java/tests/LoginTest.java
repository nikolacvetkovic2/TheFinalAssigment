package tests;

import dataProviders.DataProviders;
import model.LoginUser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Utils;

import java.util.List;

public class LoginTest extends BaseTest {

    RegisterPage registerPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setupLoginPage() {
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Login user happy path. ")
    public void loginUser() {
        registerPage.goToSignInPage();
        loginPage.loginUser();
       Assert.assertTrue(loginPage.isElementDisplayed(), "Logout button is not displayed, user is not logged in. ");
    }

    @Test(description = "Login and logout user. ")
    public void loginUserAndLogout() {
        registerPage.goToSignInPage();
        loginPage.loginUser().logoutUser();
        Assert.assertEquals(driver.findElement(By.xpath("//*[text()='New User Signup!']")).getText(),"New User Signup!", "User is not logged out. ");
    }
    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviders.class)
    public void invalidLoginTest() {
        registerPage.goToSignInPage();
        loginPage.loginUser();
        Assert.assertTrue(loginPage.errorMessage());
    }

    @Test()
    public void invalidLoginTestFromJson(){
        List<LoginUser> list = Utils.getDataFromJson();
        for (int i = 0; i < list.size(); i++) {
            registerPage.goToSignInPage();
            loginPage.loginUser();
        }
        Assert.assertTrue(loginPage.errorMessage());
    }

}

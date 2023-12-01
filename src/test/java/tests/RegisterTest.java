package tests;

import listeners.TestListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegisterPage;
@Listeners(TestListener.class)

public class RegisterTest extends BaseTest{

    RegisterPage registerPage;

    String expectedText="Congratulations! Your new account has been successfully created!";

     @BeforeMethod
    public void setupRegister(){
         registerPage=new RegisterPage(driver);
     }

     @Test
    public void registerUser() {
         registerPage.goToSignInPage().registerUser();
         Assert.assertEquals(driver.findElement(By.xpath("//*[text()='Congratulations! Your new account has been successfully created!']")).getText(), expectedText);
     }

}

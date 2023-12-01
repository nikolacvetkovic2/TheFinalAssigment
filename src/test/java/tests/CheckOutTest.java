package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.RegisterPage;

public class CheckOutTest extends BaseTest{

    RegisterPage registerPage;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckOutPage checkOutPage;

    @BeforeMethod
    public void setupProductsPage() {
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkOutPage=new CheckOutPage(driver);
    }

    @Test(description = "Products test. ")
    public void productsTest() {
        registerPage.goToSignInPage();
        loginPage.loginUser("nikola@gmail.com", "Lozinka1!");
        productsPage.selectProductsForCheckOut();
        System.out.println(checkOutPage.getProductPricesSum());
        System.out.println(checkOutPage.getTotalAmount());

        Assert.assertEquals(checkOutPage.getProductPricesSum(), checkOutPage.getTotalAmount(),"The values of the products" +
               " do not match with the total amount. ");

    }
}


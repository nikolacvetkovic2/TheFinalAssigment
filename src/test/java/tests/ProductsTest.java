package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class ProductsTest extends BaseTest {

    RegisterPage registerPage;
    LoginPage loginPage;
    ProductsPage productsPage;
    PaymentPage payment;

    @BeforeMethod
    public void setupProductsPage() {
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        payment = new PaymentPage(driver);

    }

    @Test(description = "Products test, payment process and payment confirmation. ")
    public void productsTest() {
        registerPage.goToSignInPage();
        loginPage.loginUser("nikola@gmail.com", "Lozinka1!");
        productsPage.selectProducts();
        payment.populatePaymentPage();

        //Assert at the end as a confirmation that the order has been placed.
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).getText(), "Congratulations! Your order has been confirmed!", "Something went wrong with the order.");
    }

    @Test(description = "Filter testing. ")
    public void filterTest() {
        registerPage.goToSignInPage();
        loginPage.loginUser("nikola@gmail.com", "Lozinka1!");
        productsPage.clickOnProducts();
        System.out.println(productsPage.totalAmountOfTheProducts());
        productsPage.clickOnProducts().clickOnPolo();
        System.out.println(productsPage.totalAmountOfTheProducts());

    }

}

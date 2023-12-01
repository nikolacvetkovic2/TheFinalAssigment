package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    ContactUsPage contactUsPage;

    @BeforeMethod
    public void setupContactUsPage(){
        contactUsPage=new ContactUsPage(driver);
    }

    @Test
    public void contactUsTest() {
        contactUsPage.goToContactUs().populateAllData();
        Assert.assertEquals(driver.findElement(By.cssSelector(".status.alert.alert-success")).getText(),
                "Success! Your details have been submitted successfully.", "User did not submit ContactUS form. ");

    }
}

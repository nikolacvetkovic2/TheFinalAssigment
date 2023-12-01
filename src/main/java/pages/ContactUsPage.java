package pages;

import org.openqa.selenium.*;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    Alert alert;

   By contactUs= By.cssSelector("a[href='/contact_us']");
    By name=By.cssSelector("[data-qa=\"name\"]");
    By email=By.cssSelector("[name=\"email\"]");
    By subject=By.cssSelector("[name=\"subject\"]");
    By message=By.id("message");
    By chooseFile=By.cssSelector("[name=\"upload_file\"]");
    By submit=By.cssSelector("[name=\"submit\"]");

    public ContactUsPage goToContactUs(){
        clickElement(contactUs);
        return  this;
    }
    public void populateName(){
        typeIn(name, "Nikola");
    }
    public void populateEmail(){
        typeIn(email, System.currentTimeMillis() + "@gmail.com");
    }
    public void populateSubject(){
        typeIn(subject, "This is a subject");
    }
    public void populateMessage(){
        typeIn(message, "This is a test message.");
    }

    public void selectChooseFile(){
        typeIn(chooseFile, "C:\\Users\\Asus\\IdeaProjects\\TheFinalAssigment-AutomationTesting\\documentForChooseFileTest.txt");
    }

    public void submitBtn(){
        clickElement(submit);
    }


    public void alertToAvoidPopup(){
        alert=driver.switchTo().alert();
        alert.accept();
    }


    public ContactUsPage populateAllData() {
        populateName();
        populateEmail();
        populateSubject();
        populateMessage();
        selectChooseFile();
        submitBtn();
        alertToAvoidPopup();
        return  this;

    }
}
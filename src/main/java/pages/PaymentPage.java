package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    By nameOfCard=By.cssSelector("[name=\"name_on_card\"]");
    By cardNumber=By.cssSelector(".form-control.card-number");
    By cvc=By.cssSelector("[data-qa=\"cvc\"]");
    By expirationMonth=By.cssSelector("[data-qa=\"expiry-month\"]");
    By expirationYear=By.cssSelector(".form-control.card-expiry-year");
    By confirmOrder=By.id("submit");

    public void populatePaymentPage(){
        typeIn(nameOfCard, "NIkolina kartica");
        typeIn(cardNumber, "1234-567890");
        typeIn(cvc, "488");
        typeIn(expirationMonth, "04");
        typeIn(expirationYear, "02");
        clickElement(confirmOrder);
    }


}

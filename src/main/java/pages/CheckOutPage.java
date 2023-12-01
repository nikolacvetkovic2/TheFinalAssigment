package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{

    private static final Logger log = LogManager.getLogger(CheckOutPage.class.getName());

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    By blueTopPrice=By.xpath("//p[text()='Rs. 500']");
    By blueTopPriceAmount=By.xpath("//button[text()='1']");
    By GreenTopPrice=By.xpath("//p[text()='Rs. 700']");
    By GreenTopAmount   =By.xpath("//button[text()='2']");
    By totalAmount=By.xpath("//p[text()='Rs. 1900']");


    public int getPriceFromblueTopPrice(){
        return Integer.parseInt(driver.findElement(blueTopPrice).getText().trim().replace("Rs. ",""));
    }

    public int getPriceFromblueTopPriceAmount(){
        return Integer.parseInt(driver.findElement(blueTopPriceAmount).getText().trim().replace("Rs. ",""));
    }

    public int getGreenTopPrice(){
        return Integer.parseInt(driver.findElement(GreenTopPrice).getText().trim().replace("Rs. ",""));
    }

    public int getGreenTopAmount(){
        return Integer.parseInt(driver.findElement(GreenTopAmount).getText().trim().replace("Rs. ",""));
    }

    public int getProductPricesSum() {
        int sum=0;
        sum=(getPriceFromblueTopPrice()*getPriceFromblueTopPriceAmount())+(getGreenTopPrice()* getGreenTopAmount());
        return sum;
    }

    public int getTotalAmount(){
        return Integer.parseInt(driver.findElement(totalAmount).getText().trim().replace("Rs. ",""));
    }

}

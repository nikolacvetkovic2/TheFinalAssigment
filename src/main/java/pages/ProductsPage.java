package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LogManager.getLogger(ProductsPage.class.getName());

    By products=By.cssSelector("a[href='/products']");
    By firstProduct=By.cssSelector("a[href='/product_details/1']");
//By firstProduct=By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]/i[1]");
    By addToCartFirstProduct=By.cssSelector(".btn.btn-default.cart");
    By continueShoppingButton=By.cssSelector(".btn.btn-success.close-modal.btn-block");
    By selectPolo=By.cssSelector("a[href='/brand_products/Polo']");
    By secondProduct=By.cssSelector("a[href='/product_details/8']");
    By quantity=By.cssSelector("#quantity");
    By addToCartSecondProduct=By.cssSelector(".btn.btn-default.cart");
    By cartButton=By.xpath("//u[text()='View Cart']");
    By checkoutButton=By.cssSelector(".btn.btn-default.check_out");
    By placeOrder=By.cssSelector(".btn.btn-default.check_out");

    By allProducts=By.xpath("//div[@class='features_items']//div[@class='col-sm-4']");
    By productPolo=By.cssSelector("a[href='/brand_products/Polo']");

    public ProductsPage clickOnProducts(){
        clickElement(products);
        return  this;
    }

   public void selectFirstProduct(){
        clickElement(firstProduct);
    }

    public void selectAddToCartFirstProduct(){
        clickElement(addToCartFirstProduct);
    }

    public void clickContinueShoppingButton(){
        clickElement(continueShoppingButton);
    }

    public void clickOnPolo(){
        clickElement(selectPolo);
    }

    public void selectSecondProduct(){
        clickElement(secondProduct);
    }

    public void selectQuantity(){
        typeIn(quantity,"2");
    }

    public void selectAddToCartSecondProduct(){
        clickElement(addToCartSecondProduct);
    }

    public void openCart(){
        clickElement(cartButton);
    }

    public void proceedToCheckout(){
        clickElement(checkoutButton);
        log.info(driver.findElement(checkoutButton).getText() + " " + "button" + " " + "has been successfully clicked. ");
    }

    public ProductsPage selectProducts() {
        clickOnProducts();
        clickOnPolo();
       selectFirstProduct();
        selectAddToCartFirstProduct();
        clickContinueShoppingButton();
        clickOnPolo();
        selectSecondProduct();
        selectQuantity();
        selectAddToCartSecondProduct();
        openCart();
        proceedToCheckout();
        clickOnPlaceOrder();
        return  this;
    }
    public void clickOnPlaceOrder(){
        clickElement(placeOrder);
    }

    public ProductsPage selectProductsForCheckOut() {
        clickOnProducts();
        clickOnPolo();
        selectFirstProduct();
        selectAddToCartFirstProduct();
        clickContinueShoppingButton();
        clickOnPolo();
        selectSecondProduct();
        selectQuantity();
        selectAddToCartSecondProduct();
        openCart();
        proceedToCheckout();
        return  this;
    }

    public int totalAmountOfTheProducts(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allProducts));
        List<WebElement>list= driver.findElements(allProducts);
        log.info("The current number of the elements display on the page is:  ");
        return list.size();
    }

    }


package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.Utils;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class DriverManager {

        private static String browser= Utils.dotEnv().get("BROWSER");

    public static WebDriver setDriver() throws InterruptedException {
        WebDriver driver=null;
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximazed");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addExtensions(new File("C:\\Users\\Asus\\IdeaProjects\\TheFinalAssigment-AutomationTesting\\src\\main\\java\\extensions\\Crx4Chrome.crx"));


//        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("--disable-notifications");


        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximazed");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--disable-popup-blocking");
        firefoxOptions.addArguments("headless");
        firefoxOptions.addArguments("window-size=1920,1080");
        firefoxOptions.addArguments("--disable-notifications");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(chromeOptions);
            Thread.sleep(3000);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.close();
            driver.switchTo().window(tabs.get(0));
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;
    }






}

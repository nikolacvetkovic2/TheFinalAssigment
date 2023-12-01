package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Utils;

public class Environment {

    private String homeUrl;
    private WebDriver driver;

//    private static final Logger log = LogManager.getLogger(Environment.class.getName());

    public Environment(WebDriver driver) {
        this.driver = driver;
    }

    public void selectEnvironment(){
        String environment= Utils.dotEnv().get("ENV");
        if(environment.equalsIgnoreCase("dev")){
            homeUrl=Utils.dotEnv().get("DEV_URL");
        } else if(environment.equalsIgnoreCase("qa")){
            homeUrl=Utils.dotEnv().get("QA_URL");
            // da ubacim logere ovde
        }
        driver.get(homeUrl);
    }

}

package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="loginDataProvider")
    public Object[][] loginDataProvider(){
        return  new Object [][]{
                {"nikola@gmail.com","asda12"},
                {"nikola1234@gmail.com", "Lozinka1!"},
                {"qqwqw@rwge.com","11111111111"},
        };

    }




}

package methods;

import Base.CommonAPI;
import IPadLayout.SignIn.ShopKeepSignIn;
import Utility.SQL.ConnectDatabaseSQL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by abra on 4/12/17.
 */
public class CommonMethods extends CommonAPI{                 //This Class contains Methods that are often used in the Automation Scripts



    public Boolean loggedIn=false;

public void shopKeepLogin() throws Exception {               //Logging into the ShopKeep BackOffice account using credentials from mySQL Database for security purposes
    if (!loggedIn) {
        ShopKeepSignIn shopKeepSignIn = PageFactory.initElements(driver, ShopKeepSignIn.class);
        ConnectDatabaseSQL connectDatabaseSQL = new ConnectDatabaseSQL();                                                 //Connecting to mySQL Database
        List<String> list = new ArrayList<String>();
        list = connectDatabaseSQL.retrieveDataFromTable("login_info", "shopkeep_login_credentials");   //SQL query to retrieve data from 'login_info' table in mySQL Database
        int i = 0;
        typeByCss("input[id='login']", list.get(i));
        typeByCss("input[id='password']", list.get(i + 1));
        clickByCss("input[id='submit']");
        loggedIn = true;
    }
}
//    public void shopKeepLogin() throws Exception{                                                      //Use this method to login locally. Just enter Username & Password
//    ShopKeepSignIn shopKeepSignIn = PageFactory.initElements(driver, ShopKeepSignIn.class);
//    shopKeepSignIn.emailAddressField.sendKeys("");
//    shopKeepSignIn.passwordField.sendKeys("");
//    shopKeepSignIn.logInButton.click();
//}




public void switchToDeletePageConfirmationPopup() throws Exception{                     //Switches Window to The Confirmation Popup that appears when the user clicks on the Delete Page Button
    String parentWindowHandler = driver.getWindowHandle(); // Storing parent window
    String subWindowHandler = null;

    Set<String> handles = driver.getWindowHandles(); // get all window handles
    Iterator<String> iterator = handles.iterator();
    while (iterator.hasNext()){
        subWindowHandler = iterator.next();
    }
    driver.switchTo().window(subWindowHandler); // switching to popup window
}




    public void typeByCss(String locator, String value) {                                       //Type Using Css Locator
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void clickByCss(String locator) {                                                    //Click Using Css Locator

        driver.findElement(By.cssSelector(locator)).click();
    }

}

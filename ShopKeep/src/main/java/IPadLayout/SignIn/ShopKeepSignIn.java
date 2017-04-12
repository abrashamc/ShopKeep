package IPadLayout.SignIn;

import Base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by abra on 4/12/17.
 */
public class ShopKeepSignIn extends CommonAPI {    //This class contains all the WebElements for the Login Page of the ShopKeep BackOffice


    //Web Elements:

    @FindBy(how = How.ID, using = "store_name")    //This is the WebElement for the Name field in the login page
    public WebElement storeNameField;

    @FindBy(how = How.ID, using = "login")         //This is the WebElement for the E-mail field in the login page
    public WebElement emailAddressField;

    @FindBy(how = How.ID, using = "password")      //This is the WebElement for the Password field in the login page
    public WebElement passwordField;

    @FindBy(how = How.ID, using = "submit")        //This is the WebElement for the Login button in the login page
    public WebElement logInButton;
}

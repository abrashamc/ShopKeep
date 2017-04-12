package IPadLayoutTest.TestPageNameField;

import IPadLayout.PageNameField.IPadLayoutPageNameField;
import methods.CommonMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by abra on 4/12/17.
 */
public class TestIPadLayoutPageNameField extends CommonMethods {                       //This class contains all the tests related to the Page Name field(used to name pages) in the iPad Layout section

    public IPadLayoutPageNameField testPageNameField() throws Exception{               //ACTIVATES ELEMENTS FROM IPadLayoutPageNameField Class
        return PageFactory.initElements(driver, IPadLayoutPageNameField.class);
    }


    @Test(priority = 1)
    public void renameANewPage() throws Exception{                                      //ADDING A NEW PAGE AND RENAMING IT TO 'HOT BEVERAGES'
        shopKeepLogin();
        testPageNameField().clickAddPageBtn();                                          //Clicks Add Page Button. Method being called from IPadLayoutPageNameField class
        testPageNameField().typeInPageNameField();                                                     //Types 'Hot Beverages' in the Page Name Field. Method being called from IPadLayoutPageNameField class
        Assert.assertEquals("Hot Beverages",testPageNameField().newPageCreatedTab.getText());   //Validates the creation of the New Page
        captureScreenshot(driver,"RenamedPageToHotBeverage");                           //Captures screenshot of the New Page (Added to /ShopKeepAutomation/ShopKeep/screenshots). Method called from CommonMethods class.
    }
}

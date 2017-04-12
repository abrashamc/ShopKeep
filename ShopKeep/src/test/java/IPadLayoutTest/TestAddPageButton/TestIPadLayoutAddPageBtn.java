package IPadLayoutTest.TestAddPageButton;

import IPadLayout.AddPageButton.IPadLayoutAddButton;
import methods.CommonMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by abra on 4/12/17.
 */
public class TestIPadLayoutAddPageBtn extends CommonMethods{                //This class contains all the tests related to the Add Button in the iPad Layout section

    public IPadLayoutAddButton testAddPageBtn() throws Exception{           //ACTIVATES ELEMENTS FROM IPadLayoutAddButton class
        return PageFactory.initElements(driver, IPadLayoutAddButton.class);
    }


    @Test(priority = 1)
    public void addPageBtnPresent() throws Exception{                       //CHECKS IF THE ADD PAGE BUTTON IS PRESENT AND ENABLED
        shopKeepLogin();
        Assert.assertTrue(testAddPageBtn().addPageButton.isDisplayed());    //Validates the Add Page Button is Present
        Assert.assertTrue(testAddPageBtn().addPageButton.isEnabled());      //Validates the Add Page Button is Enabled
    }

    @Test(priority = 2)
    public void addNewPage() throws Exception{                              //CHECKS IF CLICKING THE ADD PAGE BUTTON OPENS UP A NEW PAGE
        shopKeepLogin();
        testAddPageBtn().clickAddPageBtn();                                 //Clicks on the Add Page Button. The method is being called from the IPadLayoutAddButton class.
        Assert.assertTrue(testAddPageBtn().newPageTab.isDisplayed());       //Validates the creation of the New Page
        captureScreenshot(driver,"AddNewPage");              //Captures Screenshot of the New Page (Added to /ShopKeepAutomation/ShopKeep/screenshots). Method called from CommonMethods class.

    }
}

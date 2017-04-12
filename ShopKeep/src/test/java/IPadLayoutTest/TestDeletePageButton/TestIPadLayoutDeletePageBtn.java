package IPadLayoutTest.TestDeletePageButton;

import IPadLayout.DeletePageButton.IPadLayoutDeletePageBtn;
import methods.CommonMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by abra on 4/12/17.
 */
public class TestIPadLayoutDeletePageBtn extends CommonMethods{                      //This class contains all the tests related to the Delete Button in the iPad Layout section

    public IPadLayoutDeletePageBtn testDeletePageBtn() throws Exception{             //ACTIVATES ELEMENTS FROM IPadLayoutDeleteButton Class
        return PageFactory.initElements(driver, IPadLayoutDeletePageBtn.class);
    }


    @Test(priority = 1)
    public void deletePageBtnPresent() throws Exception{                             //CHECKS IF THE DELETE PAGE BUTTON IS PRESENT AND ENABLED
        shopKeepLogin();
        Assert.assertTrue(testDeletePageBtn().deletePageButton.isDisplayed());       //Validates that the Delete Page Button is Present
        Assert.assertTrue(testDeletePageBtn().deletePageButton.isEnabled());         //Validates that the Delete Page Button is Enabled
    }

    @Test(priority = 2)
    public void confirmPopupAppears() throws Exception{                              //CHECKS IF CLICKING THE DELETE PAGE BUTTON OPENS UP A CONFIRMATION POPUP
        shopKeepLogin();
        testDeletePageBtn().clickDeletePageBtn();                                    //Clicks Delete Page Button. Method called from IPADLayoutDeleteButton class
        testDeletePageBtn().waitForPopup();                                          //Explicitly waits for Confirmation Popup to appear. Method called from IPADLayoutDeleteButton class
        switchToDeletePageConfirmationPopup();                                             //Switches window/focus to the Popup. Method called from IPADLayoutDeleteButton class
        Assert.assertTrue(testDeletePageBtn().deletePageConfirmationPopup.isDisplayed());  //Validates the presence of the Confirmation Dialog
        captureScreenshot(driver,"ConfirmPopup");                           //Captures screenshot of the popup (Added to /ShopKeepAutomation/ShopKeep/screenshots). Method called from CommonMethods class.
    }

    @Test(priority = 3)
    public void deletePage() throws Exception{                   //CREATES AND DELETES A PAGE
        shopKeepLogin();
        testDeletePageBtn().clickAddPageBtn();                   //Clicks Add Page Button. Method being called from IPADLayoutDeleteButton class
        testDeletePageBtn().clickDeletePageBtn();                //Clicks Delete Page Button. Method being called from IPADLayoutDeleteButton class
        switchToDeletePageConfirmationPopup();
        testDeletePageBtn().clickConfirmBtnInPopup();            //Clicks Confirm on the Confirmation Popup. Method being called from IPADLayoutDeleteButton class
    }

}

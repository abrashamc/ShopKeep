package IPadLayoutTest.TestPlacementField;

import IPadLayout.PlacementField.IPadLayoutPlacementField;
import methods.CommonMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by abra on 4/12/17.
 */
public class TestIPadLayoutPlacementField extends CommonMethods {                              //This class contains all the tests related to the Placement Field(used to place items) in the iPad Layout section

    public IPadLayoutPlacementField testPlacementField() throws Exception{                     //ACTIVATES ELEMENTS FROM IPadLayoutPlacementField Class
        return PageFactory.initElements(driver, IPadLayoutPlacementField.class);
    }


    @Test(priority = 1)
    public void dragAndDropItemFromListToField() throws Exception{                             //DRAGS ITEM FROM LIST AND DROPS IT INTO THE PLACEMENT FIELD
        shopKeepLogin();
        testPlacementField().dropItemFromListToPlacementField();                                                             //Drops Item from List to the Placement field. Method called from IPadLayoutPlacementField class.
        Assert.assertEquals(testPlacementField().firstPlacementBlock.getAttribute("aria-disabled"),"true");  //Validates the item has been added to the placement field. Method called from IPadLayoutPlacementField class.
        captureScreenshot(driver,"DropItemFromListToField");                                                  //Captures screenshot of the item dropped in the placement field (Added to /ShopKeepAutomation/ShopKeep/screenshots). Method called from CommonMethods class.
    }

    @Test(priority = 2)
    public void dragAndDropButtonFromFieldToList() throws Exception{                           //DRAGS ITEM FROM PLACEMENT FIELD AND DROPS IT BACK INTO THE LIST
        shopKeepLogin();
        testPlacementField().dropItemFromListToPlacementField();                               //Drops Item from List to the Placement field. Method called from IPadLayoutPlacementField class.
        testPlacementField().dropItemFromPlacementFieldToList();                               //Drops Item from Placement Field to the List. Method called from IPadLayoutPlacementField class.

        Assert.assertEquals(testPlacementField().firstItemInList.getAttribute("data-id"),"293C85C3-FD70-4C53-A92C-89F11906AC86");    // Validates the item has been returned to the top of the list
    }
}

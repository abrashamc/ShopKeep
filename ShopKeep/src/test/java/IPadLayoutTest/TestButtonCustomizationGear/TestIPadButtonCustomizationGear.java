package IPadLayoutTest.TestButtonCustomizationGear;

import IPadLayout.ButtonCustomizationGear.IPadLayoutButtonCustomizationGear;
import methods.CommonMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by abra on 4/12/17.
 */
public class TestIPadButtonCustomizationGear extends CommonMethods {                          //This class contains all the tests related to the Customization Option(in Items/Tiles) in the iPad Layout section

    public IPadLayoutButtonCustomizationGear testButtonCustomizationGear() throws Exception{  //ACTIVATES ELEMENTS FROM IPadLayoutButtonCustomizationGear Class
        return PageFactory.initElements(driver, IPadLayoutButtonCustomizationGear.class);
    }

    @Test(priority = 1)
    public void changeItemColorAndRename() throws Exception{                                  //DROPS THE FIRST ITEM FROM THE LIST INTO THE PLACEMENT FIELD AND CHANGES IT'S COLOR TO RED
        shopKeepLogin();
        testButtonCustomizationGear().dropItemFromListToPlacementField();                     //Drops first item from the list to the placement field. The method is being called from the IPadLayoutButtonCustomizationGear class.
        testButtonCustomizationGear().changeItemColorToRed();                                 //Clicks the item and chooses Red as the Tile color. The method is being called from the IPadLayoutButtonCustomizationGear class

        Assert.assertEquals(testButtonCustomizationGear().firstItemInPlacementBlock2.getAttribute("class"), "si-button color-ce4457 ui-draggable");         //Validates the color is Red

        captureScreenshot(driver,"ButtonColorChangedToRed");                   //Captures screenshot of the Red Tile (Added to ShopKeepAutomation/ShopKeep/screenshots). Method called from CommonMethods class.
        testButtonCustomizationGear().changeButtonText();                                     //Renames the Bagel Tile name to "Bagel & Cream Cheese".

    }

}

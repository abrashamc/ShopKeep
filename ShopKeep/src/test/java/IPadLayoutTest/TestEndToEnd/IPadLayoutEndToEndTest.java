package IPadLayoutTest.TestEndToEnd;

import methods.CommonMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by abra on 4/12/17.
 */
public class IPadLayoutEndToEndTest extends CommonMethods{                              //This class contains test done for an End To End test of the main functionality on the iPad Layout section

    public IPadLayoutRepository.PageFactory endToEnd() throws Exception{                //ACTIVATING ELEMENTS FROM IPadLayoutSearchBar Class
        return PageFactory.initElements(driver, IPadLayoutRepository.PageFactory.class);
    }


    @Test(priority = 1)
    public void customizeButtonLayoutEndToEnd() throws Exception{                       //THIS METHOS SEARCHES FOR BAGEL, DROPS IT INTO THE PLACEMENT FIELD AND CHANGES IT'S COLOR TO RED AND RENAMES IT TO 'BAGEL & CREAM CHEESE)
        shopKeepLogin();

        endToEnd().bagelSearch();                                                       //Types 'Bagel' into the search field. Methods called from IPadLayoutRepository.PageFactory class
        Assert.assertTrue(endToEnd().bagelItem.isDisplayed());                          //Validates 'Bagel' being displayed on the list of items. Web Element called from IPadLayoutRepository.PageFactory class

        endToEnd().dropItemFromListToPlacementField();                                  //Drops Item from List to the Placement field. Method called from IPadLayoutRepository.PageFactory class.
        Assert.assertEquals(endToEnd().firstPlacementBlock.getAttribute("aria-disabled"),"true");  //Validates the item has been added to the placement field. Method called from IPadLayoutRepository.PageFactory class.

        endToEnd().changeItemColorToRed();                                              //Clicks the item and chooses Red as the Tile color. The method is being called from the IPadLayoutRepository.PageFactory class
        endToEnd().changeButtonText();                                                  //Renames the Bagel Tile name to "Bagel & Cream Cheese"
        captureScreenshot(driver,"EndToEnd");                            //Captures screenshot of the Red Tile renamed to Bagel & Cream Cheese (Added to ShopKeepAutomation/ShopKeep/screenshots). Method called from CommonMethods class.
    }
}

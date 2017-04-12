package IPadLayout.PlacementField;

import methods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abra on 4/12/17.
 */
public class IPadLayoutPlacementField extends CommonMethods {           //This class contains all the WebElements and Methods for the Placement field(used to drop items to be used in the counter) in the iPad Layout section


    //Web Elements:

    @FindBy(xpath = ".//ul[@id='results']/li[1]")                       //This is the WebElement for the first item in the items list
    public WebElement firstItemInList;

    @FindBy(xpath = "//div[@id='button-pages']/div[1]/div[1]")          //This is the WebElement for the first block in the Placement field
    public WebElement firstPlacementBlock;




    //Methods:

    public void dropItemFromListToPlacementField() throws Exception{             //This method drags the first item from the list and drops it into the first block of the placement field
        Actions action = new Actions(driver);
        action.dragAndDrop(firstItemInList,firstPlacementBlock).build().perform();
        Thread.sleep(5000);
    }

    public void dropItemFromPlacementFieldToList() throws Exception{              //This method drags the first tile in the placement field and returns it back to the list
        Actions action = new Actions(driver);
        action.dragAndDrop(firstPlacementBlock,firstItemInList).build().perform();
    }
}

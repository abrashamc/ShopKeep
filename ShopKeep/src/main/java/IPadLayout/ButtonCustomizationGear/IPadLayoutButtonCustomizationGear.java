package IPadLayout.ButtonCustomizationGear;

import methods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by abra on 4/12/17.
 */
public class IPadLayoutButtonCustomizationGear extends CommonMethods {     //This class contains all the WebElements and Methods used to open the configuration options(used to change color or rename tile) in the iPad Layout section


    //Web Elements:

    @FindBy(xpath = ".//ul[@id='results']/li[1]")                          //This is the WebElement for the first item in the list
    public WebElement firstItemInList;

    @FindBy(xpath = "//div[@id='button-pages']/div[1]/div[1]")             //This is the WebElement for the first position on the placement field
    public WebElement firstPlacementBlock;

    @FindBy(xpath = "//div[@class='si-button-holder'][1]/div[1]/div[2]")   //This is the WebElement for the item placed in the first block in the placement field
    public WebElement firstItemInPlacementBlock;

    @FindBy(xpath = "//div[@class='si-button-holder'][1]/div[1]")
    public WebElement firstItemInPlacementBlock2;

    @FindBy(xpath = "//input[@class='button-text-modifier']")              //This is the WebElement for the text field in the button configuration used to rename tiles
    public WebElement buttonTextField;

    @FindBy(xpath = "//div[@class='si-button-holder'][1]/div[1]//div[2]/a[3]") //This is the WebElement for the Red Color Button used to change the color of the tile to red
    public WebElement redButtonColor;

    @FindBy(how = How.ID, using = "add-button-page")                       //This is the WebElement for the Add Button used to add new page
    public WebElement addPageButton;





    //Methods:

    public void dropItemFromListToPlacementField() throws Exception{              //This method Drags an item from the list and drops it into the Placement Field using the Actions class
        Actions action = new Actions(driver);
        action.dragAndDrop(firstItemInList,firstPlacementBlock).build().perform();
    }

    public void changeItemColorToRed() throws Exception{                         //This method clicks on the first tile and clicks on the red color button
       firstItemInPlacementBlock.click();
       redButtonColor.click();
    }

    public void changeButtonText() throws Exception{                             //This method clicks on the first item on the placement field and then types " & Cream Cheese" into the text field
        firstItemInPlacementBlock.click();
        buttonTextField.click();
        buttonTextField.sendKeys(" & Coffee");
    }
}

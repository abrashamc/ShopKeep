package IPadLayoutRepository;

import methods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by abra on 4/12/17.
 */
public class PageFactory extends CommonMethods {               //This class is a repository for all the WebElements and Methods in the iPad Layout section. This class is created to perform an End To End Test



    //Web Elements:

    @FindBy(how = How.ID, using = "add-button-page")           //This is the WebElement for the Add Button used to add new page
    public WebElement addPageButton;

    @FindBy(css = ".name")                                     //This is the WebElement for the New Page that opens up after clicking the add page button
    public WebElement newPageTab;

    @FindBy(xpath = ".//ul[@id='results']/li[1]")                              //This is the WebElement for the first item in the list
    public WebElement firstItemInList;

    @FindBy(xpath = "//div[@id='button-pages']/div[1]/div[1]")                 //This is the WebElement for the first position on the placement field
    public WebElement firstPlacementBlock;

    @FindBy(xpath = "//div[@class='si-button-holder'][1]/div[1]/div[2]")       //This is the WebElement for the item placed in the first block in the placement field
    public WebElement firstItemInPlacementBlock;

    @FindBy(xpath = "//div[@class='si-button-holder'][1]/div[1]")
    public WebElement firstItemInPlacementBlock2;

    @FindBy(xpath = "//input[@class='button-text-modifier']")                  //This is the WebElement for the text field in the button configuration used to rename tiles
    public WebElement buttonTextField;

    @FindBy(xpath = "//div[@class='si-button-holder'][1]/div[1]//div[2]/a[3]") //This is the WebElement for the Red Color Button used to change the color of the tile to red
    public WebElement redButtonColor;

    @FindBy(how = How.ID, using = "destroy-button-page")                      //This is the WebElement for the delete button
    public WebElement deletePageButton;

    @FindBy(css = "div[class='modal-legacy confirmation-dialog ']")           //This is the WebELement for the Delete Confirmation Popup
    public WebElement deletePageConfirmationPopup;

    @FindBy(css = "button[class='button primary confirm']")                   //This is the WebElement for the Confirm Button on the confirmation popup
    public WebElement confirmButtonInPopup;

    @FindBy(how = How.ID, using = "button-page-name")            //This is the WebElement for the Page Name Field
    public WebElement pageNameField;

    @FindBy(css = "a[class='page-tab active']")                  //This is the WebElement for the current New Page created
    public WebElement newPageCreatedTab;

    @FindBy(xpath = "//div[@id='button-page-tabs']/a[2]")       //This is the WebElement for the first Page Tab
    public WebElement firstPageTab;

    @FindBy(xpath = "//div[@id='button-page-tabs']/a[3]")       //This is the WebElement for the second Page Tab
    public WebElement secondPageTab;

    @FindBy(how = How.ID, using = "item-search-input")        //This is the WebElement for the Search field
    public WebElement searchField;

    @FindBy(css = "li[data-id='293C85C3-FD70-4C53-A92C-89F11906AC86']")   // This is the WebElement for the Bagel Item in the list
    public WebElement bagelItem;

    @FindBy(css = ".ui-draggable")
    public WebElement searchedItem;                              //This is the WebELement for the first item in the list








    //Methods:



    public void dropItemFromListToPlacementField() throws Exception{                  //This method Drags an item from the list and drops it into the Placement Field using the Actions class
        Actions action = new Actions(driver);
        action.dragAndDrop(firstItemInList,firstPlacementBlock).build().perform();
    }

    public void changeItemColorToRed() throws Exception{                             //This method clicks on the first tile and clicks on the red color button
        firstItemInPlacementBlock.click();
        redButtonColor.click();
    }

    public void changeButtonText() throws Exception{                                 //This method clicks on the first item on the placement field and then types " & Cream Cheese" into the text field
        firstItemInPlacementBlock.click();
        buttonTextField.click();
        buttonTextField.sendKeys(" & Cream Cheese");
    }



    public void bagelSearch() throws Exception{                  //This method types 'Bagel' into the search field
        searchField.sendKeys("Bagel");
    }



}

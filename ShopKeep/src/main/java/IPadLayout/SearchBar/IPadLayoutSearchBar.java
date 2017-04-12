package IPadLayout.SearchBar;

import methods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by abra on 4/12/17.
 */
public class IPadLayoutSearchBar extends CommonMethods {    //This class contains all the WebElements for the Search Bar in the iPad Layout section


    //Web Elements:

    @FindBy(how = How.ID, using = "item-search-input")      //This is the WebElement for the Search field
    public WebElement searchField;

    @FindBy(css = "li[data-id='293C85C3-FD70-4C53-A92C-89F11906AC86']")   // This is the WebElement for the Bagel Item in the list
    public WebElement bagelItem;

    @FindBy(css = ".ui-draggable")
    public WebElement searchedItem;                          //This is the WebELement for the first item in the list




    //Methods:

    public void bagelSearch() throws Exception{              //This method types 'Bagel' into the search field
        searchField.sendKeys("Bagel");
    }
}






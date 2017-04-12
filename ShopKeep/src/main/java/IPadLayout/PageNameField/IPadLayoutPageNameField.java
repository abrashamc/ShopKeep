package IPadLayout.PageNameField;

import methods.CommonMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by abra on 4/12/17.
 */
public class IPadLayoutPageNameField extends CommonMethods {  //This class contains all the WebElements and Methods for the Page Name Field(used to rename page) in the iPad Layout Section


    //Web Elements:

    @FindBy(how = How.ID, using = "button-page-name")         //This is the WebElement for the Page Name Field
    public WebElement pageNameField;

    @FindBy(how = How.ID, using = "add-button-page")          //This is the WebElement for the Add Button (used to add new page)
    public WebElement addPageButton;

    @FindBy(css = "a[class='page-tab active']")               //This is the WebElement for the current New Page created
    public WebElement newPageCreatedTab;




    //Methods:

    public void typeInPageNameField() throws Exception{      //This method clicks on the Page Name Field and renames the current page to 'Hot Beverages'
        pageNameField.click();
        pageNameField.clear();
        pageNameField.sendKeys("Breakfast");
        pageNameField.sendKeys(Keys.ENTER);
    }

    public void clickAddPageBtn() throws Exception{         //This is the method to Click the Add Page Button
        addPageButton.click();
        System.out.println("Created New Page");
    }
}

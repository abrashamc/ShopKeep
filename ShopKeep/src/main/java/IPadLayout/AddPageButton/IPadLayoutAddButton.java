package IPadLayout.AddPageButton;

import methods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by abra on 4/12/17.
 */
public class IPadLayoutAddButton extends CommonMethods { //This class contains all the WebElements and Methods for the Add Button(used to add new page) on the iPad Layout Section


    //Web Elements:

    @FindBy(how = How.ID, using = "add-button-page")     //This is the WebElement for the Add Button used to add new page
    public WebElement addPageButton;

    @FindBy(css = ".name")                               //This is the WebElement for the New Page that opens up after clicking the add page button
    public WebElement newPageTab;




    //Methods:

    public void clickAddPageBtn() throws Exception{      //This is the method to Click the Add Page Button
        addPageButton.click();
    }
}

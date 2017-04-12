package IPadLayout.DeletePageButton;

import methods.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by abra on 4/12/17.
 */
public class IPadLayoutDeletePageBtn extends CommonMethods {            //This class contains all the WebElements and methods for the Delete Button(used to delete page) in the iPad Layout section


    //Web Elements:

    @FindBy(how = How.ID, using = "destroy-button-page")                //This is the WebElement for the delete button
    public WebElement deletePageButton;

    @FindBy(css = "div[class='modal-legacy confirmation-dialog ']")     //This is the WebELement for the Delete Confirmation Popup
    public WebElement deletePageConfirmationPopup;

    @FindBy(css = "button[class='button primary confirm']")             //This is the WebElement for the Confirm Button on the confirmation popup
    public WebElement confirmButtonInPopup;

    @FindBy(how = How.ID, using = "add-button-page")                    //This is the WebElement for the Add Button (used to add new page)
    public WebElement addPageButton;





    //Methods:

    public void clickDeletePageBtn() throws Exception {                 //This is a method to click on the Delete Button
        deletePageButton.click();
    }

    public void waitForPopup() throws Exception{                             //This is a method to wait for the confirmation popup to appear using the WebDriverWait class
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='modal-legacy confirmation-dialog ']")));
    }

    public void clickAddPageBtn() throws Exception{                      //This is the method to Click the Add Page Button
        addPageButton.click();
        System.out.println("Created New Page");
    }

    public void clickConfirmBtnInPopup() throws Exception{               //This method clicks on the Confirm Button the confirmation popup
        confirmButtonInPopup.click();
        System.out.println("Page Deleted");
    }


}

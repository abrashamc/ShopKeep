package IPadLayout.PageTabs;

import methods.CommonMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * Created by abra on 4/12/17.
 */
public class IPadLayoutPageTabs extends CommonMethods {      //This class contains all the WebElements and Methods for the Page Tabs located at the bottom of the iPad Layout section.


    //Web Elements:

    @FindBy(how = How.ID, using = "add-button-page")         //This is the WebElement for the Add Button (used to add new page)
    public WebElement addPageButton;

    @FindBy(xpath = "//div[@id='button-page-tabs']/a[2]")    //This is the WebElement for the first Page Tab
    public WebElement firstPageTab;

    @FindBy(xpath = "//div[@id='button-page-tabs']/a[3]")    //This is the WebElement for the second Page Tab
    public WebElement secondPageTab;

    @FindBy(how = How.ID, using = "button-page-name")        //This is the WebElement for the Page Name field(used to name pages)
    public WebElement pageNameField;






    //Methods:

    public void typeSnacksInPageNameField() throws Exception{   //This method types 'Snacks' in the page name field
        pageNameField.click();
        pageNameField.clear();
        pageNameField.sendKeys("Snacks");
        pageNameField.sendKeys(Keys.ENTER);
    }

    public void typeDrinksInPageNameField() throws Exception{   //This method types 'Drinks' in the page name field
        pageNameField.click();
        pageNameField.clear();
        pageNameField.sendKeys("Drinks");
        pageNameField.sendKeys(Keys.ENTER);
    }

    public void clickAddPageButtn() throws Exception{           //This is the method to Click the Add Page Button
        addPageButton.click();
        System.out.println("Created New Page");
    }

    public void dragAndDropSnacksPageTabWithDrinksPageTab() throws Exception{    //This method drags the first tab and switches it with the second tab
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(firstPageTab)
                .moveToElement(secondPageTab)
                .release(firstPageTab)
                .build();
        dragAndDrop.perform();

    }
}

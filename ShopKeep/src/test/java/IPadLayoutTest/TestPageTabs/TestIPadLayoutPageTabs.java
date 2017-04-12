package IPadLayoutTest.TestPageTabs;

import IPadLayout.PageTabs.IPadLayoutPageTabs;
import methods.CommonMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by abra on 4/12/17.
 */
public class TestIPadLayoutPageTabs extends CommonMethods {                  //This class contains all the tests related to the Page Tabs in the iPad Layout section

    public IPadLayoutPageTabs testPageTabs() throws Exception{               //ACTIVATES ELEMENTS FROM IPadLayoutPageTabs Class
        return PageFactory.initElements(driver, IPadLayoutPageTabs.class);
    }

    @Test(priority = 1)
    public void dragAndDropPageTab() throws Exception{                       //DRAGS AND SWAPS THE POSITION OF TWO PAGE TABS
        shopKeepLogin();
        testPageTabs().clickAddPageButtn();                                  //Clicks on the Add Page Button. The method is being called from the IPadLayoutPageTabs class
        testPageTabs().typeSnacksInPageNameField();                          //Types 'Snacks' in Page Name Field. The method is being called from the IPadLayoutPageTabs class
        testPageTabs().clickAddPageButtn();                                  //Clicks on the Add Page Button. The method is being called from the IPadLayoutPageTabs class
        testPageTabs().typeDrinksInPageNameField();                          //Types 'Drinks' in Page Name Field. The method is being called from the IPadLayoutPageTabs class
        testPageTabs().dragAndDropSnacksPageTabWithDrinksPageTab();          //Clicks on Snacks page tab and switches with the Drinks page tab. The method is being called from the IPadLayoutPageTabs class
    }
}

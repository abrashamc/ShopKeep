package IPadLayoutTest.TestSearchField;

import IPadLayout.SearchBar.IPadLayoutSearchBar;
import methods.CommonMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by abra on 4/12/17.
 */
public class TestIPadLayoutSearchField extends CommonMethods {               //This class contains all the tests related to the Search field in the iPad Layout section



    public IPadLayoutSearchBar testSearchField() throws Exception{           //ACTIVATING ELEMENTS FROM IPadLayoutSearchBar Class
        return PageFactory.initElements(driver, IPadLayoutSearchBar.class);
    }



    @Test(priority = 1)
    public void searchPresent() throws Exception{                            //CHECKS IF THE SEARCH FIELD IS PRESENT
        shopKeepLogin();
        Assert.assertTrue(testSearchField().searchField.isDisplayed());      //Validates that the Search Field is displayed on the page. Web Element called from IPadLayoutSearchBar class
    }


    @Test(priority = 2)
    public void searchBagel() throws Exception {                              //SEARCHES FOR BAGEL IN THE SEARCH FIELD
        shopKeepLogin();
        testSearchField().bagelSearch();                                      //Types 'Bagel' into the search field. Methods called from IPadLayoutSearchBar class
        Assert.assertTrue(testSearchField().bagelItem.isDisplayed());         //Validates 'Bagel' being displayed on the list of items. Web Element called from IPadLayoutSearchBar class
        captureScreenshot(driver,"BagelSearch");               //Captures Screenshot of the searched item (Added to ShopKeepAutomation/ShopKeep/screenshots). Method called from CommonMethods class
    }



    @DataProvider(name = "Products")                                          //Using TestNG DataProvider Annotation to search for all items on the list
    public Object[][] createData(){
        return new Object[][]{
                {"Bagel"} ,
                {"Coffee"} ,
                {"Coffee Beans"} ,
                {"Donut"} ,
                {"French Press"} ,
                {"Latte"} ,
                {"Misc Non-Taxable"} ,
                {"Misc Taxable"} ,
                {"Muffin"} ,
                {"Novelty Mug"} ,
                {"Shipping"} ,
        };
}

    @Test(dataProvider = "Products")
    public void searchAllItems(String data) throws Exception {               //SEARCHES ALL ITEMS USING DATA PROVIDER
        testSearchField().shopKeepLogin();
        testSearchField().searchField.sendKeys(data);                        //Types item names into the search field. Web Element called from IPadLayoutSearchBar class
        if (testSearchField().searchedItem.isDisplayed()) {                  //Verifies if the item being searched is available
            System.out.println(data + " available");
        }
    }



}

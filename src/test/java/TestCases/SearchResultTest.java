package TestCases;

import Base.BaseClass;
import PageObjects.IndexofDashboad;
import PageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultTest extends BaseClass {
    IndexofDashboad indexpage;
    SearchResultPage searchresult;

    @BeforeMethod
    public void IndexPageTest() {


        launchApp();
    }


    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }


    }
    @Test
    public void Productsearchavailbility(){
        indexpage= new IndexofDashboad();
      searchresult = indexpage.searchproduct("Marvo KM409 Wired Gaming Keyboard & Mouse Combo");

      // Here we will check whether the product is available or not
    boolean result=  searchresult.productAvailablity();
        Assert.assertTrue(result);

    }


}

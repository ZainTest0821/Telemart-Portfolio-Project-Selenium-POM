package TestCases;

import Base.BaseClass;
import PageObjects.AddtoCartPage;
import PageObjects.IndexofDashboad;
import PageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddtocartTest extends BaseClass {
    IndexofDashboad indexpage;
    SearchResultPage searchresult;
    AddtoCartPage addtocart;

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
    public void addtoCart() throws InterruptedException {
        indexpage= new IndexofDashboad();
        // Search the product from search bar and click on it
       searchresult= indexpage.searchproduct("Marvo KM409 Wired Gaming Keyboard & Mouse Combo");
       addtocart= searchresult.clickonProduct();
       //click on + button to increase quantity
       addtocart.enterQuantity();
       // Add to cart the product
       addtocart.setAddtocartart();

       Thread.sleep(3000);

       // Validate add to cart button and click on it from header
        addtocart.haddtocart();
        Thread.sleep(3000);

        // Now validate the searched product in add to cart screen
       boolean result =addtocart.verifyaddtocart();
       Assert.assertTrue(result);

    }

}

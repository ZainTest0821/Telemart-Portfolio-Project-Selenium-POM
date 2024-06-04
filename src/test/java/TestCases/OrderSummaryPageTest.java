package TestCases;

import Base.BaseClass;
import PageObjects.*;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderSummaryPageTest extends BaseClass {

    IndexofDashboad indexpage;
    SearchResultPage searchresult;
    AddtoCartPage addtocart;
    LoginPage loginPage;
    HomePage homepage;
    OrderPage orderPage;
    OrderSummary orderSummary;


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
    public void verifyordersummarypage() throws InterruptedException {

        indexpage= new IndexofDashboad();
        loginPage= indexpage.clickonsignin();
        orderSummary = new OrderSummary();


        // Login action is called from LoginPage class and it will return homepage
        homepage =loginPage.loginaction(prop.getProperty("username"), prop.getProperty("password"));

        // Some wait so, page can visibile properly

        Thread.sleep(5000);


        // Search the product after login and click on search button
        searchresult= indexpage.searchproduct("Marvo KM409 Wired Gaming Keyboard & Mouse Combo");
        searchresult.searchbutton();

        addtocart= searchresult.clickonProduct();
        //click on + button to increase quantity
        addtocart.enterQuantity();
        // Add to cart the product
        addtocart.setAddtocartart();

        Thread.sleep(3000);

        // Validate add to cart button and click on it from header
        addtocart.haddtocart();
        Thread.sleep(3000);

        //Click on checkoutbutton/Continue button
        orderPage =addtocart.checkout();

        // We have intalize the order summary object above, before using any page object make sure to iniatlize it first. Like we have inatlize it above in the start of '@Test'
       boolean result= orderSummary.verifyordersummarypag();
       Assert.assertTrue(result);




    }


}

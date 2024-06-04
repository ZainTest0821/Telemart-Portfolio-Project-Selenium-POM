package TestCases;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.IndexofDashboad;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    // Because to reach on this page we want login, that is located on IndexPage , so we have to intalized it on first
    IndexofDashboad indexpage;
    LoginPage loginpage;
    HomePage homePage;


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
    @Test(priority = 1)
    public void verifywishlist(){
        indexpage= new IndexofDashboad();
        loginpage= indexpage.clickonsignin();
       homePage=  loginpage.loginaction(prop.getProperty("username"), prop.getProperty("password"));

       // And in Homepage we have a method , validate wishlist, and it will return boolen result, and here we will use assertion
        // and because the orderlist and wishlist is appeared after clicking on signin button, so we have to click on it again
        homePage.clickonsignin();
       boolean result=  homePage.validateWishlist();
        Assert.assertTrue(result);

    }

    @Test(priority = 2)
    public void verifyorderlist(){
        indexpage= new IndexofDashboad();
        loginpage= indexpage.clickonsignin();
        homePage=  loginpage.loginaction(prop.getProperty("username"), prop.getProperty("password"));

        // And in Homepage we have a method , validate wishlist, and it will return boolen result, and here we will use assertion
        // and because the orderlist and wishlist is appear after clicking on signin button, so we have to click on it again
        homePage.clickonsignin();
        boolean result=  homePage.validateOrderList();
        Assert.assertTrue(result);

    }
}

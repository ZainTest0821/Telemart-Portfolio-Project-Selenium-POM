package TestCases;

import ActionDriver.Action;
import Base.BaseClass;
import PageObjects.IndexofDashboad;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexPage extends BaseClass {
    //Because we don't have connection between Page objects and Test classes so we will first create a object of that class. Like here we have index page class. Here down we will declaree the IndexPageDashboard
    IndexofDashboad indexPage;

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
    public void verifylogo() throws InterruptedException {
        indexPage= new IndexofDashboad();

        // Now here we want to use Fluent wait from Actionclass. So that's why we do this, we also made some changes and create getLogoElement method in IndexofDashboard Class
        WebElement element= indexPage.getLogoElement();
        Action.waitForElementToBeVisible(element,10);

        // here we will validate the logo
        boolean result = indexPage.validatelogo();
        // Now here we will use assertion.Because without validation our test is nothing

        Assert.assertTrue(result);

    }
    @Test

    public void verifytitle(){
        // Now here we will verify the title and it will be in String
        String actualtitle= indexPage.gettitle();
        // The title is get from source of the page that can be access through ( Right-click on the page and click on 'View Source of the Page' then there you will get the title of the page )
        Assert.assertEquals(actualtitle,"Online Shopping in Pakistan |Mobiles, Fashion, Electronics-Telemart.pk");
    }



}

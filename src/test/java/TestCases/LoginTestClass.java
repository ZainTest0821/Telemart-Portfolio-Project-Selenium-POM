package TestCases;

import ActionDriver.Action;
import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.IndexofDashboad;
import PageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.tab;

public class LoginTestClass extends BaseClass {
    IndexofDashboad indexPage;
    LoginPage loginPage;
    HomePage homepage;

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
    public void login() throws InterruptedException {

        indexPage= new IndexofDashboad();
        //Click on Signin button from Index Page and using wait
        // Perform login action
        loginPage= indexPage.clickonsignin();


        // Login action is called from LoginPage class and it will return homepage
       homepage =loginPage.loginaction(prop.getProperty("username"), prop.getProperty("password"));


       // Now here we will verify the home Page Url
       String validateURL= homepage.getURl();
       String expectedURL= "https://telemart.pk/";
        Assert.assertEquals(validateURL,expectedURL);


    }
}

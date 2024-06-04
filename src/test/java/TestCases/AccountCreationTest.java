package TestCases;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.IndexofDashboad;
import PageObjects.LoginPage;
import PageObjects.SignupPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountCreationTest extends BaseClass {
    IndexofDashboad indexpage;
    LoginPage loginpage;
    SignupPage signup;


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
    public void verifyAccountCreation() throws InterruptedException {
        indexpage= new IndexofDashboad();
        // So when we click on signin it will return login page
        loginpage= indexpage.clickonsignin();

        // From login page, we will call create new account, and then we will validate the Signup page navigation on Signup screen and we will also use assertion for this process
        signup=loginpage.createanewAccount();
        boolean result = signup.validateSignupPagenavigation();
        Assert.assertTrue(result);

    }


}

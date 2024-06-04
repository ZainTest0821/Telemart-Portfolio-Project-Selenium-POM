package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends BaseClass {

    // Now we have to intialize the constructor
    public SignupPage(){
        PageFactory.initElements(driver,this);

    }





    //Due to short time, here we will only verify that the user navigate to Account creation page

    // Here we can check the account header text or something that can be make sure this is signup page

    @FindBy(xpath = "//*[@class='text-sm text-center cursor-pointer text-blue-500 roboto-new font-medium']")
    WebElement signupPageTitle;




    //Now we will validate that User navigate to Account Creation/Signup Page

    public boolean validateSignupPagenavigation(){
       return Action.isDisplayed(driver, signupPageTitle);


    }


}

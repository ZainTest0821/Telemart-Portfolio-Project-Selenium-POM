package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    // Now here we will again initalize the constructor, so we can use it again

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }





    // Find elements on LoginPage

    // Email
    @FindBy(id="email")
    WebElement email;

    // Password
    @FindBy( id="password")
    WebElement password;


    // login button

    @FindBy(xpath = "//*[@class='focus:outline-none flex-shrink-0 text-white text-base roboto-new font-normal bg-orange-600 py-3 rounded-sm font-medium shadow-lg uppercase w-full mt-3']")
    WebElement loginbtn;


    // SingUp button

    @FindBy(xpath = "//*[@class='cursor-pointer text-center flex-shrink-0 text-base mt-4 roboto-new font-medium bg-white-600 text-blue-600 shadow-lg py-3 rounded w-full']")
    WebElement signupbtn;


//   // Signup Email
//    @FindBy(id= "email")
//    WebElement signupEmailbox;
//
//    // Signup Phone
//    @FindBy(id="phone")
//    WebElement signupPhone;







    // Now do some User Actions on this page
    // try to Log in

    public HomePage loginaction(String username, String paswrd){
        //Enter type method which is call from Action Class, make sure if we do not static of function in Actionclass, then it cannot be used in anotherclass, Make sure the function you are calling from ActionClass should be static, (public static void )

        Action.type(email,username);
        Action.type(password,paswrd);
        //After entering email and password we need to click on Signin button then by clickng on Signin button we will be navigated to HomePage screen
        Action.click(loginbtn);
        return new  HomePage();

    }

    // Now we have also buttoned for Signup
    //to create a nw account
    public SignupPage createanewAccount(){
        Action.click(signupbtn);

        // Now here when we click on Signup button it will be redirected to Account Creation page
        return new SignupPage();


    }


}

package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {


    // Now we have to intalize it as constructor thus we can use it in another class

    public HomePage(){
        PageFactory.initElements(driver,this);
    }




    // Now after login we have homepage
   // delobor447@picdv.com , testing01122

    //Signin button after login
    @FindBy(xpath = "//*[@class='cursor-pointer signIn-button inline-block px-4 leading-none text-white text-xs font-normal roboto-new']")
    WebElement signinbtn;


    //Here we have to check our Wishlist
    @FindBy(xpath = "//*[@class='cursor-pointer flex items-center']")
    WebElement wishlist;

    //Check OrderList
    @FindBy(xpath = "//*[@class='cursor-pointer flex text-gray-700 hover:text-gray-900 items-center']")
    WebElement orderlist;






    // Now we will do some User's Action

    public boolean validateWishlist(){
        Action.waitForElementToBeVisible(wishlist,10);
       return Action.isDisplayed(driver,wishlist);

    }
    // OrderList
    public boolean validateOrderList(){
        Action.waitForElementToBeVisible(orderlist,10);
        return Action.isDisplayed(driver,orderlist);
    }


    public String getURl(){
        String homePageUrl =driver.getCurrentUrl();
        return homePageUrl;
    }

    // Here we have to click on profile button again to show the dropdown
    public void clickonsignin(){
        Action.click(signinbtn);

    }


}

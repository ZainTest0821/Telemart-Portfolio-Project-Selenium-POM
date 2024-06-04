package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends BaseClass{

    // Now we have to create a instructor
    public OrderSummary(){
        PageFactory.initElements(driver, this);
    }

    // Now here we have to validate different  button's locators

    // First make sure we are at 'Order Summary Page"
    @FindBy(xpath = "//*[@class='roboto-new text-sm font-medium  py-1']")
    WebElement verifyordersummarypage;

    //Here we have to validate the button " Deliver Here" which will be avaialbe after clicking on 'Continue button from Add to cart screen

    @FindBy(xpath = "//*[@class='focus:outline-none mt-2 ml-10 text-xs text-normal roboto-new font-bold px-6 bg-orange-600 text-white rounded-sm py-3']")
    WebElement deliverhere;



    //  Now perforom Action

    public boolean verifyordersummarypag(){
        Action.waitForElementToBeVisible(verifyordersummarypage, 10);


        return Action.isDisplayed(driver,verifyordersummarypage);
    }


    // Click on 'Deliver Here'
    public void deliverhere(){
        Action.click(deliverhere);

    }

}

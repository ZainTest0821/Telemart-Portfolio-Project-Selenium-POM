package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartPage extends BaseClass {


    // Now we need constructor to intalized all the class
    public AddtoCartPage(){
        PageFactory.initElements(driver,this);
    }





    // Here we will target the AddtoCart screen elements and there actions

    //Takaful locator
    @FindBy(xpath = "//*[@class='border-2 border-gray-100 cursor-pointer focus:outline-none font-medium h-10 roboto-new shadow-md text-gray-500 text-xs w-40']")
    WebElement takalfuldropdown;

    // Quantity adding locator
    @FindBy(xpath = "//*[@class='focus:outline-none roboto-new cursor-pointer font-medium']")
    WebElement quantitybtn;


    // Add to Cart button
    @FindBy(xpath = "//*[@class='addToCart uppercase disabled:opacity-50']")
    WebElement addtocart;


    // Add to cart header button
    @FindBy(xpath = "//*[@class='inline-block px-4 leading-none text-white text-xs font-normal roboto-new']")
    WebElement addtocart2;


    //Verfiy user is at add to cart page
    @FindBy(xpath = "//*[@class='text-lg py-1 roboto-new']")
    WebElement verifyAddToCart;


    // Verify checkoutbtn

    @FindBy(xpath = "//*[@class='rounded-sm bg-orange-600 roboto-new text-white text-sm shadow font-medium px-16 py-4 uppercase']")
    WebElement checkoutbtn;

    // Search button which is available at search bar
    @FindBy(xpath = "//*[@class='focus:outline-none flex items-center roboto-new  leading-normal bg-orange-400 bg-hover-orange-500 rounded-r-sm px-4 text-grey-dark text-xl']")
    WebElement searchbutton;







    // Now do some user Action

    // Here we will enter Quantity
    public void enterQuantity(){
        Action.click(quantitybtn);

    }

    //Now we have to set Takaful
    public void takaful(String tkaful){
        Action.selectByVisibleText(tkaful, takalfuldropdown);

    }

    // Click on Add to cart

    public void setAddtocartart( ){

        Action.click(addtocart);
    }

    //  Now click on Add to cart header button when the product is added in cart
    public void haddtocart(){
        Action.click(addtocart2);
    }


    // Verify that user is at add to cart screen
    public boolean verifyaddtocart(){
       return Action.isDisplayed(driver,verifyAddToCart);


    }


    // Now click on Checkout/Continue button and here we use JS click


    public OrderPage checkout(){
        Action.click(checkoutbtn);
        return new OrderPage();
    }

    
}

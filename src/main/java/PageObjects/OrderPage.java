package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {
    // Now we have to intalized this constructor
    public OrderPage(){
        PageFactory.initElements(driver,this);
    }



    // We will validate the price

    @FindBy(xpath ="//span[text()='Rs. 3,799']")
    WebElement unitPrice;


    // Verify checkoutbtn

    @FindBy(xpath = "//*[@class='rounded-sm bg-orange-600 roboto-new text-white text-sm shadow font-medium px-16 py-4 uppercase']")
    WebElement checkoutbtn;






    //Now we will use some methods to get and verify the price

    public double verifyprice(){
        String unitprice1 =unitPrice.getText();
        //Now here we will remove all the chracter if we have in price section
        String unit= unitprice1.replaceAll("[^a-zA-Z0-9]", " ");
        // Now we will change string into double
        double finalunitprice= Double.parseDouble(unit);

        // if we remove all the value like., and other special characters, so we can use the given code. Like if we have an value of (16.15), And with the above replace code we remove all the special character from price, so we have to divid all the price by '100'. So we will get actaul price.

        return finalunitprice/100;

    }

    // Now we will click on Continue/ Checkout button
    public AddressPage checkoutbutton(){
        Action.click(checkoutbtn);
        return new AddressPage();
    }


}

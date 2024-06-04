package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {

    // Now we will intialized the constructor
    public PaymentPage(){
        PageFactory.initElements(driver,this);

    }




    // Click on Continue that appear after address
    @FindBy(xpath = "//button[contains(., 'CONTINUE')]")
    WebElement continuebtn;

    //Select payment methd
    @FindBy(id = "1payment")
    WebElement selectpaymentmethd;


    //Plac Order btn
    @FindBy(xpath = "//button[contains(., 'Place Order')]")
    WebElement placeorder;






    // Do some user action, click on continue button
    public void clickoncontinuebtn(){
        Action.click(continuebtn);
    }


    //Select Payment method, here we will select Cash on delivery
    public void selectpayment(){
        Action.click(selectpaymentmethd);

    }

    // Place an order
    public void placeordr(){
        Action.click(placeorder);
    }

}

package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {



    // Intalizie this constructor
    public AddressPage(){
        PageFactory.initElements(driver,this);
    }





    //continue or checkout
    @FindBy(xpath = "//*[@class='rounded-sm bg-orange-600 roboto-new text-white text-sm shadow font-medium px-16 py-4 uppercase']")
    WebElement checkoutbtn;

    // Add new address
    @FindBy(xpath = "//*[@class='cursor-pointer text-blue-700 py-2 font-bold roboto-new text-sm']")
    WebElement addnewadressbtn;


    // Adress box
    @FindBy(id="address")
    WebElement addressbox;


    // City dropdown
    @FindBy(xpath = "//input[@placeholder='Please select City']")
    WebElement citydropdown;


    // Save and Continue
    @FindBy(xpath = "//*[@class='cursor-pointer ml-10 flex-shrink-0 focus:outline-none roboto-new font-bold bg-orange-600 border-orange-600 text-sm  text-white h-12 mt-4 w-80 rounded-sm']")
    WebElement saveContinue;







    // Click on contiune or checkout button
    public void checkout(){
        Action.click(checkoutbtn);

    }

    // Click on Add new address
    public void addnewaddress(){
        Action.click(addnewadressbtn);

    }

    // Click and send value in Address box
    public void addressbox2(String text){
        Action.type(addressbox,text);

    }

    //Click on Citydrop down
    public void selectcity(String text){
        Action.selectByVisibleText(citydropdown,text);
    }

    // Click on save&Continue button
    public PaymentPage saveandcontinue(){
        Action.click(saveContinue);
        return new PaymentPage();
    }





}


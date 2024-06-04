package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexofDashboad extends BaseClass {


    // Now we will inialized this class as constructor to use in other classes
    public IndexofDashboad() {
        PageFactory.initElements(driver, this);
    }





    // Signin Button
    @FindBy(xpath = "//*[@class='signIn-button cursor-pointer inline-block px-4 leading-none text-white text-xs font-normal roboto-new']")
    WebElement signinbtn;


    // Add to Cart icon button
    @FindBy(xpath = "//a[@class='inline-block px-4 leading-none text-white text-xs font-normal roboto-new']")
    WebElement addtocart;


    // Searchbox button

    @FindBy(id = "search-box")
    WebElement searchbtn;


    // Search btn icon
    @FindBy(xpath = "//*[@class='focus:outline-none flex items-center roboto-new  leading-normal bg-orange-400 bg-hover-orange-500 rounded-r-sm px-4 text-grey-dark text-xl']")
    WebElement searchbtnicon;


    // Website logo

    @FindBy(xpath = "//*[@class='router-link-exact-active router-link-active']")
    WebElement logo;


    // Telemart store ( Header Btn)
    @FindBy(xpath = "//*[@class='text-xs text-white font-normal tracking-wider top-bar roboto-new'][2]")
    WebElement telemartstore;


    // Apply for Franchise (Header's btn)

    @FindBy(xpath = "//*[@class='text-xs text-white font-normal tracking-wider top-bar roboto-new'][3]")
    WebElement applyforfranc;




    // Now do some User Actions

    public LoginPage clickonsignin() {
        //Here we have used JavaScript click, becaue simple click is not working
        Action.JSClick(driver, signinbtn);

        //Now when we click on signin button then we have to make connection with that page which comes after clicking on signin button. Here the Login Page appear, so we will create the connection between them.

        return new LoginPage();
    }


        // Now validate the logo
    public boolean validatelogo() {

        return Action.isDisplayed(driver,logo);
    }

    // Now here we will use another method so that we can use Fluent wait... in Indexpage TestClass
    public WebElement getLogoElement(){
        return logo;
    }




    // Now try to get the title of Website
    public String gettitle(){
        String storeTittle = driver.getTitle();
        return storeTittle;


    }
    // Do search operation
    public SearchResultPage searchproduct(String productName){
        Action.type(searchbtn, productName );
        //  Now we have to click on searchbutton
        Action.click(searchbtnicon);

        // Now after search it will navigate to search result page
        return new SearchResultPage();
    }



    }


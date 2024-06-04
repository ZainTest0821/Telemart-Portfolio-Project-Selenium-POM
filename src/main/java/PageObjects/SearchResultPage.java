package PageObjects;

import ActionDriver.Action;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {


    // Now we have to intialized this constructor
    public SearchResultPage(){
        PageFactory.initElements(driver, this);
    }




    // Now here we will check the search result page

    // Searched Product
    @FindBy(xpath = "//*[@class='mt-2 text-gray-600 hover:text-blue-600 roboto-new font-normal leading-tight product-title-size text-ellipsis']")
    WebElement searchedProduct;







    // Now we have to check availablity of product

    public boolean productAvailablity(){
       return Action.isDisplayed(driver, searchedProduct);

    }

    //Search button click
    public void searchbutton(){
        Action.click(searchedProduct);
    }



    // Check the return on Add to cart Page
    public AddtoCartPage clickonProduct(){
        Action.click(searchedProduct);
        return new AddtoCartPage();
    }
}

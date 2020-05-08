package Pages;

import HelperClasses.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FindMortgageCalcResultsPage extends BasePage
{
    //Constructor - not required as it inherits from BasePage

    //Element Locators
    private final By numberOfProductsLocator = By.className("no-products");


    //Methods
    public int GetNumberOfProducts()
    {
        int noOfProducts = getProducts();

        //Sometimes it will display briefly as zero before filling in the required amount
        for (int index =0;index<10;index++)
        {
            if (noOfProducts == 0)
            {
                Driver.MyDriver.pause(1000);
                noOfProducts = getProducts();
            }

        }

        return  noOfProducts;
    }
    private int getProducts()
    {
        String noProductsText = GetVisibleElementByLocator(numberOfProductsLocator, Driver.MyDriver.driver).getText();
        return Integer.parseInt(noProductsText);

    }

}

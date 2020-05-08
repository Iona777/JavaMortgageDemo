package Pages;

import HelperClasses.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import HelperClasses.Driver.MyDriver;


public class MortgageCalcResultsPage extends BasePage
{
    //Constructor - not required, inherits from BasePAge

    //Elements
    private final By offerAmountLocator = By.className("borrow-result");

    //Methods
    public Boolean CheckOfferAmount(String expectedAmount)
    {
        String text = getAmount();
        for (int index =0;index<10;index++)
        {
            //Sometimes it will display briefly as zero before filling in the required amount
            try
            {
                Assert.assertEquals(expectedAmount,text);
                break;
            }
           catch (Exception e)
            {
                Driver.MyDriver.pause(1000);
                text = getAmount();
            }
        }

        return (text.equals(expectedAmount));

    }


    private String getAmount()
    {
        String text = GetVisibleElementByLocator(offerAmountLocator,MyDriver.driver).getText().trim();
        text = text.replace("£","");
        return text;
    }

}



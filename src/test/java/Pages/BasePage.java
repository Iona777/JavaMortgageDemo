package Pages;

import HelperClasses.ConfigHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage
{
    //By setting these here, Base Page does not need to go to Driver class  each time
    protected int BaseTimout;
    protected String BaseURL;

    public BasePage()
    {
        ConfigHelper config = new ConfigHelper();
        BaseURL = config.getProperty("baseUrl");
        BaseTimout = Integer.parseInt(config.getProperty("defaultTimeout")) ;
    }

    //Methods

    //Overloaded so that we can either specify the timeout seconds or take default
    //Would use nullable element in C#, but not available in Java
    public WebElement GetElementByLocator(By elementLocator, WebDriver driver)
    {
        int seconds = BaseTimout;
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return  wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    public WebElement GetElementByLocator(By elementLocator, int waitSeconds, WebDriver driver)
    {
        int seconds = waitSeconds;
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return  wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));

    }

    //Overloaded so that we can either specify the timeout seconds or take default
    public WebElement GetClickableElementByLocator(By elementLocator, int waitSeconds,WebDriver driver)
    {

        int seconds = waitSeconds;
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public WebElement GetClickableElementByLocator(By elementLocator,WebDriver driver)
    {

        int seconds = BaseTimout;
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }



    //Overloaded so that we can either specify the timeout seconds or take default
    public WebElement GetVisibleElementByLocator(By elementLocator, int waitSeconds,WebDriver driver)
    {

        int seconds = waitSeconds;
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public WebElement GetVisibleElementByLocator(By elementLocator,WebDriver driver)
    {

        int seconds = BaseTimout;
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    //Overloaded so that we can either specify the timeout seconds or take default
    public WebElement GetElementByVisibleText(String searchText, int waitSeconds,WebDriver driver)
    {
        int seconds = waitSeconds;
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'" + searchText + "')]")));

    }

    public WebElement GetElementByVisibleText(String searchText,WebDriver driver)
    {
        int seconds = BaseTimout;
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'" + searchText + "')]")));
    }

    public void ClickOnElement(By elementLocator, WebDriver driver)
    {
        GetClickableElementByLocator(elementLocator, driver).click();
    }

    public void EnterText(By elementLocator, String value, Boolean clear, WebDriver driver)
    {
        WebElement element = GetClickableElementByLocator(elementLocator,driver);
        if (clear.equals(true))
            element.clear();

        element.sendKeys(value);
    }

    public void  SelectDropDownOptionByValue(WebElement dropDown, String value )
    {
        Select selector = new Select(dropDown);
        selector.selectByValue(value);
    }

    public boolean IsElementDisplayed(By by, int waitSeconds, WebDriver driver)
    {
        try
        {
            return GetVisibleElementByLocator(by, waitSeconds, driver).isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }

}

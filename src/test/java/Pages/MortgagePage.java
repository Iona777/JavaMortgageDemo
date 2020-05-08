package Pages;

import HelperClasses.Driver.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MortgagePage extends BasePage
{

    //Elements
    private final By locationDropdownLocator = By.id("applicants_address");
    private final By numberOfApplicantsDropdownLocator = By.id("applicants_number");
    private final By numberOfDependantsDropdownLocator = By.id("dependants");

    private final By annualIncomeFieldLocator = By.id("income1");
    private final By annualBonusFieldLocator = By.id("bonus1");
    private final By monthlyDebtFieldLocator = By.id("monthly_outgoings1");
    private final By calculateHowMuchButtonLocator = By.id("lnkButHowMuch");

    private final By findMortgageTabLocator = By.id("findTab");

    private final By customerTypeDropdownLocator = By.id("customer_type");
    private final By amountOfDepositFieldLocator = By.id("deposit_size");
    private final By propertyValueFieldLocator = By.id("property_value");
    private final By repaymentTermDropdownLocator = By.id("repayment_term");
    private final By calculateFindButtonLocator = By.id("lnkButFind");



    //Methods
    public void GoToMortgagePage()
    {
        String mortgagePageURL = BaseURL;
        MyDriver.navigateTo(mortgagePageURL);
        MyDriver.pause(2000);
    }

    public Boolean CheckPageHeading()
    {
        String heading = GetElementByLocator(By.tagName("h1"),MyDriver.driver).getText();
        return heading.equals("Mortgages");
    }

    public void ClickOnMortgageReason(String reasonText)
    {
        GetElementByVisibleText(reasonText, MyDriver.driver).click();
    }

    public void ClickOnFindMortgageTab()
    {
        GetClickableElementByLocator(findMortgageTabLocator,MyDriver.driver).click();
    }

    public void EnterFindAMortgageDetails(String customerType, String deposit, String propertyValue, String term)
    {
        //Dropdown elements. Select used for drodowns requires a WebElement
        WebElement customerTypeDropdown = GetElementByLocator(customerTypeDropdownLocator,MyDriver.driver);
        WebElement repaymentTermDropdown = GetElementByLocator(repaymentTermDropdownLocator, MyDriver.driver);

        SelectDropDownOptionByValue(customerTypeDropdown,customerType);
        EnterText(amountOfDepositFieldLocator, deposit,true, MyDriver.driver);
        EnterText(propertyValueFieldLocator, propertyValue,true,MyDriver.driver);
        SelectDropDownOptionByValue(repaymentTermDropdown,term);

        //This is just here to let the user see the screen for this demo. Otherwise it is too fast too see.
        MyDriver.pause(2000);

    }


    public void EnterHowMuchICanBorrowDetails(String location, String applicants, String dependants, String income, String bonus, String debt)
    {
        //Dropdown elements. Select used for drodowns requires a WebElement
        WebElement locationDropdown = GetElementByLocator(locationDropdownLocator,MyDriver.driver);
        WebElement applicantsDropdown = GetElementByLocator(numberOfApplicantsDropdownLocator,MyDriver.driver);
        WebElement dependantsDropdown = GetElementByLocator(numberOfDependantsDropdownLocator,MyDriver.driver);

        SelectDropDownOptionByValue(locationDropdown, location);
        SelectDropDownOptionByValue(applicantsDropdown, applicants);
        SelectDropDownOptionByValue(dependantsDropdown, dependants);

        EnterText(annualIncomeFieldLocator, income, true, MyDriver.driver);
        EnterText(annualBonusFieldLocator, bonus, true, MyDriver.driver);
        EnterText(monthlyDebtFieldLocator, debt, true, MyDriver.driver);

        MyDriver.pause(2000);
    }

    public void ClickCalculateHowMuchButton()
    {
        ClickOnElement(calculateHowMuchButtonLocator,MyDriver.driver);
    }

    public void ClickCalculateFindButton()
    {
        ClickOnElement(calculateFindButtonLocator, MyDriver.driver);
    }

}

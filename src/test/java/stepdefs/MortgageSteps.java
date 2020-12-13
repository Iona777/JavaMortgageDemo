package stepdefs;


import HelperClasses.ConfigHelper;
import Pages.*;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;


import static HelperClasses.Driver.MyDriver;
import static HelperClasses.Driver.MyDriver.driver;


public class MortgageSteps
{
    //Class level variables
    private MortgagePage _theMortgagePage;
    private MortgageCalcResultsPage _theMortgageCalcResultsPage;
    private FindMortgageCalcResultsPage _theFindMortgageCalcResultsPage;
    private final String MortgageTitle = "Mortgages | Our best deals & rates | TSB Bank";


    //Constructor
    public MortgageSteps()
    {
        _theMortgagePage = new MortgagePage();
        _theMortgageCalcResultsPage = new MortgageCalcResultsPage();
        _theFindMortgageCalcResultsPage = new FindMortgageCalcResultsPage();
    }

    //The creation of the driver has been moved to BasePage so that it has it available for all its methods, which
    //avoids need to pass in the driver every time they are called.
    //Would do this all as part of Hooks, but Java seems to only use Before/AFter in a Steps/Tets class?
    @Before
    public static void StartBrowser()
    {
         ConfigHelper config = new ConfigHelper();
         MyDriver.getDriver(config.getProperty("browser"));
    }

    @Given("^I have navigated to the mortgage page$")
    public void iHaveNavigatedToTheMortgagePage()
    {
        _theMortgagePage.GoToMortgagePage();
        Assert.assertTrue("Mortgage page heading not as expected",_theMortgagePage.CheckPageHeading());
    }


    @When("^I select a mortgage reason of \"([^\"]*)\"$")
    public void i_select_a_mortgage_reason_of(String reasonText)
    {
        _theMortgagePage.ClickOnMortgageReason(reasonText);
    }

    @And("^I enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String location, String applicants, String dependants, String income, String bonus, String debt)
    {
        _theMortgagePage.EnterHowMuchICanBorrowDetails(location, applicants, dependants, income, bonus, debt);
    }

    @And("^I click on calculate how much I can borrow button$")
    public void iClickOnCalculateHowMuchICanBorrowButton()
    {
        _theMortgagePage.ClickCalculateHowMuchButton();
        //This is just here so user can see what is happening in this demo, otherwise it is too fast too see.
        MyDriver.pause(2000);
    }


    @Then("^the offer amount should be \"([^\"]*)\"$")
    public void the_offer_amount_should_be(String expectedAmount)
    {
        Assert.assertTrue("Check Offer returned false",_theMortgageCalcResultsPage.CheckOfferAmount(expectedAmount));

        //This is just here so user can see what is happening in this demo, otherwise it is too fast too see.
        MyDriver.pause(3000);
    }


    @And("^I click on the Find a Mortgage tab$")
    public void iClickOnTheFindAMortgageTab()
    {
        _theMortgagePage.ClickOnFindMortgageTab();
    }

    @And("^I enter \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", and \"([^\"]*)\" in the find a mortgage tab$")
    public void iEnterAndInTheFindAMortgageTab(String customerType, String deposit, String propertyValue, String term)
    {
        _theMortgagePage.EnterFindAMortgageDetails(customerType, deposit, propertyValue, term);
    }

    @And("^I click on the calculate find a mortgage button$")
    public void iClickOnTheCalculateFindAMortgageButton()
    {
        _theMortgagePage.ClickCalculateFindButton();
        //This is just here so user can see what is happening in this demo, otherwise it is too fast too see.
        MyDriver.pause(2000);
    }

    @Then("^The number of products is greater than zero$")
    public void theNumberOfProductsIsGreatedThanZero()
    {
            Assert.assertTrue("Number of products not > zero",_theFindMortgageCalcResultsPage.GetNumberOfProducts() > 0);
    }


    @After
    public static void StopBrowser()
    {
        driver.quit();
        System.out.println("Browser stopped");
    }



}

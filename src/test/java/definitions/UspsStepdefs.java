package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.*;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UspsStepdefs {
    private String country;

    @Then("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();  //click on Mail & Ship tab

        getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction!input.action')]")).click(); //click on Lookup a Zip code link

        getDriver().findElement(By.xpath("//div[@id='zip-lookup-welcome']//a[contains(@href,'byaddress')][contains(@class,'zip-code-address')]")).click(); //click on the Find by Address button

    }


    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id ='tAddress']")).sendKeys(street); //enter street name

        getDriver().findElement(By.xpath("//input[@id ='tCity']")).sendKeys(city); //enter city

        getDriver().findElement(By.xpath("//select[@id='tState']//option[@value='" +state+ "']" )).click(); //select state

        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();//click on the Find button


    }


    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText().contains(zip));  //verify the expected results

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage(){
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();  //click on Mail & Ship tab
        getDriver().findElement(By.xpath("//div[@class ='container-fluid']//a[contains(text(),'Calculate')]")).click(); //click on Calculate a price link on the usps landing page
    }

    @And("I select {string} with Postcard shape")
    public void iSelectWithPostcardShape(String country) throws InterruptedException {
        Select countrySelect = new Select(getDriver().findElement(By.xpath("//select[@id ='CountryID']"))); //select country Canada
        countrySelect.selectByVisibleText(country);

        getDriver().findElement(By.xpath("//input[@class='submit-panel postcard-button']")).click();//click on the calculate postcard price
        sleep(3000);
    }



    @And("I define {string} quantity")
    public void iDefineQuantity(String qty) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@class='form-control numeric-only']")).sendKeys(qty); //enter the qty
        sleep(3000);
    }
        


    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String Cost) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@class='btn btn-pcalc btn-default']")).click();
        sleep(3000);
        assertThat(getDriver().findElement(By.xpath("//div[@id='cost-0']")).getText().contains(Cost));
    }


    @When("I perform {string} search")
    public void iPerformSearch(String searchValue)  {
        getDriver().findElement(By.xpath("//input[@id='home-input']")).sendKeys(searchValue);// enter the search value "Free Bpxes"
        getDriver().findElement(By.xpath("//div[@class='quicktools-featured ']//button[@class='input--search btn']")).submit();//click on search icon
        //explicit wait
        WebDriverWait wait = new WebDriverWait(getDriver(),15);
        WebElement result = getDriver().findElement(By.xpath("//span[@class='search-results-heading']"));
        wait.until(ExpectedConditions.textToBePresentInElement(result,searchValue));
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterMailShip) throws InterruptedException {
      getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][contains(text(),'Mail & Ship')]")).sendKeys(filterMailShip); //select Mail and Ship filter
        sleep(3000);
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String result) throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//span[@class='search-results-heading']")).getText().contains(result)); //verify with the Mail and Ship as the filter 7 search result get displayed
        sleep(3000);
    }

    @When("I select Priority Mail | USPS in results")
    public void iSelectPriorityMailUSPSInResults() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class='container-fluid']//span[contains(text(),'Priority Mail | USPS')]")).click();//click on the Priority mail link
        sleep(3000);
        
    }

    @And("I click Ship Now button")
    public void iClickShipNowButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@class='button--primary']")).click();
        sleep(3000);
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {

        // switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }


        WebDriverWait wait = new WebDriverWait(getDriver(),15);
        wait.until(ExpectedConditions.titleContains("Sign In"));

        getDriver().findElement(By.xpath("//button[@id='btn-submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='error-username']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='error-password']")));

    }

    @When("I go to Help tab")
    public void iGoToHelpTab() throws InterruptedException {
         WebElement help;
         help = getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'Help')]")); //click on the Help tab
         help.click();
         sleep(3000);
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String helpText) throws InterruptedException {
        sleep(3000);
        getDriver().findElement(By.xpath("//input[@class='search-field input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input']")).sendKeys(helpText);// enter the help text
        sleep(3000);
        getDriver().findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand search-button')]")).click();//click on the search icon
        sleep(3000);
    }


    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String helpText1) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(),20);

        WebElement result1 = getDriver().findElement(By.xpath("//div[contains(@class,'siteforceSldsOneColLayout siteforceContentArea')]"));

        wait1.until(ExpectedConditions.visibilityOf(result1)); // verify if text is not visible in the search

        if (result1.getText().contains(helpText1)){
            System.out.println(helpText1 + " is dispayed in the search results");
        }
        else {
            System.out.println( helpText1 + "not found in the search results");
        }
    }

}

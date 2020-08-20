package definitions;

import cucumber.api.java.en.Given;
import support.TestContext;

import static support.TestContext.*;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) throws InterruptedException {
        getDriver().get("https://skryabin.com/market/quote.html");
        Thread.sleep(2000);
    }
}

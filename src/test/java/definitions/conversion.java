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

import static support.TestContext.getDriver;

public class conversion {
    @When("I navigate to Auto Loan Calculator")
    public void iNavigateToAutoLoanCalculator(){

        WebElement loanCalcLink = getDriver().findElement(By.xpath("//a[contains(text(),'Auto Loan Calculator')]"));
        loanCalcLink.click();
    }
    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields()  {
        getDriver().findElement(By.xpath("//input[@name ='cloanamount']")).clear();

        getDriver().findElement(By.xpath("//input[@name ='cloanterm']")).clear();

        getDriver().findElement(By.xpath("//input[@name ='cinterestrate']")).clear();

        getDriver().findElement(By.xpath("//input[@name ='cdownpayment']")).clear();

        getDriver().findElement(By.xpath("//input[@name ='ctradeinvalue']")).clear();

        getDriver().findElement(By.xpath("//input[@name ='csaletax']")).clear();

        getDriver().findElement(By.xpath("//input[@name ='ctitlereg']")).clear();
    }

    @And("I calculate")
    public void iCalculate()  {
        getDriver().findElement(By.xpath("//input[contains(@src,'//d26tpo4cm8sb6k.cloudfront.net/img/svg/calculate.svg')]")).click();
    }

    @Then("I verify error message for auto price and interest rate")
    public void iVerifyErrorMessageForAutoPriceAndInterestRate() {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), 20);

        WebElement result1 = getDriver().findElement(By.xpath("//font[contains(text(),'Please provide a positive auto price.')]"));
        WebElement result2 = getDriver().findElement(By.xpath("//font[contains(text(),'Please provide a positive interest value.')]"));


        wait1.until(ExpectedConditions.visibilityOf(result1)); // verify if text is not visible in the search
        wait1.until(ExpectedConditions.visibilityOf(result2));

    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest,String downpayment, String tradein, String state, String percentTax,String fees)  {

        getDriver().findElement(By.xpath("//input[@name ='cloanamount']")).sendKeys(price);

        getDriver().findElement(By.xpath("//input[@name ='cloanterm']")).sendKeys(months);

        getDriver().findElement(By.xpath("//input[@name ='cinterestrate']")).sendKeys(interest);

        getDriver().findElement(By.xpath("//input[@name ='cdownpayment']")).sendKeys(downpayment);

        getDriver().findElement(By.xpath("//input[@name ='ctradeinvalue']")).sendKeys(tradein);

        getDriver().findElement(By.xpath("//select[@name='cstate']")).sendKeys(state);

        getDriver().findElement(By.xpath("//input[@name ='csaletax']")).sendKeys(percentTax);

        getDriver().findElement(By.xpath("//input[@name ='ctitlereg']")).sendKeys(fees);


    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String monthPay) {
        assertThat(getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText().contains(monthPay));
        System.out.println(monthPay +" is the monthly pay calculated by the calculator");
    }
}



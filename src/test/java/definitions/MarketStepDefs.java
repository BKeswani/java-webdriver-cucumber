package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import support.TestContext;

import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Thread.*;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) throws InterruptedException {
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "yahoo":
                getDriver().get("https://www.yahoo.com/");
                break;
            case "bing":
                getDriver().get("https://www.bing.com/");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            case "calculator":
                getDriver().get("https://www.calculator.net/");
                break;
            default:
                throw new RuntimeException("Unsupported page! " + page);
        }
        sleep(1000);

    }

    @And("I print page title")
    public void iPrintPageTitle() {
        System.out.println(getDriver().getTitle());
    }

    @And("I print the url")
    public void iPrintTheUrl() {
        System.out.println(getDriver().getCurrentUrl());
    }

    @And("I print the window handle")
    public void iPrintTheWindowHandle() {
        System.out.println(getDriver().getWindowHandle());
    }

    @And("I print the page source")
    public void iPrintThePageSource() {
        System.out.println(getDriver().getPageSource());
    }


    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        sleep(1000);

        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        System.out.println("Logs begin >>>>");

        for (LogEntry log : logs) {
            System.out.println(log);
        }

        System.out.println("Logs end >>>>");
    }


    @And("I go back and forward, then refresh")
    public void iGoBackAndForwardThenRefresh() throws InterruptedException {
        getDriver().navigate().back();
        sleep(2000);

        getDriver().navigate().forward();
        sleep(2000);

        getDriver().navigate().refresh();
        sleep(2000);

    }
    @And("I change resolution to phone")
    public void iChangeResolutionToPhone() throws InterruptedException {

        getDriver().manage().window().setSize(new Dimension(400,768));
        sleep(3000);

    }



    @And("I change resolution to laptop")
    public void iChangeResolutionToLaptop() throws InterruptedException {
        getDriver().manage().window().setSize(new Dimension(1024,768));
        sleep(3000);

    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("BKeswani");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("bkeswani@example.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("password");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Barkha");
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys("M");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Keswani");
        getDriver().findElement (By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        sleep(3000);

    }

    @And("I click on Submit")
    public void iClickOnSubmit() throws InterruptedException {
        WebElement submitButton = getDriver().findElement(By.xpath("//button[@id='formSubmit']"));
        System.out.println(submitButton.getText());
        submitButton.click();
        sleep(3000);
    }

    @Then("I validate the required data")
    public void iValidateTheRequiredData() throws InterruptedException {
        assertThat(getDriver().findElement(By.xpath("//legend[contains(text(),'Submitted')]")).getText()).isEqualTo("Submitted Application");
        System.out.println(getDriver().findElement(By.xpath("//legend[contains(text(),'Submitted')]")).getText());
        assertThat(getDriver().findElement(By.xpath("//b [@name = 'username']")).getText()).isEqualTo("BKeswani");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("bkeswani@example.com");
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo("Barkha M Keswani");
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText()).isEqualTo("true");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText().contains("entered"));
    }


    @When("I fill out incorrect email")
    public void iFillOutIncorrectEmail() throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("bkeswani.com");
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        sleep(2000);

    }


   @Then("error message gets displayed for incorrect email")
    public void errorMessageGetsDisplayedForIncorrectEmail() {
      WebElement myTest1 = (getDriver().findElement(By.xpath("//label[@class='error']")));

           System.out.println("Email Error: " +myTest1.getText());
       }


    @Then("I fill out the email correctly")
    public void iFillOutTheEmailCorrectly() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("bkeswani@example.com");
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        sleep(3000);

        }


    @Then("I swap firstname with lastname")
    public void iSwapFirstnameWithLastname() {
        Map<String,String> custName = new LinkedHashMap<>();
        custName.put("firstName", "John");
        custName.put("middleName", "George");
        System.out.println("Before Swap" );
        System.out.println("Customer Name" + custName);

        System.out.println();
        System.out.println();
        System.out.println("After Swap");

        String temp = custName.get("firstName");
        custName.put("firstName",custName.get("middleName"));
        custName.put("middleName",temp);

        System.out.println("Customer Name" +custName);

    }

    @And("I click {int}rd party agreement and click ok")
    public void iClickRdPartyAgreementAndClickOk(int arg0) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();

        String myTest = getDriver().findElement(By.xpath("//span[@id='thirdPartyResponseMessage']")).getText();
        System.out.println(myTest);
    }

    @And("I click {int}rd party agreement and click cancel")
    public void iClickRdPartyAgreementAndClickCancel(int arg0) {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().dismiss();

        String myTest = getDriver().findElement(By.xpath("//span[@id='thirdPartyResponseMessage']")).getText();
        System.out.println(myTest);
    }


}


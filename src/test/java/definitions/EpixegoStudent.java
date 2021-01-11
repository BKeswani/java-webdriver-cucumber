package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Thread.sleep;
import static support.TestContext.getDriver;


public class EpixegoStudent {

    /*@Given("I navigate to {string} homepage")
    public void iNavigateToHomepage(String page) {

        if ("Epixego".equals(page)) {
            getDriver().get("http://13.56.140.35:8080/");
        } else {
            throw new RuntimeException("Unsupported page! " + page);
        }
    }


    @Then("I click on the Sign-up button")
    public void iClickOnTheSignUpButton() throws InterruptedException {
        getDriver().findElement(By.xpath(("//header/div[1]/div[1]/div[2]/div[1]/div[1]/a[4]/button[1]/span[1]"))).click();
        sleep(2000);
    }


    @Then("I fill out the required data")
    public void iFillOutTheRequiredData() throws InterruptedException {

        getDriver().findElement((By.xpath("//input[@name='email']"))).sendKeys("epixegoauto@gmail.com");

        getDriver().findElement((By.xpath("//input[@name='password']"))).sendKeys("Epixego1234");

        getDriver().findElement((By.xpath("//input[@name='confirmPassword']"))).sendKeys("Epixego1234");

        getDriver().findElement(By.xpath("//input[@name='privacyCheck']")).click();
        sleep(2000);
    }

    @And("I click on Signup button")
    public void iClickOnSignupButton() throws InterruptedException {

        getDriver().findElement(By.xpath("//span[contains(text(),'Sign Up')]")).click();
        sleep(2000);

    }

   @Then("I fill out basic info to create the account")
    public void iFillOutBasicInfoToCreateTheAccount() throws InterruptedException {

       Actions actions = new Actions(getDriver());

        getDriver().findElement(By.xpath("//input[@name='firstname']")).sendKeys("Missy");

       getDriver().findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");

       getDriver().findElement(By.xpath("//input[@name='city']")).sendKeys("San Francisco");

       getDriver().findElement(By.xpath("//input[@name='state']")).sendKeys("California");

       getDriver().findElement(By.xpath("//input[@name='country']")).sendKeys("USA");

       WebElement profession = getDriver().findElement(By.xpath("//div[@id='select-profession']"));
       profession.click();
       WebElement profValue = getDriver().findElement(By.xpath("//body/div[@id='menu-profession']/div[3]/ul[1]/li[5]"));
       profValue.click();
       sleep(2000);
    }

    @And("I click on Submit button")
    public void iClickOnSubmitButton() throws InterruptedException {

        getDriver().findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
        sleep(4000);

    }

    @Then("a verify email message gets displayed")
    public void aVerifyEmailMessageGetsDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//h3[contains(text(),'Your account is created! Verification email has been sent')]")).isDisplayed());
    }*/

    @Then("I navigate to check my mail")
    public void iNavigateToCheckMyMail() throws InterruptedException {

        //open a new window
        WebDriver driver = new ChromeDriver();
        driver.get("https://mailtrap.io/signin");

        //enter username
        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("epixegoauto@gmail.com", Keys.ENTER);
        sleep(4000);

        //enter password
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Epixego@20", Keys.ENTER);
        sleep(8000);
    }

    @And("I search for mail by user epixegomailer")
    public void iSearchForMailByUserEpixegomailer() throws InterruptedException {


        List<WebElement> a= getDriver().findElements(By.xpath("//*[@id=':1z']"));
        System.out.println(a.size());

        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i).getText());
            if(true == a.get(i).getText().equals("Epixegomailer")==true)
            {
                a.get(i).click(); // to click on the specific mail
            }
        }
    }

    @And("I click on the Sign-up link")
    public void iClickOnTheSignUpLink() {
    }
}

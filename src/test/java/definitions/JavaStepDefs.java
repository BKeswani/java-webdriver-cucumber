package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello World!");
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }


    @And("I perform actions {string} and {string}")
    public void iPerformActionsAnd(String str1, String str2) {
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
    }


    @And("I change {string} and {string} to uppercase")
    public void iChangeAndToUppercase(String str1, String str2) {
        System.out.println("str1 in uppercase: " + str1.toUpperCase());
        System.out.println("str2 in uppercase: " + str2.toUpperCase());
    }

    @And("I check the length for {string} and {string}")
    public void iCheckTheLengthForAnd(String str1, String str2) {
        System.out.println("str1 length: " + str1.length());
        System.out.println("str2 Length: " + str2.length());
    }
    @And("I check if {string} equals to {string}")
    public void iCheckIfEqualsTo(String str1, String str2) {
        System.out.println("does str1 equals to str2 ?" + (str1.equals(str2)));
    }

    @And("I check if {string} is equal to {string} ignoring cases")
    public void iCheckIfIsEqualToIgnoringCases(String str1, String str2) {
        System.out.println("is str1 equal to str2 ?" + str1.equalsIgnoreCase(str2));
    }

    @And("I check for partial match between {string} and {string}")
    public void iCheckForPartialMatchBetweenAnd(String str1, String str2) {
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("does str1 contain str2 ? "  +str1.contains(str2));
    }
}

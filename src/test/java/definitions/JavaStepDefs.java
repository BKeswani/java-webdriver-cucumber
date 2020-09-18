package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.*;
import java.util.ArrayList;

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
        System.out.println("does str1 contain str2 ? " + str1.contains(str2));
    }

    @Given("I swap firstname and middlename")
    public void iSwapFirstnameAndMiddlename() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        System.out.println("info" + info);
    }

    @Given("I swap elements in the list of array")
    public void iSwapElementsInTheListOfArray() {

        int[] ArrList = {5, 2, 9, 7, 3};
        for (int j : ArrList) {
            System.out.println(j);
        }
        System.out.println("After Swapping");
        for (int i = 0; i < ArrList.length; i++) {
            int temp = ArrList[2];
            ArrList[2] = ArrList[4];
            ArrList[4] = temp;
            System.out.println(ArrList[i]);

        }

    }


    @Given("a number I check if divisible by other number")
    public void aNumberICheckIfDivisibleByOtherNumber() {
        int i = 24;

        if (i % 3 == 0 && i % 4 == 0) {
            System.out.println(i + " is divisble by 3 and 4");
        } else if (i % 3 == 0) {
            System.out.println(i + " is divisble by 3");
        } else if (i % 4 == 0) {
            System.out.println(i + " is divisble by 4");
        } else
            System.out.println("Hello World");
    }

    @And("I print numbers upto the number entered")
    public void iPrintNumbersUptoTheNumberEntered() {
        int a = 10;
        for (int i = 0; i <= a; i++) {
            System.out.print(" " + i + " ");
        }
    }

    @And("I print numbers upto the negative number entered")
    public void iPrintNumbersUptoTheNegativeNumberEntered() {
        int a = -10;
        for (int i = 0; i >= a; i--) {
            System.out.print(" " + i + " ");
        }
    }

    @And("I print the elements of an integer array")
    public void iPrintTheElementsOfAnIntegerArray() {
        int[] arrA = {-1, -2, -3, -4, 5, 6, 7, 8};

        System.out.println("Here is the integer array:");

        for (int i = 0; i < arrA.length; i++) {

            System.out.print(" " + arrA[i] + ",");
        }
    }


    @And("I print all even numbers from a integer array")
    public void iPrintAllEvenNumbersFromAIntegerArray() {
        int[] number = new int[51];
        int j = 1;
        for (int i = 0; i < number.length; i++) {
            if (j % 2 == 0) {
                System.out.println(j + " is a even number");
            }
            j++;

        }

    }

    @And("I check if the array is empty")
    public void iCheckIfTheArrayIsEmpty() {
        int[] arr = new int[1789087];
        if (arr == null || arr.length == 0) {
            System.out.println("the array is empty");
        } else {
            System.out.println("the array has values");
        }
    }

    @And("I check if the array contains element")
    public void iCheckIfTheArrayContainsElement() {
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(1);
        myNumbers.add(3);
        myNumbers.add(2);
        myNumbers.add(3);
        myNumbers.add(7);

                System.out.println(myNumbers.contains(39));
                System.out.println(myNumbers.contains(7));

            }
}






package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerStepDefs {

    @Given("I calculate numbers")
    public void iCalculateNumbers() {
        int num1 = 10;
        int num2 = 20;

        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction:" + (num2 - num1));
        System.out.println("Product:" + (num1 * num2));
        System.out.println("Quotient:" + (num2 / num1));
    }

    @And("I test if condition")
    public void iTestIfCondition() {

        String color1 = "Blue";
        String color2 = "White";
        String notFavColor = "White";

        if (color1.equals(notFavColor)) {
            System.out.println(color1 + " is my favorite color");
        } else if (color2.equals(notFavColor)) {
            System.out.println(color2 + " is not my favorite color");
        } else {
            System.out.println("I do not care for the color:" + notFavColor);
        }

    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        List<String> groceryList = new ArrayList<>();
        groceryList.add("Tomatoes");
        groceryList.add("Avacado");
        groceryList.add("Onion");
        groceryList.add("Cilantro");
        for (String grocery : groceryList) {
            System.out.println(grocery);
        }
        System.out.println();
        System.out.println();
        System.out.println(groceryList.get(0));
        System.out.println(groceryList.get(2));

    }


    @And("I test if the number is positive or negative")
    public void iTestIfTheNumberIsPositiveOrNegative() {

        int myNum = 0;
        if (myNum >= 0){

            System.out.println(myNum + " is a positive number");

        }else if (myNum < 0){
            System.out.println(myNum + " is a negative number");

        }

    }

    @And("I print the nth day of the week {int}")
    public void iPrintTheNthDayOfTheWeek(int n) {
        List<String> daysOfWeek = new ArrayList<>();
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        for (int i = 0; i < daysOfWeek.size(); i++) {
            if (n == i+1)
                System.out.println(daysOfWeek.get(i));
        }

    }

}







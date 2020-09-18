@java
  Feature: Java Feature

    @java1
    Scenario: Hello World
      Given I say hello world
      And I say "hello again"
      And I say "hello hello hello"

     @java2
      Scenario: Strings
      And I perform actions "my var" and "my VAR"
      And I change "my var" and "my VAR" to uppercase
      And I check the length for "my var" and "my VAR"
      And I check if "my var" equals to "my VAR"
      And I check if "my var" is equal to "my VAR" ignoring cases
      And I check for partial match between "my var" and "my VAR"

   @Java3
      Scenario: swap array element
        Given I swap elements in the list of array

 # Homework Day 6
   @Java4
   Scenario: Divisibility check
     Given a number I check if divisible by other number


#Homework Day 8
  @Java5
  Scenario:Print numbers till n
     And I print numbers upto the number entered


  @Java6
  Scenario: Print numbers till n incase if n is a negative number
    And I print numbers upto the negative number entered

  @Java7
  Scenario: Print an integer array
    And I print the elements of an integer array

  @Java8
  Scenario: Print even numbers from the integer array
    And I print all even numbers from a integer array

  @Java9
  Scenario: Check if the array is empty
    And I check if the array is empty

  @Java10
  Scenario: Check if the array is contains element
      And I check if the array contains element



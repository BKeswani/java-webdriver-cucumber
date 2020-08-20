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
   Scenario : Integers

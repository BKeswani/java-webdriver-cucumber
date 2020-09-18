@market
Feature: Marketing Test Suite


  @market1

  Scenario: Navigation to Quote page
    Given I go to "quote" page
    And I print page title
    And I print the url
    And I print the window handle
    And I print the page source

   @market2
   Scenario: Navigation to Quote page- 2
     Given I go to "google" page
     And I print page title
     Given I go to "bing" page
     And I print page title
     Given I go to "yahoo" page
     And I print page title
     And I go to "quote" page
     And I print page title
     And I go back and forward, then refresh

   @market3
   Scenario: Change Resolution to Phone
     Given I go to "quote" page
     And I change resolution to phone

  @market4
  Scenario: Change Resolution to laptop
    Given I go to "quote" page
    And I change resolution to laptop

  @market5
  Scenario: Complete the required and optional fields on the quote page and submit
    Given I go to "quote" page
    And I print page title
    When I fill out required fields
    And I click on Submit
    Then I validate the required data

  @market6
    Scenario: Verify email field behavior if @ is missing error gets displayed
    Given I go to "quote" page
    And I print page title
    When I fill out incorrect email
    Then error message gets displayed for incorrect email
    Then I fill out the email correctly

  @market7
    Scenario: Accept alert
    Given I go to "quote" page
    And I print page title
    When I fill out required fields
    And I click 3rd party agreement and click ok
    And I click on Submit
    Then I validate the required data

   @market8
     Scenario: Dismiss Alert
     Given I go to "quote" page
     And I print page title
     When I fill out required fields
     And I click 3rd party agreement and click cancel

  @codingchallenge1
    Scenario: coding challenge swap using maps
      Then I swap firstname with lastname











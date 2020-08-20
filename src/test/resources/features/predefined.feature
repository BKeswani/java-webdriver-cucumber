@predefined
Feature: Smoke steps

  @predefined1 @smoke
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2 @smoke
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@class='sb_form_q']" should be present
    When I type "Behavior Driven Developement" into element with xpath "//input[@class='sb_form_q']"
    Then I click on element using JavaScript with xpath "//input[@id='sb_form_go']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"
  
  @predefined3
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com"
    Then I should see page title as "Yahoo"
    Then element with xpath "//input[@name ='p']" should be present
    When I type "Behavior Driven Developement" into element with xpath "//input[@name ='p']"
    Then I click on element using JavaScript with xpath "//button[@id ='header-desktop-search-button']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then I wait for 5 sec
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"


  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title as "Gibiru – Protecting your privacy since 2009"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@class='btn btn-outline-secondary']"
    Then I wait for element with xpath "//div[@class='gsc-results gsc-webResult']" to be present
    Then element with xpath "//div[@class='gsc-results gsc-webResult']" should contain text "Cucumber"

 @predefined5
 Scenario: Predefined steps for duckduckgo
   Given I open url "https://duckduckgo.com/"
   Then I should see page title as "DuckDuckGo — Privacy, simplified."
   Then element with xpath "//input[contains(@class,'js-search-input search__input--adv')]" should be present
   When I type "Behavior Driven Development" into element with xpath "//input[contains(@class,'js-search-input search__input--adv')]"
   Then I click on element with xpath "//input[@id = 'search_button_homepage']"
   Then I wait for element with xpath "//div[contains(@class,'results js-results')]" to be present
   Then element with xpath "//div[contains(@class,'results js-results')]" should contain text "Cucumber"


 @predefined6
  Scenario:Predefined steps for Swisscow
   Given I open url "https://swisscows.com/?culture=en"
   Then I should see page title as "Swisscows the alternative, data secure search engine."
   Then element with xpath "//input[@class='input-search']" should be present
   When I type "Behavior Driven Development" into element with xpath "//input[@class='input-search']"
   Then I click on element with xpath "//button[@class='search-submit']"
   Then I wait for element with xpath "//div[@class='web-results']" to be present
   Then I wait for 10 sec
   Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"


  @predefined7
  Scenario: Predefined steps for Searchencrypt
    Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//input[@class='search-bar__search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='search-bar__search']"
    Then I click on element with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//div[@class ='serp__web-result__container']" to be present
    Then element with xpath "//div[@class ='serp__web-result__container']" should contain text "Cucumber"
  ## Comments  : the last step failed as the page does not display Cucumber in the web results area.



   @predefined8
   Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title as "Startpage.com - The world's most private search engine"
    Then element with xpath "//input[@class='search-form-home__q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='search-form-home__q']"
    Then I click on element with xpath "//button[@class='search-form-home__form__button']"
    Then I wait for element with xpath "//section[@class='w-gl w-gl--default']" to be present
    Then I wait for 10 sec 
    Then element with xpath "//section[@class='w-gl w-gl--default']" should contain text "Cucumber"


 @predefined1
  Scenario: Responsive UI
   Given I open url "https://skryabin.com/market/quote.html"
   Then I resize window to 1240 and 1044
   Then I wait for 10 sec
   Then element with xpath "//b[@id ='location']" should be displayed
   Then I resize window to 1044 and 800
   Then I wait for 10 sec
   Then element with xpath "//b[@id ='location']" should be displayed
   Then I resize window to 320 and 650
   Then I wait for 10 sec
   Then element with xpath "//b[@id ='location']" should not be displayed

 @predefined2
 Scenario: Validate User Name
   Given I open url "https://skryabin.com/market/quote.html"
   Then I type "a" into element with xpath "//input[@name='username']"
   Then I wait for 4 sec
   Then I click on element with xpath "//input[@name='email']"
   Then element with xpath "//label[@class='error']" should be displayed
   Then I clear element with xpath "//input[@name='username']"
   Then I type "BKeswani" into element with xpath "//input[@name='username']"
   Then I click on element with xpath "//input[@name='email']"
   Then I wait for 4 sec
   Then element with xpath "//label[@class='error']" should not be displayed

 @predefined3
 Scenario: Validate Email
   Given I open url "https://skryabin.com/market/quote.html"
   When I type "BKeswani" into element with xpath "//input[@name='email']"
   Then I wait for 4 sec
   Then I click on element with xpath "//button[contains(text(),'Submit')]"
   Then element with xpath "//label[@id='email-error']" should be present
   When I type "BKeswani@yahoo" into element with xpath "//input[@name='email']"
   Then element with xpath "//label[@id='email-error']" should not be displayed

 @predefined4
 Scenario: Validate Password
   Given I open url "https://skryabin.com/market/quote.html"
   Then element with xpath "//input[@name='confirmPassword']" should be disabled
   When I type "abc" into element with xpath "//input[@name='password']"
   Then I click on element with xpath "//button[contains(text(),'Submit')]"
   Then element with xpath "//label[@id='password-error']" should be present
   When I type "password" into element with xpath "//input[@name='password']"
   And I type "password" into element with xpath "//input[@name='confirmPassword']"
   Then I click on element with xpath "//button[contains(text(),'Submit')]"

 @predefined5
 Scenario: Validate Name
   Given I open url "https://skryabin.com/market/quote.html"
   When I click on element with xpath "//input[@id='name']"
   And I type "Barkha" into element with xpath "//input[@id='firstName']"
   And I type "M" into element with xpath "//input[@id='middleName']"
   And I type "Keswani" into element with xpath "//input[@id='lastName']"
   Then I click on element with xpath "//span[contains(text(),'Save')]"
   Then element with xpath "//input[@id='name']" should have attribute "value" as "Barkha M Keswani"
   Then I click on element with xpath "//button[@id ='formSubmit']"
   
 @predefined6
 Scenario: Validate Accepting Privacy Policy is required
   Given I open url "https://skryabin.com/market/quote.html"
   And I click on element with xpath "//button[@id ='formSubmit']"
   Then element with xpath "//label[contains(text(),'- Must check!')]" should be displayed
   And I wait for 10 sec
   When I click on element with xpath "//*[@name='agreedToPrivacyPolicy']"
   And I wait for 10 sec
   And I click on element with xpath "//button[@id ='formSubmit']"
   Then element with xpath "//label[contains(text(),'- Must check!')]" should not be present
   And I wait for 10 sec

 @predefined8
 Scenario: End to End Testing
   Given I open url "https://skryabin.com/market/quote.html"
   Then I type "BKeswani" into element with xpath "//input[@name='username']"
   When I type "BKeswani@yahoo" into element with xpath "//input[@name='email']"
   And I type "password" into element with xpath "//input[@name='password']"
   And I type "password" into element with xpath "//input[@name='confirmPassword']"
   Then I click on element with xpath "//input[@id='name']"
   And I type "Barkha" into element with xpath "//input[@id='firstName']"
   And I type "M" into element with xpath "//input[@id='middleName']"
   And I type "Keswani" into element with xpath "//input[@id='lastName']"
   And I click on element with xpath "//span[contains(text(),'Save')]"
   And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
   And I click on element with xpath "//button[@id ='formSubmit']"
   And I wait for 10 sec
   Then element with xpath "//b[@name='username']" should contain text "Bkeswani"
   Then element with xpath "//b[@name='email']" should contain text "BKeswani@yahoo"
   Then element with xpath "//b[@name='name']" should contain text "Barkha M Keswani"
   Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
   Then element with xpath "//b[@name='password']" should not contain text "password"




   
   
   
   


















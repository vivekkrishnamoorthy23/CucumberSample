Feature: Automating Web Application

@Login
  Scenario Outline: Login on Automation Exercise Site
    Given The Automation Exercise site is open
    And click on signup or login menu
    When user enters email "<emailid>" and password "<password>" and clicks login
    Then validate correct name is displayed on the landing screen "<name>"
    And click logout and check logged out successfully
    Then close the browser
    
Examples:
| emailid | password |
| vivek230034@gmail.com | Password01 |

@AddingProduct
  Scenario Outline: Login and add product in Automation Exercise Site
    Given The Automation Exercise site is open
    And click on signup or login menu
    When user enters email "<emailid>" and password "<password>" and clicks login
    Then validate correct name is displayed on the landing screen "<name>"
    When user add product in cart
    And user procced to checkout
    And check whether payment page is displayed
    Then close the browser
    
Examples:
| emailid | password |
| vivek230034@gmail.com | Password01 |

 @Registration
  Scenario Outline: Register on Automation Exercise Site
    Given The Automation Exercise site is open
    And click on signup or login menu
    When user enters name "<name>" and emailid "<emailid>"
    And user clicks signup button and account information page is displayed
    And user enters account information and clicks create account
    And check account is created succefully and click continue
    Then validate correct name is displayed on the landing screen "<name>"
    And click logout and check logged out successfully
    Then close the browser 
    
Examples:
| name | emailid |
| vivek | vivek230035@gmail.com |

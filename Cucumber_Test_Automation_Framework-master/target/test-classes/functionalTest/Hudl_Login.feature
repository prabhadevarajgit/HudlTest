@Login
Feature: hudl login validation

  Background: launch hudl url
    Given user is on Home Page of hudl

  Scenario Outline: hudl login with Valid credentials
    When user tries to login with below credentials of <email> and <password>
    Then user able to login successfully
    And user loggedout successfully on clicking logout button

    Examples: 
      | email                      | password |
      | prabharamesh2018@gmail.com | test123  |
      | PRABHARAMESH2018@GMAIL.COM | test123  |
      
      
    Scenario: validate the logout action when user navigate back from the logged in page
    When user tries to login with "prabharamesh2018@gmail.com" and "test123"
    Then user able to login successfully
    And user clicks on back in browser
    Then user see the homePage

  Scenario Outline: hudl login with invalid credentials
    When user tries to login with below credentials of <email> and <password>
    Then user see the error message <errorMessage>
    And login button is disabled

    Examples: 
      | email                      | password | errorMessage                                               |
      | prabharamesh2018@gmail.com |          | We didn't recognize that email and/or password. Need help? |
      |                            | test123  | We didn't recognize that email and/or password. Need help? |
      | prabharamesh               | test123  | We didn't recognize that email and/or password. Need help? |
      | PRABHARAMESH2018@GMAIL.COM | TEST123  | We didn't recognize that email and/or password. Need help? |

 

     
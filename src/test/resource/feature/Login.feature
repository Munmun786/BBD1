Feature: Login functionality

  Scenario Outline: Login with valid credentials
    Given User has Navigates to login Page
    When User has entered valid  email address <username> into email field
    And User has entered valid Password  <password> into Password Field
    And User clicks on Login button
    Then User should get Successfully logged in
Examples:
|username                     |password|
|munmunpradhan786@gmail.com   |munmun@97|
|munmunpradhan786@gmail.com   |munmun@97|
|munmunpradhan786@gmail.com   |munmun@97|
|munmunpradhan786@gmail.com   |munmun@97|
|munmunpradhan786@gmail.com   |munmun@97|



  Scenario: Login with invalid credentials
    Given User has Navigates to login Page
    When User has entered invalid email  address  into the email field
    And User has entered invalid password address "munmu346" into password field
    And user click on login button
    Then User should get a Warring massage about credential miss match

  Scenario: Login with valid email and invalid password
    Given User has Navigates to login Page
    When User has entered valid  email address "munmunpradhan786@gmail.com" into email field
    And User has entered invalid password address "munmu346" into password field
    And user click on login button
    Then User should get a Warring massage about credential miss match

  Scenario: Login with invalid email and valid password
    Given User has Navigates to login Page
    When User has entered invalid email  address  into the email field
    And User has entered invalid password address "munmu97" into password field
    And user click on login button
    Then User should get a Warring massage about credential miss match

  Scenario: Login without providing any credentials
    Given User has Navigates to login Page
    When User don't enter email  address  into the email field
    And User don't enter password address  into password field
    And user click on login button
    Then User should get a Warring massage about credential miss match

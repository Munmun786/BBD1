Feature: Registeration Functionality

Screnario: User creates an account only with mandatory fields

Given User Navigates to Register account page
When user enters the details into below fields
|firstName|Munmun             |
|lastName|pradhan             |
|telephone| 7890987690        |
|password | munmun78           |
And User selects privacy policy
And User click on continue button
Then User accoutn should get created successfully

Scenario: User create an account with all fields

Given User Navigates to Register account page
When user enters the details into below fields
|firstName|Munmun             |
|lastName|pradhan             |
|telephone| 7890987690        |
|password | munmun78           |
And User selectd yes for Newsletter
And User selects privacy policy
And User click on continue button
Then User accoutn should get created successfully

Scenario: User create a duplicate account

Given User Navigates to Register account page
When user enters the details into below fields with duplicate email
|firstName|Munmun             |
|lastName|pradhan             |
|email   |munmunpradhan786@gmail.com| 
|telephone| 7890987690        |
|password | munmun78           |
And User selectd yes for Newsletter
And User selects privacy policy
And User click on continue button
Then User should get a proper waring message

Scenario: User create an account without filling any details

Given User Navigates to Register account page
When user dont enters the details into  fields
And User click on continue button
Then User should get proper warning message for every mandatory field






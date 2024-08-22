Feature: Search Functionality

Scenario: Search for valid Product
Given User opens the Application
When User enters valid product "HP" into Search box feilds
And User click on Serach button
Then User should get valid product display in search result

Scenario: User search for an invalid product

Given User opens the Application
When User enters invalid product "HonP" into Search box feilds
And User click on Serach button
Then User should get a message about not product matching

Scenario: User searchs without any product
Given User opens the Application
When User dont enters any product into Search box feilds
And User click on Serach button
Then User should get a message about not product matching
@Registration
Feature: Acess of registration page
@launchHomePage
Scenario: User open registration page
Given User open DSPortal home page
When the user clicks on Register button link
Then The register page should be displayed

Scenario: user registers with valid inputs
Given the user is in registration page
When the user fills out all registration fields correctly
Then The user should see a sucess message

Scenario: User enter weak password
Given the user is in registration page
When the user enters 12345 into the passwordfield 
Then the system displays password too weak

Scenario: User leave password field empty
Given the user is in registration page
When the user leaves password field empty  
Then the system displays password fied empty
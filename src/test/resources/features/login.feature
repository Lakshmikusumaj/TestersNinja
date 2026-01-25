@login

Feature: Login functionality for DS Algo portal

Background: User navigates to the login page
Given User launches chrome browser
When user opens the website and clicks get started and selects the signin option
Then user should be on the Login page

@positive
 Scenario: User logs in with valid credentials
 Given User is on the login page
 When user enters username "Test_01" and password "Sdet@2025" and clicks the login button
 Then user should be successfully logged in to the site
 
@negative 
 Scenario Outline: Invalid login attempts
 Given User is on the login page
 When user enters username "<username>" and password "<password>" and clicks the login button
 Then user should see a login error message
 
   Examples:
      | username                   | password         |
      | wrong                      | wrongpass        |
      | invaliduser                | invalidpass        |
   
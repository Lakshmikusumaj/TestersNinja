@Login @LaunchHome
Feature: Login functionality for DS Algo portal

  Background: User navigates to login page
    Given User is on the Login page

  @Login_DataDriven
  Scenario Outline: Validate login functionality using multiple test data
    Given Login data for the sheet "<SheetName>"
    When Enters username and password for testcase "<TestCaseName>" and clicks login button
    Then Login result should be as expected for the testcase "<TestCaseName>"

    Examples:
      | SheetName | TestCaseName     |
      | LoginData | Login_Valid			 |
      | LoginData | Login_Invalid		 |

@signin_valid
Scenario: successful login functionality
   # Given User is on the Login page
    When User enters username and password and clicks login button
    Then User should be successfully logged in
    
@Performance
Scenario: Verify login response time is within acceptable limit
  When User enters valid username and password and clicks login button
  Then Login response time should be less than 3 seconds
  
# @Load
# Scenario: Verify login functionality under heavy load
 # Given Multiple users are accessing the Login page
 # When 1000 users attempt to login simultaneously
 # Then System should allow successful login without failures
  
    
    
    
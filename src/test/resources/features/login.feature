@Login @LaunchHome
Feature: Login functionality for DS Algo portal

  Background: User navigates to login page
    Given User is on the Login page

  @Login_DataDriven
  Scenario Outline: Validate login functionality using multiple test data
    Given Login data
    When Enters username and password for testcase "<TestCaseName>" and clicks login button
    Then Login result should be as expected for the testcase "<TestCaseName>"

    Examples:
      | TestCaseName               |
      | Login_Valid			           |
      | Login_Invalid		           |
      | Login_Invalid_Username		 |
      | Login_Invalid_Password		 |

@signin_valid
Scenario: successful login functionality
    When User enters username and password and clicks login button
    Then User should be successfully logged in
    
@Performance
Scenario: Verify login response time is within acceptable limit
  When User enters valid username and password and clicks login button
  Then Login response time should be less than 3 seconds
  
 @loginbutton_enable 
  Scenario: Verify Login button is enabled when username and password are entered
  When User enters username and password
  Then Login button should be enabled
  
  @password_mask
  Scenario: Verify password field is masked
  When User enters password
  Then Password should be displayed in masked format
  
  @errormsg_checking
  Scenario: Login with invalid username and invalid password
  When User enters invalid username and invalid password and clicks login button
  Then Error message Invalid Username and Password should be displayed
  
  
  

    
    
    
@Registration @LaunchHome

Feature: Access of registration page

@launchHomePage @testcase-R00
Scenario: User open registration page
Given User open DSPortal home page
When the user clicks on Register button link
Then the register page should be displayed

@testcase-R01
Scenario Outline: User registers with valid inputs
Given the user is in registration page
When the user enters username "<username>" password "<password>" and  confirmPassword "<confirmpassword>"
Then the user should see a success message

Examples:
| username  | password     |  confirmpassword |
| Automa230@ |Test@12345.>| Test@12345.> |
| testuser2 | Test@12345   |  Test@12         |

#Scenario: user registers with valid inputs
#Given the user is in registration page
#When the user fills out all registration fields correctly
#Then the user should see a success message

#Scenario: User enter weak password
#Given the user is in registration page
#When the user enters 12345 into the passwordfield 
#Then the system displays password too weak

@testcase-R02
Scenario Outline: Validate password rules
  Given the user is on the registration page
  When the user enters "<username>" and "<password>" and  confirmPassword "<confirmpassword>"
  Then the system displays "<message>"

Examples:
|username     | password | confirmpassword | message                    |
|TestReg      | 12345    | 12345           | Password too weak          |
|TestReg      |          | 12345           | please fill out this field |
|             | 57365    |                 | please fill out this field |
|TestersNinja |476846    |476846           | two password mismatch      |

#Scenario: User leave password field empty
#Given the user is in registration page
#When the user leaves password field empty  
#Then the system displays password fied empty
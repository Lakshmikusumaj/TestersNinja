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
| username  | password      |  confirmpassword   |
| Automa230@| Test@12345.>! |  Test@12345.>!     |
| testuser2 | Test@12345    |  Test@12345        |

#Scenario: user registers with valid inputs
#Given the user is in registration page
#When the user fills out all registration fields correctly
#Then the user should see a success message 

#Scenario: User enter weak password
#Given the user is in registration page
#When the user enters 12345 into the passwordfield 
#Then the system displays password too weak

@testcase-R02
Scenario Outline: user gives "<TestcaseName>" Validate password rules
  Given the user is on the registration page
  When the user enters "<username>" and "<password>" and confirmPassword "<confirmpassword>"
  Then the system displays "<message>"

Examples:
|TestcaseName|username     | password | confirmpassword | message                    |
|TC-R1       |TestReg      | 12345    | 12345           | password_mismatch:The two password fields didn’t match.|           
|TC-R2       |TestReg      |          | 12345           | please fill out this field |
|TC-R3       |             | 57365    |                 | please fill out this field |
|TC-R4       |TestersNinja | 476846   | 46846           | two password mismatch       |

#Scenario: User leave password field empty
#Given the user is in registration page
#When the user leaves password field empty  
#Then the system displays password fied empty
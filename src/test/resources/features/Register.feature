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
Then the user should see a "<success>" message

Examples:
| username  | password      |  confirmpassword   |
| Auto230231| Test@12345>!  |  Test@12345>!      |
| testuser2 | Test@12345    |  Test@12345        |


@testcase-R02
Scenario Outline: user gives "<TestcaseName>" Validate password rules
  Given the user is on the registration page
  When the user enters "<username>" and "<password>" and confirmPassword "<confirmpassword>"
  Then the system displays "<message>"

Examples:
|TestcaseName   |username     | password | confirmpassword | message                    |
|Numeric        |TestReg      | 12345    | 12345           | password_mismatch:The two password fields didn’t match.|           
|EmptyPass      |TestReg      |          | 12345           | please fill out this field |
|EmptyUser      |             | 57365    |                 | please fill out this field |
|PassMissmatch  |TestersNinja |Numpy     |    Numpy1       | two password mismatch       |

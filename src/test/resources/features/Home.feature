@LaunchHome 
  Feature: Verify Topics Covered on DS Portal Home Page 

  Background:
    Given user is on the DS Portal home page 
     # -------------------- Register Link --------------------# 

  Scenario: Verify Register link navigation 
    When user clicks on "Register" link
    Then user should be navigated to Register page
    #--------------------Data structure----------------------# 
   Scenario Outline: Verify navigation for all topics 
  When user clicks on "<Data Structures>" dropdown 
  Then user should see topics of dropdown 

  Examples:  
  
  | Arrays      |
  | Linked List |
  | Stack       |
  | Queue       |
  | Tree        |
  | Graph       |
  
  Scenario: Verify user can navigate to Arrays page 
    When user clicks on the array  "Arrays" 
    Then user should see "Alert" message

  # -------------------- Sign In Link --------------------  

  Scenario: Verify Sign In link navigation 
    When user clicks on "Sign In" link
    Then user should be navigated to Login page

  # -------------------- Successful Login -------------------- 

  Scenario Outline: Verify user can login with valid credential 
    When user clicks on "Sign In" link
    And user enters "<username>" and "<password>"
    And user clicks on Login button
    Then user should be logged in successfully  
    #And user should see logout option  

  Examples: 
    | username     | password     |
    | validUser1   | validPass1   | 
    | TestersNinja | Ts230@231    |
   Rule: sign in for all modules  
  
  #@LaunchHome
  @ValidLogin 
  
  Scenario Outline: Verify navigation for all topics after login
    When user clicks on "<topic>" dropdown after sign in
    Then user should be navigated to "<topic>" page

  Examples:
    | topic       |
    | Arrays      |
    | Linked List |
    | Stack       |
    | Queue       |
    | Tree        |
    | Graph       |
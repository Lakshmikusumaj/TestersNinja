@LaunchHome  @Home 
  Feature: Verify Topics Covered on DS Portal Home Page 

  Background:
    Given user is on the DS Portal home page 
     # -------------------- Register Link --------------------# 
@Home-01
  Scenario: Verify Register link navigation 
    When user clicks on "Register" link
    #Then user should be navigated to Register page
    #--------------------Data structure----------------------#  
 @Home-02
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
  
  @home03
  Scenario: Verify user can navigate to Arrays page 
    When user clicks on the array  "Arrays" 
    Then user should see "You are not logged in" message

  # -------------------- Sign In Link --------------------   

  Scenario: Verify Sign In link navigation 
    When user clicks on "Sign In" link
    Then user should be navigated to Login page

  # -------------------- Successful Login -------------------- 
@home04
  Scenario Outline: Verify user can login with valid credential 
    When user clicks on "Sign In" link
    And user enters "<username>" and "<password>"
    And user clicks on Login button
    Then user should see "<message>" successfully  
    #And user should see logout option  

  Examples: 
    | username     | password     | message                       |
    | validUser1   | validPass1   | Invalid Username and Password  |
    | TestersNinja | Ts230@231    | You are logged in              |

    
   Rule: sign in for all modules  
  
 
  @ValidLogin @Home-03
  
  Scenario Outline: Verify navigation for all topics after login
    When user clicks on "<topic>" dropdown after sign in
    Then user should be navigated to "<topicPage>" page

  Examples:
    | topic       |topicPage    |
    | Arrays      |Array        |
    | Linked List |Linked List  |
    | Stack       |Stack        |
    | Queue       |Queue        |
    | Tree        |Tree         |
    | Graph       |Graph        |
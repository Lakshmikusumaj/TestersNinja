@DS-Intro @LaunchHome  @ValidLogin

Feature: User Navigates to the DataStructures-Introduction module

Background:
  Given User login and clicks the DataStructures-Intoduction module from the home page
  
 @DS-01 
  Scenario: Verify page title is displayed
   Then User should see page title "Data Structures-Introduction"

@DS-02
 Scenario: Verify header elements are visible
    Then User should see "NumpyNinja" logo
    And User should see "Data Structures" dropdown
    And User should see "Test_01" link
    And User should see "Sign out" button

@DS-3    
  Scenario Outline: User navigates the Data Structures Introduction topics
    When User clicks "<Topic>" link
    Then User should be redirected to "<Topic>"

    Examples:
      | Topic                        | 
      | Time Complexity              | 
      | Practice Questions           | 
      
 @DS-4    
 Scenario: Verify user lands on Time Complexity page
    Given User navigates to Time Complexity page
    Then User should see page title Time Complexity "Time Complexity" 
    
  @DS-05  
 Scenario: verify user lands on practice questions 
    Given user navigates to the practice questions 
    Then user should see empty page
    Then User should see in practice Questions "NumpyNinja" logo
    And User should see on practice "Data Structures" dropdown
    And User should see on practice Question "Test_01" link
    And User should see on practice Question "Sign out" button      
     
@DS-6     
  Scenario Outline: User runs "<TestcaseName>" in Try Editor
    Given User is on "<Page>" page
    When User clicks Try here gives the "<TestCaseName>" and clicks Run button
    Then User should see "<ExpectedResult>"

    Examples:
      | TestCaseName        |ExpectedResult |
      | PrintString         |NumpyNinja     |
      |	Addition            |7              |
      | SyntaxError         |Error          |
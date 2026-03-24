@DS-Intro @LaunchHome  @ValidLogin

Feature: User Navigates to the DataStructures-Introduction module

Background:
  Given User login and clicks the DataStructures-Intoduction module from the home page
  
  
@DS-1    
  Scenario Outline: User navigates the Data Structures Introduction topics
    When User clicks "<Topic>" link
    Then User should be redirected to "<Page>"

    Examples:
      | Topic                        | Page                     |
      | Time Complexity              | Time Complexity          |
      | Practice Questions           | Practice Questions       |
      
      
@DS-2     
  Scenario Outline: User runs "<TestcaseName>" in Try Editor
    Given User is on "<Page>" page
    When User clicks Try here gives the "<TestCaseName>" and clicks Run button
    Then User should see "<ExpectedResult>"

    Examples:
      | TestCaseName        |ExpectedResult |
      | PrintString         |NumpyNinja     |
      |	Addition            |7              |
      | SyntaxError         |Error          |
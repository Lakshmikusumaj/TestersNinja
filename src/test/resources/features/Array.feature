@Array @LaunchHome @ValidLogin

Feature: User navigates Array module  
   
 Background: 
    Given user clicks on Array from the home page 
 @Array-01   
  Scenario Outline: User navigates to Arrays topics list
   When user clicks on "<Topiclist>" in Arrays page
   Then user is navigated to "<Topiclist>" page

  Examples:
  |Topiclist                |
  |Arrays in Python         |
  |Arrays Using List        |
  |Basic Operations in Lists|
  |Applications of Array    |
   #------------------------ PRACTICE QUESTIONS----------------------
@Array-02
  Scenario Outline: User navigates to Practice Questions in Arrays in Python
    When user clicks on "<Questions>"
    Then user is navigated to the "<Destination>" page
    
Examples:
       |Questions                               |Destination |
       |Search the array                        |Assessment  |
       |Max Consecutive Ones                    |Assessment  |
       |Find Numbers with Even Number of Digits |Assessment  |
       |Squares of a Sorted Array               |Assessment  |  
      
       #data driven
@Array-03
  #------------------------ PRACTICE QUESTIONS EXCEL DATA DRIVEN----------------------
 Scenario Outline: User runs array practice questions in Try Editor
Given user is on "<Questions>" practice question page
When user enters "<TestCaseName>" in try editor fixes indentation and clicks submit button Run button
Then user should see "<ExpectedResult>" in array tryeditor


Examples:
|Questions             |TestCaseName          |  ExpectedResult|                        
|Search the array      | Search array         |     True             |        
|Max Consecutive Ones  | MaxConsecutiveOnes   |    Error               |       

 #++++++++++++++++++++++ TRY EDITOR VALIDATION EXCEL DATA+++++++++++++++++++++++++++++#
 
  @Array-04
  Scenario Outline: Verify TryEditor functionality with python code of array module
   Given Array Try Editor data
    When User enters python code in TryEditor for "<TestCaseName>" and clicks Run
    Then User should see the expected output for "<ExpectedResults>"
    
    Examples:
      | TestCaseName        |ExpectedResults|
      | PrintString         |NumpyNinja     |
      |	Addition            |7              |
      | SyntaxError         |Error          |
      #| Subtraction         |3              |
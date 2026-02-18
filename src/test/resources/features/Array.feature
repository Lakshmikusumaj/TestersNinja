@Array @LaunchHome @ValidLogin

Feature: User navigates Array module
 
 
 Background:
    Given user clicks on Array from the home page 
 
  Rule: user is on navigates Array page 

  # ARRAYS AND ARRAYS IN PYTHON 
  Scenario: User navigates to Arrays in Python
   When user clicks on Arrays in Python button
   Then user is navigated to the Arrays in Python page

  # ARRAYS USING LIST
  Scenario: User navigates to Arrays Using List 
    When user clicks on Arrays Using List button
    Then user is navigated to the Arrays Using List page

  
  # BASIC OPERATIONS IN LISTS
  Scenario: User navigates to Basic Operations in Lists 
    When user clicks on Basic Operations in Lists
    Then user is navigated to the Basic Operations in Lists page
  
  # APPLICATIONS OF ARRAY
  
  Scenario: User navigates to Applications of Array
    When user clicks on Applications of Array
    Then user is navigated to the Applications of Array page
    
#TRY EDITORS IN THE ARRAY MODULE

 Scenario: User navigates to Try Here editor from Applications of Array
    When user clicks on Try Here button
    Then user is navigated to the Try Editor page
 

  # PRACTICE QUESTIONS
  Scenario: User navigates to Arrays in Python Practice Questions
    #Given user is on the Arrays in Python page
    When user clicks on Practice Questions
    Then user is navigated to the Practice Questions page

  # SEARCH THE ARRAY
  Scenario: User navigates to Search the Array question
    #Given user is on the Practice Questions page
    When user clicks on Search the Array
    Then user is navigated to the Search the Array question page

  # MAX CONSECUTIVE ONES
  Scenario: User navigates to Max Consecutive Ones question
    #Given user is on the Search the Array question page
    When user clicks on Max Consecutive Ones
    Then user is navigated to the Max Consecutive Ones Try Editor page

  # FIND NUMBERS WITH EVEN NUMBER OF DIGITS
  Scenario: User navigates to Find Numbers with Even Number of Digits question
    #Given user is on the Practice Questions page
    When user clicks on Find Numbers with Even Number of Digits
    Then user is navigated to the Find Numbers with Even Number of Digits editor page

  # SQUARES OF A SORTED ARRAY
  Scenario: User navigates to Squares of a Sorted Array question
    #Given user is on the Practice Questions page
    When user clicks on Squares of a Sorted Array
    Then user is navigated to the Squares of a Sorted Array editor page

  # TRY EDITOR VALIDATION
  
  Scenario: ArrayTryEditor data driven
  
    Given user is on the Applications of Array page
    When user executes "Code" from "Array data" sheet
    Then user should see expected result
    
    

Feature: user Navigates  Array module

Rule: User can navigate through Array topics

Background: 
Given user clicking on array from home page

                               #ARRAY AND ARRAYS IN PYTHON
                             
Scenario: user navigates to the Array
Given  user is on home page
When user clicks on Arrays in python button
Then user landed on to the Arrays in python page

                               #ARRAYS USING LIST
                             
Scenario: user navigates to the Arrays Using List
Given user is on Arrays in python page
When user clicks on Arrays Using List button
Then user landed on to the Arrays Using List page

Scenario: User navigate to the try here>> button
Given user is on Arrays Using List page
When user clicks on try here>>> button
Then user landed on to the python code

Scenario: user gives invalid code in try editor
Given user is on try editors page
When user is gives invalid code and clicks on run button
Then user see error pop up message

Scenario: user gives valid code
Given user is on try here page 
When User is gives valid code and clicks on run button
Then user see the output 

                             #BASIC OPERATIONS IN LISTS
          
Scenario: user navigates to the Basic Operations in Lists
Given user is on array page
When user clicks on Basic Operations in Lists
Then user is landed to the Basic Operations in Lists

Scenario: user navigates to the try here button
Given user is on Basic Operations in Lists page
When user clicks on try here 
Then user landed on try here page

Scenario Outline: user enters valid and invalid code 
Given user is on the Basic Operations in Lists page
When user enters "<code>" in the code editor and clicks run button
Then user should see "<result>"

   
Examples:
| code               | result    |
| print 5            | output    |
| print 7            | output    |
| djfvbnds           | error     | 

                        #APPLICATIONS OF ARRAY
                        
Scenario: user navigates to the Applications of array
Given user is on the Array page 
When user is clicks on to the Applications of Array 
Then user should landed on to the Application of array page 

Rule: Try Editor behavior for Applications of Array

Scenario Outline: user enters valid and invalid code in the Application of array try editor code
Given user is on Application of the Array page 
When user enters "<code>" in the try editors page and clicks run button 
Then user see "<result>" on the page 

Examples:
| code               | result    |
| print('hello')     | output    |
| print(hello)       | error     |
| djfvbnds           | error     |

                   #PRACTICE QUESTIONS
                          
Scenario: user navigates to the Arrays in python Practice Questions
Given user landed on Arrays in Python page 
When user is clicks on to practice questions
Then user is landed on pracice Questions 

                          #search the Array
                          
Scenario: User navigates to the search the array 
Given user landed on Practice Questions page 
When user clicks on to the search the array 
Then user landed on Question1 page

Scenario: user gives to the valid and invalid code in search the array editor page
Given user landed on question1 editor page 
When user enters valid and invalid code in editor page 
Then user see output  

                          #Max Consecutive Ones 
                          
Scenario: user navigates to the Max Consecutive Ones
Given user is in question1 page 
When user clicks on to the Max Consecutive Ones
Then user landed on to the max consecutive ones try editors page 

Scenario: user gives to the valid and invalid code in Max Consecutive Ones 
Given user is in question2 page 
When User enters valid and invalid code in editor page and clicks run and submit button
Then user see output and error messages on console 

                        #Find Numbers with Even Number of Digits
                        
Scenario: user navigates to the Find Numbers with Even Number of Digits 
Given User is in practice questions page 
When user clicks on to the Find Numbers with Even Number of Digits
Then user is landed on to the Find Numbers with Even Number of Digits editor page 

Scenario: user gives to the valid and invalid code in Find Numbers with Even Number of Digits
Given user is in question3 page 
When user enters valid and invalid code and clicks submit and run button 
Then user see error message and output 

                        #Squares of  a Sorted Array
                        
Scenario: user Navigates to the Squares of  a Sorted Array
Given user should be practice Questions page
When user clicks on to the Squares of  a Sorted Array 
Then user landed on to the Squares of  a Sorted Array editors page 
 
Scenario: user gives valid and invalid code 
Given user is in question4 page 
When user enter valid and invalid code clicks run button 
Then user see output and error message in question4 page

                       
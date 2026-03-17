@DS-Intro @LaunchHome  @ValidLogin

Feature: User Navigates to the DataStructures-Introduction module

Background:
  Given User login and clicks the DataStructures-Intoduction module from the home page
  
  
@DS-1    
  Scenario Outline: User navigates the Data Structures Introduction topics
    When User clicks "<Topic>" link
    Then User should be redirected to "<Page>"

    Examples:
      | Topic                        | Page                          |
      #| Data Structures-Introduction | Data Structures Introduction  |  
      | Time Complexity              | Time Complexity page          |
      | Practice Questions           | Practice Questions page       |
      
      
 @DS-2     
  Scenario Outline: User runs "<TestcaseName>" in Try Editor
    Given User is on "<Page>" page
    When User clicks Try here gives the "<Code>" and clicks Run button
   # And User enters "<Code>" in the editor
    #And User clicks Run button
    Then User should see "<Result>"

    Examples:
    | TestcaseName | Page                           | Code                         | Result          |
    |  TC-01       | Time Complexity                | print('Numpy')               | Numpy           | 
    |  TC-02       | Time Complexity                | print('Time Complexity')     | Time Complexity |
    |  TC-03       | Time Complexity                | print('nump                  |  Error          |


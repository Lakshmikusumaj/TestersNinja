@DS-Intro @LaunchHome  @ValidLogin

Feature: User Navigates to the DataStructures-Introduction module

Background:
  Given User login and clicks the DataStructures-Intoduction module from the home page
    
  Scenario Outline: User navigates the Data Structures Introduction topics
    When User clicks "<Topic>" link
    Then User should be redirected to "<Page>"

    Examples:
      | Topic                        | Page                          |
      | Data Structures-Introduction | Data Structures Introduction  |  
      | Time Complexity              | Time Complexity page          |
      | Practice Questions           | Practice Questions page       |
      
  Scenario Outline: User runs code in Try Editor
    Given User is on "<Page>" page
    When User clicks "Try here >>>"
    And User enters "<Code>" in the editor
    And User clicks Run button
    Then User should see "<Result>"

    Examples:
      | Page                           | Code                         | Result          |
      |  Time Complexity               | print("Numpy")               | Numpy           | 
      |  Time Complexity               | print("Time Complexity")     | Time Complexity |
      |  Time Complexity               | print("nump                  | Error           |


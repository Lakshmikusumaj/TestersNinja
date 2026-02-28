@Graph @LaunchHome @ValidLogin
Feature: Validation graph home page

 Background: User navigate to the grpah page
   Given User is logged in to the DSAlgo portal and on graph page

  @Graph_0001
  Scenario Outline: User navigate to different topic page in graph module
  When User clicks "<TopicsCovered>" link in graph page
  Then user should be redirected to "<TopicsCovered>" graph page
   
   Examples:
     | TopicsCovered |       
     | Graph|
     | Graph Representations|
     
    
   @Graph_0002 
   Scenario Outline: User navigates to TryEditor page for Graph topic
    Given User is on "<TopicsCovered>" page in Graph module
    When User clicks Try Here button on respective topics covered link in graph
    Then User should be redirected to Try Editor page with Run button in the respective link of graph module

     Examples:
     | TopicsCovered         | 
     | Graph                 | 
     | Graph Representations |
  @Graph_0003
  Scenario Outline: User Excute valid code 
  Given User try editor page of graph 
  When User enters "<TestCode>" and clciks on the run button
  Then user should see "<ExpectedResult>"
   
    Examples:
    | TestCode          | ExpectedResult |
    | print('hello')    | hello          |
    | print('hello)     | Error          |
    | print(1+2)        | 3              |
   
   @Graph_0004
   Scenario Outline: User Navigate to practice Questions from Graph page
   Given the user is on the Graph page
   When the user clicks on the "Practice Questions" link
   Then the user should see the "Practice Questions" 

 
  
   

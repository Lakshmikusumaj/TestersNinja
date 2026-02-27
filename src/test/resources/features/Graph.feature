@LaunchHome @ValidLogin 
 Feature: Graph module


Background: User navigate to the grpah page
   Given User is logged in to the DSAlgo portal and on graph page

  @Graph_0001
  Scenario Outline: User navigate to different topic page in graph module
  When User clicks "<TopicCovered>" link in graph page
  Then user should be redirected to "<DestinationPage>" graph page
   
   Examples:
     | TopicsCovered         | DestinationPage       |
     | Graph                 | Graph                 |
     | Graph Representations | Graph Representations |
     
    
   @Graph_0002 
   Scenario Outline: User navigates to TryEditor page for Graph topic
    Given User is on "<TopicsCovered>" page in Graph module
    When User clicks Try Here button on respective topics covered link in graph
    Then User should be redirected to Try Editor page with Run button in the respective link of graph module

     Examples:
     | TopicsCovered         | 
     | Graph                 | 
     | Graph Representation  |
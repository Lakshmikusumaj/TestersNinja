@linkedlist @LaunchHome @ValidLogin
Feature: Validation of linkedlist module

  Background: User navigates to the linkedlist page
    Given User is logged in to the portal and on linkedlist page
    
  @linkedlist_0001
  Scenario:User navigates to different topic pages in linkedlist module
    # Given User is on the linkedlist page
    When User clicks "<TopicsCovered>" link in linkedlist page
    Then User should be redirected to "<DestinationPage>" linkedlist page
   Examples:
      | TopicsCovered         | DestinationPage                |
      | Introduction          | Introduction                   |
      | Creating Linked List  | Creating Linked List           |
      | Types of Linked List  | Types of Linked List           |
      | Implement Linked List | Implement Linked List in Python|
      | Traversal             | Traversal                      |
      | Insertion             | Insertion                      |
      | Deletion              | Deletion                       |
      
   @linkedlist_0002
   Scenario:User navigates to TryEditor page for linkedlist topic
     Given User is on "<TopicsCovered>" page in linkedlist module
     When User clicks Try Here button on respective topics covered link
     Then User should be redirected to Try Editor page with Run button in the respective link of linkedlist module

@linkedlist_0003
Scenario Outline: naviagte to "<Introduction>" page for Practice Questions
Given User is on the Introduction page
When User click on Practice Questions
Then User should redirected to Practice Questions

@linkedlist_0004
Scenario Outline: navigate to "<Indroduction>" page for Try here
Given User is on the Introduction page in linkedlist
When User clicks Try Here and enter "<TestCode>" on respective Introduction page in linkedlinst
Then User should be redirected to Try Editor page with Run button in the respective link of linkedlist 
  
   Examples:
    | TestCode          | ExpectedResult |
    | print('LINKLIST') | LINKLIST       |
    | print('hello)     | Error          |
    | print(1+5)        | 6              |
   



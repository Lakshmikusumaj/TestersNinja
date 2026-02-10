@Queue
Feature: Validation of Queue module

  Background: User navigates to the Queue page
    Given User is logged in to the DSAlgo portal and on Queue page
   
  @Queue_Test01
  Scenario Outline: User navigates to different topic pages in Queue module
    # Given User is on the Queue page
    When User clicks "<TopicsCovered>" link in Queue page
    Then User should be redirected to "<DestinationPage>" queue page

    Examples:
      | TopicsCovered                        | DestinationPage                  |
      | Implementations of Queue in Python   | implementation lists page        |
      | Implementation using collections deque | implementation collections page |
      | Implementation using array           | implementation array page        |
      | Queue operations                     | queue operations page            |

  @Queue_Test02
  Scenario Outline: User navigates to TryEditor page for Queue topics
    Given User is on "<TopicsCovered>" page in Queue module
    When User clicks Try Here button on respective Topics covered of Queue module
    Then User should be redirected to TryEditor page with Run button in the respective link of Queue

    Examples:
      | TopicsCovered                        |
      | Implementations of Queue in Python   |
      | Implementation using collections deque |
      | Implementation using array           |
      | Queue operations                     |

  @Queue_Test03
  Scenario Outline: Verify TryEditor with python code of Queue module
    Given User is on TryEditor page of Queue module
    When User enters python code from row <RowIndex> and clicks Run in Queue module
    Then User should see the output expected for the row <RowIndex> in Queue module
     Examples:
      | RowIndex |
      |0         |
      |1         |

  @Queue_Test04
  Scenario: Verify alert handling in try editor page of Queue
    Given User is on error alert in try editor page of Queue
    When User accepts the alert on queue page
    Then User should remain on TryEditor page of Queue

  @Queue_Test05
  Scenario: Verify navigation to Practice Questions page
    Given User is again on the Queue page
    When User clicks Practice Questions button on queue page
    Then User should see Practice Questions page

@Queue @LaunchHome @ValidLogin
Feature: Validation of Queue module

  Background: User navigates to the Queue page
    Given User is on the Queue page
   
  @Queue_Test01
  Scenario Outline: User navigates to different topic pages in Queue module
    # Given User is on the Queue page
    When User clicks "<TopicsCovered>" link in Queue page
    Then User should be redirected to "<TopicsCovered>" queue page

    Examples:
      | TopicsCovered                          |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array             |
      | Queue Operations                       |

  @Queue_Test02
  Scenario Outline: User navigates to TryEditor page for Queue topics
    Given User is on "<TopicsCovered>" page in Queue module
    When User clicks Try Here button on respective Topics covered of Queue module
    Then User should be redirected to TryEditor page with Run button in the respective link of Queue

    Examples:
      | TopicsCovered                          |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array             |
      | Queue Operations                       |

  @Queue_Test03
  Scenario Outline: Verify TryEditor with python code of Queue module
    Given TryEditor data for Queue module
    When User enters python code for testcase "<TestCaseName>" and clicks Run in Queue module
    Then User should see the output expected for the testcase "<TestCaseName>" in Queue module
    
     Examples:
      |TestCaseName          |
      | PythonCode_Valid		 |
      | PythonCode_Invalid	 |

  # @Queue_Test04
  # Scenario: Verify alert handling in try editor page of Queue
  #  Given User is on error alert in try editor page of Queue
  #  When User accepts the alert on queue page
  #  Then User should remain on TryEditor page of Queue

  @Queue_Test05
  Scenario: Verify navigation to Practice Questions page
    Given User is on any of the queue topic page
    When User clicks Practice Questions button on queue page
    Then User should see Practice Questions page

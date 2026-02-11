@Stack @LaunchHome @ValidLogin
Feature: Validation of Stack module

  Background: User navigates to the stack page
    Given User is logged in to the  DSAlgo portal and on stack page
    
  @Stack_Test01
  Scenario Outline: User navigates to different topic pages in Stack module
    # Given User is on the Stack page
    When User clicks "<TopicsCovered>" link in Stack page
    Then User should be redirected to "<DestinationPage>" stack page

    Examples:
      | TopicsCovered        | DestinationPage     |
      | Operations in Stack  | operations in stack |
      | Implementation       | implementation      |
      | Applications         | applications        |

  @Stack_Test02
  Scenario Outline: User navigates to TryEditor page for Stack topics
    Given User is on "<TopicsCovered>" page in Stack module
    When User clicks Try Here button on respective topics covered link
    Then User should be redirected to Try Editor page with Run button in the respective link of stack module

    Examples:
      | TopicsCovered        |
      | Operations in Stack  |
      | Implementation       |
      | Applications         |

  @Stack_Test03
  Scenario Outline: Verify TryEditor functionality with python code of stack module
    Given User is on Try Editor page of stack module
    When User enters python code from row <RowIndex> and clicks Run
    Then User should see the output expected for the row <RowIndex>
    Examples:
      | RowIndex |
      |0         |
      |1         |

  # @Stack_Test04
  # Scenario: Verify alert handling in try editor page of stack
  #   Given User is on error alert in try editor page of stack
  #   When User accepts the alert on stack page
  #   Then User should remain on Try Editor page of stack

  @Stack_Test05
  Scenario: Verify navigation to Practice Questions page of stack
    Given User is again on the Stack page
    When User clicks Practice Questions button on stack page
    Then User should see Practice Questions page of stack

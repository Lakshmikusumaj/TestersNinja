@Login
Feature: Login functionality for DS Algo portal

  Background: User navigates to login page
    Given User launches the browser and navigates to the login page

  @Login_DataDriven
  Scenario Outline: Validate login functionality using multiple test data
    Given User is on the Login page
    When User enters username and password from row <RowIndex> and clicks login button
    Then Login result should be as expected for the row <RowIndex>

    Examples:
      | RowIndex |
      | 0        |
      | 0        |
      | 1        |

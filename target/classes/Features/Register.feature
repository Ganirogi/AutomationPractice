Feature: Test register a new user

  Scenario Outline: Check register is successful for a new user
    Given browser is open
    And user is on register page
    When user enters <email>
    And user create account
    Then user is navigated to the home page

    Examples:
      | email                    |
      | testtestytc355gff@yahoo.com |
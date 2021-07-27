Feature: Test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters <email> and <password>
    Then user is navigated to the home page


    Examples:
      | email                    | password     |
      | testaccount000@gmail.com | testpassword |


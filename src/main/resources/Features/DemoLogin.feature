Feature: Verify login functionality

  Scenario Outline: Successful login

    Given browser is open and user is on login page
    When user enters <username> and <password>
    And user clicks on button
    Then user navigates to the profile page and <verify if logged>

    Examples:
      | username | password | verify if logged |
      | dedi.alex.121@gmail.com | parola123 | MY ACCOUNT |
      | test@gmail.com          | test123   | MY ACCOUNT |
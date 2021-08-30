Feature: Testing that we can order a product

  Scenario Outline: Buying products by diff colors

    Given opening browser and go to the main page
    When user selects the black or white blouse and it sets the color, <quantity> and <size> and <color>
    And user now must login with <username> and <password> to continue
    Then user finish his order

    Examples:
      | quantity | size | color | username                | password  |
      | 3        | S    | black | dedi.alex.121@gmail.com | parola123 |
      | 2        | M    | white | dinugv94@gmail.com      | P4ssword! |
Feature: Testing that we can order a product

  Scenario Outline: Buying products by diff colors

    Given opening browser and go to the main page
    When user selects the black or white blouse and it sets the color, <quantity> and <size> and <color>
    Then user finish his order

    Examples:
      | quantity | size | color |
      | 3        | S    | black |
      | 2        | M    | white |



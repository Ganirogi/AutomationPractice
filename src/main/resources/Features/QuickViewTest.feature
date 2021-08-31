Feature: test quick view
  Scenario Outline: test quick view

    Given openBrowserAndLogInWithCredentials <username> <password>
    When slectProdusChangeSizeAndQuantity <marime>
    Then goToCheckout

    Examples:
    |username|password|marime|
    |dinugv94@gmail.com|P4ssword!|1|
    |dedi.alex.121@gmail.com|parola123|2|

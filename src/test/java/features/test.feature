Feature:I found it at falabella
  As a user I want to buy a product at falabella.

  Scenario Outline: select a product at falabella
    Given user is on the page falabella
    When user types name of a "<product>" in search
    Then is redirected to the videogames section
    And user selects "<console>"
    And user selects add to bag and increases to two products
    And user selects extended "<warranty>"
    Then is redirected to the summary of your order
    And user selects go purchase
    And user chooses dispatch options "<region>" and "<comuna>"
    And user chooses option pick up purchase
    And user selects store and continue
    And user selects "<payment>" method
    Then user completes information "<name>""<lastName>""<email>""<id>""<phone>" and reserves the purchase


    Examples:

      | product | console        | warranty        | region               | comuna          | payment           | name | lastName | email                | id        | phone     |
      | consola | Xbox One S 1TB | 2 Años $ 32.990 | REGION METROPOLITANA | SANTIAGO CENTRO | Débito y efectivo | juan | perez    | juan.perez@gmail.com | 269961414 | 965330978 |




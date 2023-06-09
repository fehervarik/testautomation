@important
Feature: I want ot search a product on Tesco main page

  Rule: a list of the existed product

    @TC_search
    Scenario Outline: search and find product
      Given open main page
      When user search for product "<product>"
      Then it shows "<numOfProd>"

      Examples:
        | product | numOfProd  |
        | cukor   | 232 termék |
        | tej     | 135 termék |
    @TC_search_not_found
    Scenario Outline: search and could not find any product
      Given open main page
      When user search for product "<product>"
      Then it shows error message for "<product>"

      Examples:
        | product |
        | kasza   |

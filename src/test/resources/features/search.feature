Feature: I want ot search a product on Tesco main page

  Rule: a list of the existed product

    @TC_search
    Scenario: search and find product
      Given open main page
      When the user type in the search field "kristálycukor"
      Then it shows elements in productlist

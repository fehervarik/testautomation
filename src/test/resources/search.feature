Feature: I want ot search a product on Tesco main page

  Rule: a list of the existed product
    Background:
      Given open main page
      And accept cookies

     @TC_search
    Scenario Outline: search product
     Given click on search field
      When search after <products>
      Then it shows elements in <searchedProducts>
    Examples:
        |products       |serachedProducts|
        | kristálycukor |kristálycukor   |
        | 1234587       |Sajnos nem található olyan termék, amely a “1234587” keresési feltételnek megfelelne.|

Feature: I want ot change the language on Tesco MainPage.

  Rule: allow to change language

    Background:
      Given open main page
      And accept cookies

    @TC_ChangeLang
    Scenario Outline: Change language
      Given language is set to "<language>"
      When change the language to "<new_language>"
      Then it shows elements in "<new_language>"

      Examples:
        | language | new_language |
        | magyar   | angol        |
        | angol    | magyar       |
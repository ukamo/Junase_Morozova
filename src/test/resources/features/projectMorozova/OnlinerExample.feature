@web @test
Feature: As an user
  I want to get ability to add any good in basket

  Scenario Outline: Add good in basket
    Given the user opens Onliner website
    Then the user asserts Oniner website
    When the user clicks on Catalog section "<section>"
    Then the user asserts Catalog section
    When the user clicks on Catalog Classifier "<classifier>"
    Then the user asserts Catalog Classifier "<classifier>"
    When the user clicks on Section Item Catalog "<item>"
    Then the user asserts on Section Item Catalog
    When the user clicks on Product Link "<product>"
    Then the user asserts on Product Link "<product>"
    When the user clicks on Price Item Offer "<price item>"
    Then the user asserts on Price Item Offer "<price item>"
    When the user clicks on Add in Basket by First <number> Price
    Then the user asserts on Price
    When the user clicks on Basket button
    Then the user asserts on Basket page
    When the user asserts that the product is in Basket "<full name>"


    Examples:
      | section | classifier  | item        | product  | price item |number|full name
      | Каталог | Электроника | Аудиотехника| Наушники | AirPods 2 в зарядном футляре|1|Наушники Apple AirPods 2 в зарядном футляре

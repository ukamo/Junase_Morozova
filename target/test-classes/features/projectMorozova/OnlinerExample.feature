@web @test
Feature: As an user
  I want to get ability to add any good in basket

  Scenario Outline: Add good in basket
    Given the user opens Onliner website
    Then the user asserts Oniner website
    When the user clicks on Catalog section "Каталог"
    Then the user asserts Catalog section
    When the user clicks on Catalog Classifier "Электроника"
    Then the user asserts Catalog Classifier "Электроника"
    When the user clicks on Section Item Catalog "Аудиотехника"
    Then the user asserts on Section Item Catalog
    When the user clicks on Product Link "Наушники"
    Then the user asserts on Product Link "Наушники"
    When the user clicks on Price Item Offer "AirPods 2 в зарядном футляре"
    Then the user asserts on Price Item Offer "AirPods 2 в зарядном футляре"
    When the user clicks on Add in Basket by First 1 Price
    Then the user asserts on Price
    When the user clicks on Basket button
    Then the user asserts on Basket page
    When the user asserts that the product is in Basket "Наушники Apple AirPods 2 в зарядном футляре"


    Examples:
      | username | ap name                 | ap group id        | ap artifact id             | ap version id  |
      | admin    | TEST Automation Process | com.iba.samples.ap | kanclerrpa-invoiceplane-ap | 2.6.0-SNAPSHOT |

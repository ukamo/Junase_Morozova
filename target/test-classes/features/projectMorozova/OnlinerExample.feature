@web @test
Feature: As an user gets ability to select some good and add to basket

  Scenario Outline: Add good in basket
    Given the user opens Onliner website
    Then the user asserts Oniner website
    When the user clicks on Catalog section "Каталог"
    Then the user asserts Catalog section "Каталог"
    When the user clicks on Section Item Catalog "Аудиотехника"

    Examples:
      | username | ap name                 | ap group id        | ap artifact id             | ap version id  |
      | admin    | TEST Automation Process | com.iba.samples.ap | kanclerrpa-invoiceplane-ap | 2.6.0-SNAPSHOT |

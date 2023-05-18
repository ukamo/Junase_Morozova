@web @test
Feature: Web Demo - Create and Delete Automation Process in Web Application
  As a user
  I want to create Automation Process in Web Application, and then delete
  So that the Automation Process is successfully created and deleted

  Scenario Outline: Create and Delete Automation Process in Web Application
    Given the user opens Onliner website
    Then the user asserts Oniner website
    When the user clicks on Catalog section "Каталог"
    Examples:
      | username | ap name                 | ap group id        | ap artifact id             | ap version id  |
      | admin    | TEST Automation Process | com.iba.samples.ap | kanclerrpa-invoiceplane-ap | 2.6.0-SNAPSHOT |

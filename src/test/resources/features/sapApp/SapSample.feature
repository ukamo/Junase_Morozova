@sap

Feature: SAP Demo - New Invoice
  As a user
  I want to open Invoice page and validate document currency
  So that invoice page is successfully opened and the required currency is displayed

  Scenario Outline: New Invoice
    Given I open Invoice Page
    When I enter company code "<code>"
    Then I assert Document Currency is "<currency>"

    Examples:
      | code | currency |
      | 1000 | BYN      |
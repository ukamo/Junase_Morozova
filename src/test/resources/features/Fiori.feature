#Author Julia Morozova
@web @test

Feature: Get the numbers and type of documents received in Quotation field in application Sap
  As a user
  I want to add a some data in Quotation field in application Sap
  So that the data are successfully added

  Scenario Outline: Get the numbers and type of documents received
    Given I log in to application Fiori with username <username>
    Then I assert I am on screen Home in application Fiori
    When I set Search Create <service name> on screen Home in application Fiori
    Then I assert I am on screen Search in application Fiori
    And I assert container Create <service name> is displayed on screen Search in application Fiori
    When I click container Create <service name> on screen Search in application Fiori
    Then I assert I am on screen <service name> in application Fiori
    And I assert dialog <dialog name> is opened on screen <service name> in application Fiori
    And I assert table is displayed on dialog <dialog name> on screen <service name> in application Fiori
    And I assert table has 3 rows on dialog <dialog name> on screen <service name> in application Fiori
    When I click Transaction Type SRVP in table on dialog <dialog name> on screen <service name> in application Fiori
    Then I assert I am on screen <service name> in application Fiori
    #Then I assert tab Solution Quotation: New is opened on screen <service name> in application Sap
    #And I set <Description value> in field Description on tab Solution Quotation: New on screen <service name> in application Sap
    #And I set <Sold-to party value> in field Sold-to party on tab Solution Quotation: New on screen <service name> in application Sap
    #And I set <Contact value> in field Sold-to party on tab Solution Quotation: New on screen <service name> in application Sap
    #And I set <Employee value> in field Sold-to party on tab Solution Quotation: New on screen <service name> in application Sap
    #Then I assert I am on tab Select Organizational Data on screen <service name> in application Sap
    #When I navigate to Service – Dom. Service Org DE on tab Select Organizational Data on screen <service name> in application Sap
    #Then I assert I am on tab Partner Selection Document header on screen <service name> in application Sap
    #And I select string with checkbox on tab Partner Selection Document header on screen <service name> in application Sap
    #Then I assert tab Solution Quotation: New is opened on screen <service name> in application Sap


    Examples:
      | username  | service name            | dialog name             | Description value | Sold-to party value | Contact value | Employee value |
      | JMikitjuk | Service Order Quotation | Select Transaction Type | AKU_quote_01Exa   | 10100001            | 10910005      | 9980000163     |


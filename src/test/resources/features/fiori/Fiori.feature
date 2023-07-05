#Author Julia Morozova
@fiori

Feature: Release New Service Order Quotation in application Fiori
  As a user
  I want to add New Service Order Quotation in application Fiori
  So that the Service Order Quotation are successfully added

  Scenario Outline: Create New Service Order Quotation
    Given I log in to application Fiori with username "<login>"
    Then I assert I am on screen Home in application Fiori
    When I set search "Create Service Order Quotation" on screen Home in application Fiori
    Then I assert I am on screen Service Order Quotations in application Fiori
    And I assert dialog Select Transaction Type is opened on screen Service Order Quotations in application Fiori
    And I assert table is displayed on dialog Select Transaction Type on screen Service Order Quotations in application Fiori
    And I assert table has 3 rows on dialog Select Transaction Type on screen Service Order Quotations in application Fiori
    When I click Transaction Type "SRVP" in table on dialog Select Transaction Type on screen Service Order Quotations in application Fiori
    Then I assert I am on screen Service Order Quotations in application Fiori
    And I assert I am on table Solution Quotation: New on screen Service Order Quotations in application Fiori
    When I set value in Description field on tab Solution Quotation: New on screen Service Order Quotations in application Fiori
    And I set "10100001" value in Sold-To Party field on tab Solution Quotation: New on screen Service Order Quotations in application Fiori
    And I set "10910005" value in Contact field on tab Solution Quotation: New on screen Service Order Quotations in application Fiori
    And I set "9980000163" value in Employee field on tab Solution Quotation: New on screen Service Order Quotations in application Fiori
    Then I assert dialog Select Organizational Data is opened on screen Service Order Quotations in application Fiori
    And I assert table is displayed on dialog Select Organizational Data on screen Service Order Quotations in application Fiori
    And I assert table has 2 rows on dialog Select Organizational Data on screen Service Order Quotations in application Fiori
    When I click "Service – Dom. Service Org DE" in table on dialog Select Organizational Data on screen Service Order Quotations in application Fiori
    Then I assert dialog Partner Selection Document header is opened on screen Service Order Quotations in application Fiori
    #And I select string with checkbox on tab Partner Selection Document header on screen Service Order Quotations in application Fiori
    #Then I assert tab Solution Quotation: New is opened on screen <service name> in application Sap


    Examples:
      | login     |
      | JMikitjuk |


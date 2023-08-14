#Author Julia Morozova
@fiori

Feature: Release New Service Order Quotation in application Fiori
  As a user
  I want to add New Service Order Quotation in application Fiori
  So that the Service Order Quotation are successfully added

  Scenario Outline: Release New Service Order Quotation in application Fiori
    Given I log in to application Fiori with username "<login>"
    Then I assert I am on screen Home in application Fiori
    When I set search "Create Service Order Quotation" on screen Home in application Fiori
    Then I assert I am on screen Service Order Quotations in application Fiori
    And I assert dialog Select Transaction Type is opened on screen Service Order Quotations in application Fiori
    And I assert table is displayed on dialog Select Transaction Type on screen Service Order Quotations in application Fiori
    And I assert table has 3 rows on dialog Select Transaction Type on screen Service Order Quotations in application Fiori
    When I click hyperlink Transaction Type "SRVP" in the table on dialog Select Transaction Type on screen Service Order Quotations in application Fiori
    Then I assert dialog Select Transaction Type is closed on screen Service Order Quotations in application Fiori
    And I assert I am on screen Service Order Quotations in application Fiori
    And I assert I am on tab Quotation Details on screen Service Order Quotations in application Fiori
    When I set Description as random string on tab Quotation Details on screen Service Order Quotations in application Fiori
    And I set Sold-To Party "10100001" on tab Quotation Details on screen Service Order Quotations in application Fiori
    And I set Contact "10910005" on tab Quotation Details on screen Service Order Quotations in application Fiori
    And I set Employee "9980000163" on tab Quotation Details on screen Service Order Quotations in application Fiori
    Then I assert dialog Select Organizational Data is opened on screen Service Order Quotations in application Fiori
    And I assert table is displayed on dialog Select Organizational Data on screen Service Order Quotations in application Fiori
    And I assert table has 2 rows on dialog Select Organizational Data on screen Service Order Quotations in application Fiori
    When I click hyperlink Service Organization "Dom. Service Org DE" in the table on dialog Select Organizational Data on screen Service Order Quotations in application Fiori
    Then I assert dialog Select Organizational Data is closed on screen Service Order Quotations in application Fiori
    And I assert dialog Partner Selection Document header is opened on screen Service Order Quotations in application Fiori
    And I assert table is displayed on dialog Partner Selection Document header on screen Service Order Quotations in application Fiori
    And I assert table has 4 rows on dialog Partner Selection Document header on screen Service Order Quotations in application Fiori
    When I select row with checked checkbox in Default column in table on dialog Partner Selection Document header on screen Service Order Quotations in application Fiori
    Then I assert dialog Partner Selection Document header is closed on screen Service Order Quotations in application Fiori
    And I assert I am on tab Quotation Details on screen Service Order Quotations in application Fiori
    When I switch to tab Items on screen Service Order Quotations in application Fiori
    Then I assert I am on tab Items on screen Service Order Quotations in application Fiori
    And I assert table is displayed on tab Items on screen Service Order Quotations in application Fiori
    When I set Product ID "BUND01" in row 1 in table on tab Items on screen Service Order Quotations in application Fiori
    And I set Quantity "1" in row 1 in table on tab Items on screen Service Order Quotations in application Fiori
    And I check checkbox in column Select in table on tab Items on screen Service Order Quotations in application Fiori
    And I click button Save on tab Items on screen Service Order Quotations in application Fiori
    Then I assert button Details is presented on screen Service Order Quotations in application Fiori
    When I click button Details on footer on screen Service Order Quotations in application Fiori
    And I assert message with pattern "Transaction ([0-9]+) saved" is displayed on screen Service Order Quotations in application Fiori
    And I store Transaction number on screen Service Order Quotations in application Fiori
    And I click button Back on screen Service Order Quotations in application Fiori
    Then I assert I am on screen Home in application Fiori
    When I switch to tab Subscription Management on screen Home in application Fiori
    And I click hyperlink Manage Solution Quotations on screen Home in application Fiori
    Then I assert I am on screen Service Order Quotations in application Fiori
    When I set Transaction number on Service Order Quotation ID on screen Service Order Quotations in application Fiori
    And I click button Search on screen Service Order Quotations in application Fiori
    Then I assert I am on tab Quotation Details on screen Service Order Quotations in application Fiori
    #When I click button Edit on tab Quotation Details on screen Service Order Quotations in application Fiori
    #And I switch to tab Items on screen Service Order Quotations in application Fiori
    #Then I assert I am on tab Items on screen Service Order Quotations in application Fiori
    #When I click button Release All Items on tab Items on screen Service Order Quotations in application Fiori
    #Then I assert record with Product ID "BUND01" has Status "Released" in table on tab Items on screen Service Order Quotations in application Fiori

    Examples:
      | login     |
      | JMikitjuk |
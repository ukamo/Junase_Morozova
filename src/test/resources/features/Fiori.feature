#Author Julia Morozova
#@web @test

Feature: Add some data in Quotation field in application Sap
  As a user
  I want to add a some data in Quotation field in application Sap
  So that the data are successfully added

  Scenario Outline: Add some data in Quotation field in application Sap
    Given I am on screen Logon in application Sap
    When I log on to application Sap with username <username>
    Then I assert I am on screen Home in application Sap
    When I set <service name> in field Search on screen Home in application Sap
    When I switch to <service name> on screen Home in application Sap
    Then I assert I am on screen <service name> in application Sap
    And I assert modal window <modal name> is opened on screen <service name> in application Sap
    When I navigate to type SRVP on modal window <modal name> on screen <service name> in application Sap
    Then I assert I am on screen <service name> in application Sap
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
      | username  | service name                   | modal name              | Description value | Sold-to party value | Contact value | Employee value |
      | JMikitjuk | Create Service Order Quotation | Select Transaction Type | AKU_quote_01Exa   | 10100001            | 10910005      | 9980000163     |


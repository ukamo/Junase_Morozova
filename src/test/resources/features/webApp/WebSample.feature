@web
Feature: Web Demo - Create and Delete Automation Process in Web Application
  As a user
  I want to create Automation Process in Web Application, and then delete
  So that the Automation Process is successfully created and deleted

  Scenario Outline: Create and Delete Automation Process in Web Application
    Given I login to application with user "<username>"
    When I navigate to screen Automation Processes
    Then I assert I am on screen Automation Processes
    When I click button CREATE NEW on screen Automation Processes
    Then I assert I am on screen New Automation Process
    When I set Name "<ap name>" on screen New Automation Process
    And I set Group Id "<ap group id>" on screen New Automation Process
    And I set Artifact Id "<ap artifact id>" on screen New Automation Process
    And I set Version Id "<ap version id>" on screen New Automation Process
    And I click button CREATE NEW on screen New Automation Process
    Then I assert I am on screen Automation Process Details
    When I click Back to list on screen Automation Process Details
    Then I assert I am on screen Automation Processes
    When I set Filter by text "<ap name>" on screen Automation Processes
    Then I assert table has 1 rows on screen Automation Processes
    When I check checkbox in header in table on screen Automation Processes
    And I click button Delete on screen Automation Processes
    And I assert message "Are you sure you want to delete selected automation process?" is displayed on dialog on screen Automation Processes
    When I click button Delete on dialog on screen Automation Processes
    And I assert table is empty on screen Automation Processes

    Examples:
      | username | ap name                 | ap group id        | ap artifact id             | ap version id  |
      | admin    | TEST Automation Process | com.iba.samples.ap | kanclerrpa-invoiceplane-ap | 2.6.0-SNAPSHOT |
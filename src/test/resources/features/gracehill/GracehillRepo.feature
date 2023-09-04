#Author Julia Morozova
@gracehill

Feature: Add New Repo Item (SCORM) in application Gracehill
  As a user
  I want to add New Repo Item in application Gracehill
  So that the Repo item is successfully added

  Scenario Outline: Add New Repo Item (SCORM) in application Gracehill
    Given I log in to application Gracehill with username "<login>"
    Then I assert I am on screen Vision LMS in application Gracehill
    When I navigate to menu item REPOSITORY on screen Vision LMS in application Gracehill
    Then I assert I am on tab REPOSITORY on screen Vision LMS in application Gracehill
    And I assert table is displayed on tab REPOSITORY on screen Vision LMS in application Gracehill
    When I click hyperlink Repository "IBA_VL" in the table on tab REPOSITORY on screen Vision LMS in application Gracehill
    Then I assert I am on tab IBA_VL on screen Vision LMS in application Gracehill
    When I click button New on tab IBA_VL on screen Vision LMS in application Gracehill
    Then I assert I am on container New Repo Item on screen Vision LMS in application Gracehill
    When I upload file on container New Repo Item on screen Vision LMS in application Gracehill
    And I add Name today's date on container New Repo Item on screen Vision LMS in application Gracehill
    And I store Name of repo item on container New Repo Item on screen Vision LMS in application Gracehill
    And I click button Submit on container New Repo Item on screen Vision LMS in application Gracehill
    Then I assert I am on tab Name of repo item on screen Vision LMS in application Gracehill
    Examples:
      | login  |
      | vletp2 |
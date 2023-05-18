@desktop

Feature: Desktop Demo - Create a File in Notepad
  As a user
  I want to create a file in Notepad using Desktop Driver, set text and clear file
  So that Notepad file becomes empty

  Scenario Outline: Create a file in Notepad, set text and clear file
    Given I open application Notepad
    When I set "<text>" in new file in application Notepad
    And I clear file in new file in application Notepad
    Then I assert file is empty in application Notepad

    Examples:
      | text                                                                          |
      | JUNASE Solution automates all your applications testing within one framework. |
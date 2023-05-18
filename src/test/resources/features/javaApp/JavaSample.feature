@java

Feature: Java Demo - Login to Java Application
  As a user
  I want to log in to Java Application
  So that the login is successful

  Scenario Outline: Login with to app and assert success window
    Given I login to java application
    When I set user "<username>" in java application
    And I set password "<password>" in java application
    And I click button Login in java application
    Then I assert message Login Success is displayed in java application

    Examples:
      | username | password |
      | bob      | secret   |
@mobile

Feature: Mobile Demo - Login to Gmail and Send Email
  As a user
  I want to log in to application and send an email
  So that email is sent successfully

  Scenario Outline: Login to application and send email
    Given I navigate to Gmail on screen Welcome in application Gmail
    When I click button Got on screen Welcome in application Gmail
    Then I assert user "<userName>" is displayed on screen Welcome in application Gmail
    And I assert email "<userAddress>" is displayed on screen Welcome in application Gmail
    When I click button Take Me To Gmail on screen Welcome in application Gmail
    Then I assert User is displayed on screen Main in application Gmail
    And I assert button New Email is displayed on screen Main in application Gmail
    When I click button New Email on screen Main in application Gmail
    And I click button Ok on alert message on screen Main in application Gmail
    Then I assert email "<userAddress>" is displayed on screen Compose in application Gmail
    When I set email "<userAddressTo>" on screen Compose in application Gmail
    And I set subject "Test Subject" on screen Compose in application Gmail
    And I click button Send on screen Compose in application Gmail
    Then I assert User is displayed on screen Main in application Gmail
    And I assert Subject is displayed on screen Main in application Gmail

    Examples:
      | userName | userAddress          | userAddressTo        |
      | Iba Test | testiba026@gmail.com | testiba026@gmail.com |
@logoutFeature
Feature: Logout function

  @Positive @Regression
  Scenario: To ensure logout from website
    Given user already login into website
    When user click side menu
    And user click logout
    Then user successfully logout
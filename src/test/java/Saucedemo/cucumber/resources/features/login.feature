@loginFeature
Feature: Login function

  @Positive @Regression
  Scenario: To ensure login using valid credentials
    Given user open the website
    When user input valid username
    And input valid password
    And user click login
    Then user should see products page

  @Negative @Regression
  Scenario: To ensure login failed using invalid credentials
    Given user open the website
    When user input invalid username
    And input invalid password
    And user click login
    Then user should see error message

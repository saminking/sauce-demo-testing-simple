@FilteringFeature
Feature: Filter function

  @Positive @Regression
  Scenario: verify able to filter product using name (A-Z)
    Given user is on product page
    When user click filter box on the the right side and user click name a till z
    Then user see the product already sorted by A-Z

  @Positive @Regression
  Scenario: verify able to filter product using name (Z-A)
    Given user is on product page
    When user click filter box on the the right side and user click name Z till A
    Then user see the product already sorted by Z-A

  @Positive @Regression
  Scenario: verify able to filter product using Price (Low-High)
    Given user is on product page
    When user click filter box on the the right side and user click price low to high
    Then user see the product already sorted Low-High

  @Positive @Regression
  Scenario: verify able to filter product using Price (High-Low)
    Given user is on product page
    When user click filter box on the the right side and user click price high to low
    Then user see the product already sorted High-Low
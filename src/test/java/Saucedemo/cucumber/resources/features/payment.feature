@PaymentFeature
Feature: Payment function

  @Positive @Regression
  Scenario: verify able to buy product
    Given user already login in the website
    When user click AddToCart button on the product column
    And user click cart icon on the top right side
    And click the checkout button
    And user fill the biodata form
    And user click continue button
    And user finish overview shopping list
    Then user should see checkout complete page


  @Negative @Regression
  Scenario: Verify unable to buy product without input buyer biodata
    Given user already login in the website
    When user click AddToCart button on the product column
    And user click cart icon on the top right side
    And click the checkout button
    And user click continue button without fill the form
    Then user will see error message in form page
Feature: Testing the functionality of the category navigation button
  As a user I want to be able to navigate to the category page using by clicking the navigation button

  Scenario: Successfully navigated to the category page
    Given The welcome page is loaded
    When I click the category navigation button
    Then I should be redirected to the category page
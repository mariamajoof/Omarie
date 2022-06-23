Feature: Testing the Actor navigation functionality
  As a user I will like to be redirected to the actor name page

  Scenario: Successfully navigated to the  actor name page
    Given The landing page is loaded
    When I click the Actor name navigation button
    Then I should be navigated to the actor name page
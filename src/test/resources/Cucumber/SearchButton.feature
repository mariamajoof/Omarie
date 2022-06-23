Feature: Check search button functionality

  Scenario: Clicking the search button to successfully display requested data.
    Given That the search button is display
    When I click the search button
    Then Display the requested data
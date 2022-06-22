Feature: Add a new actor
  as a user I would like to add a new actor

#  Scenario: I successfully added an actor into my table
#    Given I have the actor information
#    When The user first name equals "Peter"
#    And The last name equals "pete"
#    Then The system return "Saved"

  Scenario: I successfully added an actor into my table
    Given I have the actor information
    When I added the actor to the database
    Then The system return "Saved"

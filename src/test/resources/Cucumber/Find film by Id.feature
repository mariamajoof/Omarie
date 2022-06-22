Feature: Find film by Id
  as a user I would like to  find a film by typing in the film Id



  Scenario: I successfully get the film title from the database
    Given I have the film Id
    When I get the film title from the database
    Then The system return  the film "title"

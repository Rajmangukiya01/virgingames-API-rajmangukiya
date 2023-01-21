Feature: Virgin Games bingo

  Scenario: As a user I want to test the data of virgin games bingo api
    When I can send Get request to the Lobby feed endpoint
    And I get Valid Status code is "200"
    Then I can verify streamName is "SuperlinksVirgin"

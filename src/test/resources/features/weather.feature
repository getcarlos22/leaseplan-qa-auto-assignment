@Id1.1
Feature: Looking up present weather
    As a user
    I should be able to get details of the present weather

  @PositiveScenario
  Scenario Outline: "Looking up present weather" response schema should match with present location
    When I call the get weather endpoint for location <Place Name>
    Then weather details should be retrieved
    And the schema should match with the specification defined in "weather.json"
    And the weather response should have details for location <Place Name>
    Examples:
      | Place Name    |
      | New York City |
      | Beverly Hills |
      | Marseille 01  |

  @NegativeScenario
  Scenario Outline: "Looking up present weather" response schema and details should match with specification without token
    When I call the get weather endpoint for location <Place Name>
    Then the schema should match with the specification defined in "weather_error.json"
    And the weather response success status should be false
    And the weather response error code should be "101" and error type should be "missing_token"
    Examples:
      | Place Name    |
      | New York City |
      | Beverly Hills |
      | Marseille 01  |

  @NegativeScenario
  Scenario Outline: "Looking up present weather" response schema and details should match with specification for invalid location
    When I call the get weather endpoint for location <Place Name>
    Then the schema should match with the specification defined in "weather_error.json"
    And the weather response success status should be false
    And the weather response error code should be "101" and error type should be "missing_token"
    Examples:
      | Place Name    |
      | amcuwomnssdsd |

  @NegativeScenario
  Scenario Outline: "Looking up present weather" response schema and details should match with specification with invalid token
    When I call the get weather endpoint for location <Place Name>
    Then the schema should match with the specification defined in "weather_error.json"
    And the weather response success status should be false
    And the weather response error code should be "615" and error type should be "missing_token"
    Examples:
      | Place Name    |
      | New York City |
      | Beverly Hills |
      | Marseille 01  |

  @NegativeScenario
  Scenario: "Looking up present weather" response schema and details should match with specification for empty location
    When I call the get weather endpoint for location ""
    Then the schema should match with the specification defined in "weather_error.json"
    And the weather response success status should be false
    And the weather response error code should be "601" and error type should be "missing_query"





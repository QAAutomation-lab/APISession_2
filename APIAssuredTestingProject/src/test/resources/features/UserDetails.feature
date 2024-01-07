Feature: This feature file is use to validate user data

  Scenario: Create user data
    Given user has valid request URL
    And all required parameters are also available
    When user hits post method
    Then validate response status
    And validate response line
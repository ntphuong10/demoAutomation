Feature: API Test Feature

  @TC_03 @smoke @api
  Scenario Outline: login
    Given I have an user
    And I call API Login-Successful with user "<user>" and password "<password>"
    Then The API should return status <status> and error "<error>"
    Examples:
      | user               | password   | status | error                     |
      | eve.holt@reqres.in | cityslicka | 200    |                           |
      | eve.holt@reqres.in |            | 400    | Missing password          |
      |                    | cityslicka | 400    | Missing email or username |

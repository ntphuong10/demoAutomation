Feature: Login API feature

  @TC_03 @smoke @api
  Scenario Outline: Login into the user
    Given I have an user
    When I call API to login into the user with user "<user>" and password "<password>"
    Then The API should return status <status> and error "<error>"
    Examples:
      | user               | password   | status | error                     |
      | eve.holt@reqres.in | cityslicka | 200    |                           |
      | eve.holt@reqres.in |            | 400    | Missing password          |
      |                    | cityslicka | 400    | Missing email or username |

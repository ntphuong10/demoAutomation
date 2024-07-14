Feature: API Test Feature

  Background:
    Given I have an user
    And I call API Login-Successful
    Then The API should return status 200

  @TC_05 @smoke @api
  Scenario Outline: get list user
    When I call API get list User with page "<page>"
    Then API should return status <status> and have <quantity user> user
    Examples:
      | page | quantity user | status |
      |      | 6             | 200    |
      | 2    | 6             | 200    |
      | 3    | 0             | 200    |
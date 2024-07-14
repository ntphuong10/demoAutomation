Feature: Get list feature

  Background:
    Given I have an user
    When I call API to login into the user
    Then The API should return status 200

  @TC_05 @smoke @api
  Scenario Outline: Get list user
    When I call API to get list of users with page "<page>"
    Then API should return status <status> and have <quantity user> user
    Examples:
      | page | quantity user | status |
      | 100  | 0             | 200    |
      | 2    | 6             | 200    |
      | 3    | 0             | 200    |
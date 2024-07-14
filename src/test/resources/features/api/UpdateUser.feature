Feature: API Test Feature

  Background:
    Given I have an user
    And I call API to login into the user
    Then The API should return status 200

  @TC_06 @smoke @api
  Scenario Outline: Update user
    Then I call API to update the "<number>" user with "<name>" and "<job>"
    Examples:
      | number | name  | job     |
      | 5      |       |         |
      | 1      | @@@   | manager |
      | 6      | 213df | BA      |
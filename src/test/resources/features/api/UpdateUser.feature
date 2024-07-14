Feature: API Test Feature

  Background:
    Given I have an user
    And I call API Login-Successful
    Then The API should return status 200

  @TC_06 @smoke @api
  Scenario Outline: Update user
    Then I call API to update the "<number>" user with "<name>" and "<job>"
    Examples:
      | number | name   | job     |
      | 5      | Phuong | tester  |
      | 1      | Chinh  | manager |
      | 6      | phuc   | BA      |
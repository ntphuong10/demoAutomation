Feature: Login Test Feature

  Background:
    Given I have an user
    When I call API to login into the user
    Then The API should return status 200

  @TC_04  @e2e @api
  Scenario Outline:
    Given I have an user
    When I call API to get list of users with page "<page>"
    Then API should return status <status> and have <quantity user> user
    When I call API to get a random user
    Then I call API to update the user's name as "<name>" and job as "<job>"
    Examples:
      | name       | job             | page | quantity user | status |
      | thu phuong | automation test | 2    | 6             | 200    |
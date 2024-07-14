Feature: Login Test Feature

  Background:
    Given I have an user
    And I call API Login-Successful
    Then The API should return status 200

  @TC_04  @e2e @api
  Scenario Outline:
    Given I have an user
    When I call API get list User with page "<page>"
    Then API should return status <status> and have <quantity user> user
    And I call API get a User random
    And I call API update name user is "<name>" and job is "<job>"
    Examples:
      | name       | job             | page | quantity user | status |
      | thu phuong | automation test | 2    | 6             | 200    |
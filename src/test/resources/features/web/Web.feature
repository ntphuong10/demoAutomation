Feature: Demo Ctflearn

  Background:
    Given Go to the website
    When I click on the login button
    Then I can login with username "thuphuong13110" and password "123456"

  @TC_01 @smoke @challenge @web @testcase
  Scenario Outline: Create A Challenge
    Given Go to "Create A Challenge" Page
    When Input title "<title>", flag "<flag>", file "<file>" and how to solve "<howtosolve>"
    And Click on submit button and check error "<error>" if existing
    Then Click on the logout button
    Examples:
      | title    | flag         | file    | howtosolve               | error                                              |
      | autotest | flagAutotest | default | autotestautotestautotest |                                                    |
      | autotest | flagAutotest | default | autotest                 | Field must be between 20 and 2048 characters long. |

  @TC_02  @e2e @challenge @web @testcase
  Scenario Outline: Create A Challenge
    Given Go to "Create A Challenge" Page
    When Input title "<title>", flag "<flag>", file "<file>" and how to solve "<howtosolve>"
    And Click on submit button and check error "<error>" if existing
    And Go to "My Challenge" Page
    Then A Challenge just created displays
    And Click on the logout button
    Examples:
      | title    | flag         | file    | howtosolve               | error |
      | autotest | flagAutotest | default | autotestautotestautotest |       |

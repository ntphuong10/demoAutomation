Feature: Demo Ctflearn

  Background:
    Given Go to website
    And Click login button
    And Login with username "thuphuong13110" and password "123456"

  @TC_01 @smoke @challenge @web @testcase
  Scenario Outline: Create A Challenge
    Given Go to "Create A Challenge" Page
    When Input title "<title>", flag "<flag>", file "<file>" and how to solve "<howtosolve>"
    And Click submit button and check error "<error>" if exist
    Then Click Logout button
    Examples:
      | title    | flag         | file    | howtosolve               | error                                              |
      | autotest | flagAutotest | default | autotestautotestautotest |                                                    |
      | autotest | flagAutotest | default | autotest                 | Field must be between 20 and 2048 characters long. |

  @TC_02  @e2e @challenge @web @testcase
  Scenario Outline: Create A Challenge
    Given Go to "Create A Challenge" Page
    When Input title "<title>", flag "<flag>", file "<file>" and how to solve "<howtosolve>"
    And Click submit button and check error "<error>" if exist
    And Go to "My Challenge" Page
    Then A Challenge just create display
    When Click Logout button
    Examples:
      | title    | flag         | file    | howtosolve               | error |
      | autotest | flagAutotest | default | autotestautotestautotest |       |

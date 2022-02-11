Feature: Robobar cart

  Scenario: user add one cola
    Given user opens robobar website
    When user add a cola
    Then total should be €1.25

  Scenario: user add two colas
    Given user opens robobar website
    When user add a cola
    And user add a cola
    Then total should be €2.50

  Scenario: user add two colas
    Given user opens robobar website
    * user add a cola
    * user add a cola
    * total should be €2.50

  Scenario: user add one beer
    Given user opens robobar website
    When user add a beer
    Then total should be €2.00

  Scenario: user add one beer and age is 17
    Given user opens robobar website
    When user add a beer
    Then total should be €2.00
    And user press submit button
    And user enter her age is 17
    And user press order button
    Then alert is active

  Scenario: user add one beer and age is 20
    Given user opens robobar website
    When user add a beer
    Then total should be €2.00
    And user press submit button
    And user enter her age is 20
    And user press order button
    Then alert is not active
    Then order is confirmed

  Scenario Outline: user buys several colas
    Given user opens robobar website
    When user adds <n> cola
    Then total should be €<total>
    Examples:
      | n | total |
      | 1 | 1.25  |
      | 2 | 2.50  |
      | 3 | 3.75  |

  Scenario Outline: user buys several drinks
    Given user opens robobar website
    When user adds <arg0> cola adds <arg1> beer adds <arg2> wine
    Then total should be €<total>
    Examples:
      | arg0 | arg1 | arg2 | total |
      | 1    | 0    | 0    | 1.25  |
      | 0    | 1    | 0    | 2.00  |
      | 0    | 0    | 1    | 3.00  |
      | 1    | 1    | 0    | 3.25  |
      | 0    | 1    | 1    | 5.00  |
      | 1    | 0    | 1    | 4.25  |
      | 1    | 1    | 1    | 6.25  |

  Scenario Outline: user buys several drinks and finish
    Given user opens robobar website
    When user adds <arg0> cola adds <arg1> beer adds <arg2> wine
    Then total should be €<total>
    And user check out
    And user is <age> years old
    But checkout result is "<expected>"
    Examples:
      | arg0 | arg1 | arg2 | total | age | expected |
      | 1    | 0    | 0    | 1.25  | 17  | pass     |
      | 0    | 1    | 0    | 2.00  | 17  | fail     |
      | 0    | 0    | 1    | 3.00  | 17  | fail     |
      | 1    | 1    | 0    | 3.25  | 17  | fail     |
      | 0    | 1    | 1    | 5.00  | 17  | fail     |
      | 1    | 0    | 1    | 4.25  | 17  | fail     |
      | 1    | 1    | 1    | 6.25  | 17  | fail     |

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
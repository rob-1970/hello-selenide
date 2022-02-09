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

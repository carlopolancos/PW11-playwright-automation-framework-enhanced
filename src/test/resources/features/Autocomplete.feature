@regression @autocomplete @smoke
Feature: WebdriverUniversity.com - Autocomplete Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the autocomplete link

  Scenario Outline: Verify Autocomplete Acceptance Function
    And I type on the food item textbox letter <letter>
    And I click on the first autocomplete suggestion
    Then The food item textbox should have value <value>
    Examples:
      | letter | value     |
      | a      | Asparagus |
      | b      | Bruscetta |
      | c      | Cabbage   |
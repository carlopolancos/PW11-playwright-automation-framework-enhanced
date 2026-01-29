@regression @accordion @smoke
Feature: WebdriverUniversity.com - Accordion Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the accordion & text effects link

  Scenario Outline: Verify Instant Accordion Function
    And I click the accordion button '<buttonName>'
    Then The text '<text>' should appear
    Examples:
      | buttonName         | text                          |
      | Manual Testing     | Manual testing has for        |
      | Cucumber BDD       | Cucumber (BDD) simplifies the |
      | Automation Testing | Automation testing has been   |

  Scenario: Verify Time-Based Accordion Function
    And I click the accordion button 'Keep Clicking! - Text will Appear After 5 Seconds!'
    Then The text 'This text has appeared after 5 seconds!' should appear after 5 seconds
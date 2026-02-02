@regression @hidden-elements @smoke
Feature: WebdriverUniversity.com - Hidden Elements Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the hidden elements link

  Scenario Outline: Verify Element ID removal using playwright
    And Button <buttonName> is not visible
    And Remove the ID attribute on the parent container <parentContainer>
    Then Button <buttonName> should be visible
    Examples:
      | buttonName | parentContainer    |
      | #button1   | #not-displayed     |
      | #button2   | #visibility-hidden |
      | #button3   | #zero-opacity      |

  #Cant run JavaScript, broken site
#  Scenario Outline: Verify Element ID removal using javascript
#    And Button <buttonName> is not visible
#    And Override the parent container <parentContainer> CSS property using JavaScript
#    Then Button <buttonName> should be visible
#    Examples:
#      | buttonName | parentContainer    |
#      | #button1   | #not-displayed     |
#      | #button2   | #visibility-hidden |
#      | #button3   | #zero-opacity      |
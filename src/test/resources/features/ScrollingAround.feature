@regression @scrolling-around @smoke
Feature: WebdriverUniversity.com - Actions Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the scrolling around link

  Scenario: Verify Element Hover Function
    And Hover on the top element
    And Hover on the left element
    And Hover on the right element
    And Hover on the left element
    And Hover on the bottom element
    Then The correct text will be displayed for all elements
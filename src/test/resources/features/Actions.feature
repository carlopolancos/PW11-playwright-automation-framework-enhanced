@regression @actions @smoke
Feature: WebdriverUniversity.com - Actions Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the actions link

  Scenario: Verify Element Drag Function
    And Drag the draggable element to the target
    Then The target will have the correct content Dropped!

  Scenario: Verify Double Click Function
    And Double click on the element
    Then The target will have a new class double

  Scenario Outline: Verify Hover and Click Function
    And On hovered element <hoverElement>, click on element '<clickElement>'
    Then The correct dialog will appear
    Examples:
      | hoverElement | clickElement           |
      | 1            | > div > a              |
      | 2            | > div > a              |
      | 3            | > div > a:nth-child(1) |
      | 3            | > div > a:nth-child(2) |
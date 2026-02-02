@regression @popup-and-alerts @smoke
Feature: WebdriverUniversity.com - Actions Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the popup and alerts link

  Scenario: Verify JavaScript Alert Handling Function
    And Click on the "javascript alert" button
    Then The correct javascript alert will appear

  Scenario: Verify Modal Popup Handling Function
    And Click on the "modal popup" button
    Then The correct modal popup will appear

  Scenario: Verify Page Redirection Handling Function
    And Click on the "ajax loader" button
    Then The page is redirected to ajax loading page

  Scenario: Verify JavaScript Alert Confirmation Handling Function
    And Click on the "javascript confirm" button
    Then The text "You pressed OK!" will be visible
@regression @ajax-loader @smoke
Feature: WebdriverUniversity.com - Choice Page

  Scenario: Verify Checkbox Selection Function
    Given I navigate to the webdriveruniversity homepage
    When I click on the ajax loader link
    And Wait for the span element before clicking it
    Then The correct modal will appear
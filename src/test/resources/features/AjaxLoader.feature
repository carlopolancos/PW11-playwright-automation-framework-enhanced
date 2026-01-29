@regression @ajax-loader @smoke
Feature: WebdriverUniversity.com - Ajax Loader Page

  Scenario: Verify Locator Wait Function
    Given I navigate to the webdriveruniversity homepage
    When I click on the ajax loader link
    And Wait for the span element before clicking it
    Then The correct modal will appear
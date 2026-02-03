@regression @datepicker @smoke
Feature: WebdriverUniversity.com - Datepicker Page

  Scenario: Verify Datepicker Functionality
    Given I navigate to the webdriveruniversity homepage
    When I click on the datepicker link
    And The initial value should be today
    And I choose a specific date
    Then The datepicker should be updated with the new value
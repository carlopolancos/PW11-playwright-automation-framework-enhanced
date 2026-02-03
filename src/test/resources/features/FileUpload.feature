@regression @file-upload @smoke
Feature: WebdriverUniversity.com - File Upload Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the file upload link

  Scenario Outline: Verify File Upload Function
    And I upload the file '<fileName>'
    And I click the submit file button
    Then The correct alert '<alert>' will be displayed
    Examples:
      | fileName                   | alert                                |
      | ./jenkins instructions.txt | Your file has now been uploaded!     |
      |                            | You need to select a file to upload! |

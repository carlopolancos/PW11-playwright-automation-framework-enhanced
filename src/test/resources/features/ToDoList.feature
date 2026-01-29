@regression @todo-list @smoke
Feature: WebdriverUniversity.com - To-Do List Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the to do list link
    And I create a new task "Sample Task !?#"

  Scenario: Verify To Do Task Creation
    Then The new task "Sample Task !?#" should be added to the list

  Scenario: Verify To Do Task Completion
    And I completed the task "Sample Task !?#"
    Then The task "Sample Task !?#" should be marked as completed

  Scenario: Verify To Do Task Deletion
    And I deleted the task "Sample Task !?#"
    Then The task "Sample Task !?#" should not exist
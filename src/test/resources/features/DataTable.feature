@regression @data-table
Feature: WebdriverUniversity.com - Data Table Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the data table link

  Scenario Outline: Verify Data Reading Function on Tables
    And Read data on table <tableName>
    Then The file created from table <tableName> will have the correct content
    @smoke
    Examples:
      | tableName             |
      | #t01                  |
    Examples:
      | tableName             |
      | #t02                  |
      | table.traversal-table |

  @smoke
  Scenario: Verify Data Reading Function on Text Inputs
    And Input Carlo on First name textbox
    And Input Polancos on Last name textbox
    And Input on Input text box resizable:
    """
    Open Bind
    Delete Corrode
    Delete Abyss
    Open Breeze
    Study Split
    Open Pearl
    Open Haven
    """
    Then All text inputs should have correct values

  Scenario Outline: Verify Page Redirection Function
    And Link <linkName> is clicked
    Then I am brought back to the top of the page
    @smoke
    Examples:
      | linkName |
      | Home     |
      | Forward  |
      | 1        |
      | Link     |
    Examples:
      | linkName |
      | About    |
      | 2        |
      | 3        |
      | 4        |
      | 5        |
      | Backward |

  @smoke
  Scenario Outline: Verify Badges Reading Function
    Then List item "<listItemName>" should have badge '<badge>'
    Examples:
      | listItemName  | badge |
      | Today's Deals | 5     |
      | All Products  | 20    |

  Scenario Outline: Verify Button States Function
    Then Button <buttonName> should have state <state>
    @smoke
    Examples:
      | buttonName | state    |
      | Link       | enabled  |
      | Warning    | disabled |
      | Button-1   | active   |
    Examples:
      | buttonName | state    |
      | Button     | enabled  |
      | Input      | enabled  |
      | Submit     | enabled  |
      | Reset      | enabled  |
      | Danger     | enabled  |
      | Info       | enabled  |
      | Alert      | enabled  |
      | Button-2   | enabled  |
      | Button-3   | enabled  |
      | Button-4   | enabled  |

  Scenario Outline: Verify Lists Reading Function
    And Read list <listName> values
    Then List <listName> should have the correct values
    @smoke
    Examples:
      | listName              |
      | traversal-drinks-list |
      | traversal-food-list   |
      | traversal-job-list  |

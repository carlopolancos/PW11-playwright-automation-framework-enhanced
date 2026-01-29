@regression @choice @smoke
Feature: WebdriverUniversity.com - Choice Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the choice link

  Scenario Outline: Verify Dropdown Selection Function
    And The initial selected value for dropdown <dropdown> is <initialValue>
    And I choose <newValue> as its new value for dropdown <dropdown>
    Then The <newValue> should be displayed for dropdown <dropdown>
    Examples:
      | dropdown | initialValue | newValue |
      | 1        | JAVA         | C#       |
      | 2        | Eclipse      | TestNG   |
      | 3        | HTML         | JQuery   |

  Scenario: Verify Checkbox Selection Function
    And Only checkbox 3 is initially checked
    And I click all checkboxes
    Then Only checkbox 3 is unchecked

  Scenario: Verify Radiobutton Selection Function
    And No radiobutton is initially checked
    And I click all radiobuttons
    Then Only radiobutton purple is checked

  Scenario: Verify Disabled Selection Function
    And Radiobutton pumpkin is selected and grape is selected from dropdown
    And I try to select other radiobutton and select option
    Then Verify that specific radiobutton and select option are disabled
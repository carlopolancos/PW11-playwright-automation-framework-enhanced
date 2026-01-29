@regression @page-object-model @smoke
Feature: WebdriverUniversity.com - PageObjectModel Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the pageObjectModel link

  Scenario Outline: Verify Home and Our Products Tab
    And I click the tab '<tabName>'
    And I click the '<text>'
    Then The correct modalHeader '<modalHeader>' should appear
    Examples:
      | tabName      | text            | modalHeader                                                              |
      | Home         | Find Out More!  | Welcome to webdriveruniversity.com                                       |
      | Our Products | Special Offers  | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Cameras         | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | New Laptops     | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Used Laptops    | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Game Consoles   | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Components      | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Desktop Systems | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Audio           | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |

  Scenario: Verify Contact Us Tab
    And I click the tab 'Contact Us'
    Then I am redirected to Contact Us page
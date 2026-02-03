@regression @iframe
Feature: WebdriverUniversity.com - Iframe Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the iframe link

  Scenario Outline: Verify Iframe Home and Our Products Tab
    And On the iframe, i click the tab '<tabName>'
    And On the iframe, i click the '<text>'
    Then On the iframe, the correct modalHeader '<modalHeader>' should appear
    @smoke
    Examples:
      | tabName      | text            | modalHeader                                                              |
      | Home         | Find Out More!  | Welcome to webdriveruniversity.com                                       |
    Examples:
      | tabName      | text            | modalHeader                                                              |
      | Our Products | Special Offers  | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Cameras         | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | New Laptops     | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Used Laptops    | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Game Consoles   | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Components      | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Desktop Systems | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |
      | Our Products | Audio           | SPECIAL OFFER! - GET 30% OFF YOUR FIRST ORDER AT WEBDRIVERUNIVERSITY.COM |

  @smoke
  Scenario: Verify Contact Us Tab
    And On the iframe, i click the tab 'Contact Us'
    Then On the iframe, i am redirected to Contact Us page
@regression @button-clicks
Feature: WebdriverUniversity.com - Button Clicks Page

  Background: Pre Conditions
    Given I navigate to the webdriveruniversity homepage
    When I click on the button clicks link

  Scenario Outline: Verify Button Clicks
    And I click the button '<button>'
    Then I should be presented with a modal which contains text '<modalHeader>'
    Examples:
      | button      | modalHeader                                                |
      | CLICK ME!   | Congratulations!                                           |
      | CLICK ME!!  | It’s that Easy!!  Well I think it is.....                  |
      | CLICK ME!!! | Well done! the Action Move & Click can become very useful! |

  Scenario Outline: Verify Button Clicks using Playwright, CSS, or XPath
    And I click the button '<button>' using <method>
    Then I should be presented with a modal which contains text '<modalHeader>'
  @smoke
    Examples:
      | button      | method     | modalHeader                                                |
      | CLICK ME!   | playwright | Congratulations!                                           |
      | CLICK ME!!  | css        | It’s that Easy!!                                           |
      | CLICK ME!!! | xpath      | Well done! the Action Move & Click can become very useful! |

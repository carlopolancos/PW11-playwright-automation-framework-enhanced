Feature: WebdriverUniversity.com - Contact Us Page

  Scenario: Valid Contact Us Form Submission
    Given I navigate to the webdriveruniversity homeage
    When I click on the contact us button
    And I type a firstname
    And I tpye a lastname
    And I enter an email address
    And I type a comment
    And I click the submit button
    Then I should be presented with a successful contact us submission message
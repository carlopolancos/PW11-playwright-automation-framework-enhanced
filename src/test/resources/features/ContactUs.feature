@regression @contact-us
Feature: WebdriverUniversity.com - Contact Us Page

  Background: Pre Conditions=
    Given I navigate to the webdriveruniversity homepage
    When I click on the contact us button


  Scenario: Valid Contact Us Form Submission
    And I type a firstname
    And I type a lastname
    And I enter an email address
    And I type a comment
    And I click the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Invalid Contact Us Form Submission
    And I type a firstname
    And I type a lastname
#    And I enter an email address
    And I type a comment
    And I click the submit button
    Then I should be presented with an unsuccessful contact us submission message

  Scenario: Valid Contact Us Form Submission - Using Specific Data
    And I type a specific firstname "Sarah"
    And I type a specific lastname "Woods"
    And I enter a specific email address "sarah_woods@example.com"
    And I type a specific comment "Hello world" with the number 2
    And I click the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Valid Contact Us Form Submission - Using Random Data
    And I type a random firstname
    And I type a random lastname
    And I enter a random email address
    And I type a comment
    And I click the submit button
    Then I should be presented with a successful contact us submission message

  @smoke @ignore
  Scenario Outline: Validate Contact Us Page
    And I type a first name <firstName> and a last name <lastName>
    And I type an email address '<emailAddress>' and a comment '<comment>'
    And I click the submit button
    Then I should be presented with header text '<message>'
    Examples:
      | firstName | lastName | emailAddress              | comment                 | message                      |
      | John      | Jones    | john_jones@example.com    | hello how are you?      | Thank You for your Message!  |
      | Mia       | Carter   | mia_carter123@example.com | Test123 Test123         | Thank You for your Message!  |
      | Grace     | Hudson   | grace hudson              | Do you create websites? | Error: Invalid email address |
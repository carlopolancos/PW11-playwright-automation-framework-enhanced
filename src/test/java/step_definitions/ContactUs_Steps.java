package step_definitions;

import browser.BrowserManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsPage;

public class ContactUs_Steps {

    private final ContactUsPage contactUsPage;

    public ContactUs_Steps (ContactUsPage contactUsPage) {
        this.contactUsPage = contactUsPage;
    }

    @When("I type a firstname")
    public void i_type_a_firstname() {
        contactUsPage.typeFirstName("Joe");
    }

    @When("I type a lastname")
    public void i_type_a_lastname() {
        contactUsPage.typeLastName("Blogs");
    }

    @When("I enter an email address")
    public void i_enter_an_email_address() {
        contactUsPage.typeEmailAddress("joe_blogs@example.com");
    }

    @When("I type a comment")
    public void i_type_a_comment() {
        contactUsPage.typeComment("Hello World!!");
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        contactUsPage.clickSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        contactUsPage.verifySuccessfulSubmissionMessage();
    }

    @Then("I should be presented with an unsuccessful contact us submission message")
    public void i_should_be_presented_with_an_unsuccessful_contact_us_submission_message() {
        contactUsPage.verifyUnsuccessfulSubmissionMessage();
    }

    @Then("I should be presented with header text {string}")
    public void i_should_be_presented_with_header_text(String message) {
        contactUsPage.verifyHeaderText(message);
    }

    //CUCUMBER EXPRESSIONS
    @When("I type a specific firstname {string}")
    public void i_type_a_specific_firstname(String firstName) {
        contactUsPage.typeFirstName(firstName);
    }

    @When("I type a specific lastname {string}")
    public void i_type_a_specific_lastname(String lastName) {
        contactUsPage.typeLastName(lastName);
    }

    @When("I type a first name {word} and a last name {word}")
    public void i_type_a_first_name_john_and_a_last_name_jones(String firstName, String lastName) {
        contactUsPage.typeFirstName(firstName);
        contactUsPage.typeLastName(lastName);
    }

    @When("I enter a specific email address {string}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        contactUsPage.typeEmailAddress(emailAddress);
    }

    @When("I type a specific comment {string} with the number {int}")
    public void i_type_a_specific_comment(String comment, Integer number) {
        contactUsPage.typeComment(comment + " " + number);
    }

    @When("I type an email address {string} and a comment {string}")
    public void i_type_an_email_address_and_a_comment(String emailAddress, String comment) {
        contactUsPage.typeEmailAddress(emailAddress);
        contactUsPage.typeComment(comment);
    }

    //RANDOMS
    @When("I type a random firstname")
    public void i_type_a_random_firstname() {
        contactUsPage.typeRandomFirstName();
    }

    @When("I type a random lastname")
    public void i_type_a_random_lastname() {
        contactUsPage.typeRandomLastName();
    }

    @When("I enter a random email address")
    public void i_enter_a_random_email_address() {
        contactUsPage.typeRandomEmailAddress();
    }

    @When("I type a random comment")
    public void i_type_a_random_comment() {
        contactUsPage.typeRandomComment();
    }
}

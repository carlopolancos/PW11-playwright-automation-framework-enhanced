package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsPage;

public class ContactUsSteps {

    private final ContactUsPage contactUsPage;

    public ContactUsSteps(ContactUsPage contactUsPage) {
        this.contactUsPage = contactUsPage;
    }

    @When("I type a firstname")
    public void iTypeAFirstname() {
        contactUsPage.typeFirstName("Joe");
    }

    @When("I type a lastname")
    public void iTypeALastname() {
        contactUsPage.typeLastName("Blogs");
    }

    @When("I type an email address")
    public void iTypeAnEmailAddress() {
        contactUsPage.typeEmailAddress("joe_blogs@example.com");
    }

    @When("I type a comment")
    public void iTypeAComment() {
        contactUsPage.typeComment("Hello World!!");
    }

    @When("I click the submit button")
    public void iClickTheSubmitButton() {
        contactUsPage.clickSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionMessage() {
        contactUsPage.verifySuccessfulSubmissionMessage();
    }

    @Then("I should be presented with an unsuccessful contact us submission message")
    public void iShouldBePresentedWithAnUnsuccessfulContactUsSubmissionMessage() {
        contactUsPage.verifyUnsuccessfulSubmissionMessage();
    }

    @Then("I should be presented with header text {string}")
    public void iShouldBePresentedWithHeaderText(String message) {
        contactUsPage.verifyHeaderText(message);
    }

    //CUCUMBER EXPRESSIONS
    @When("I type a specific firstname {string}")
    public void iTypeASpecificFirstname(String firstName) {
        contactUsPage.typeFirstName(firstName);
    }

    @When("I type a specific lastname {string}")
    public void iTypeASpecificLastname(String lastName) {
        contactUsPage.typeLastName(lastName);
    }

    @When("I type a first name {word} and a last name {word}")
    public void iTypeAFirstNameAndALastName(String firstName, String lastName) {
        contactUsPage.typeFirstName(firstName);
        contactUsPage.typeLastName(lastName);
    }

    @When("I type a specific email address {string}")
    public void iTypeASpecificEmailAddress(String emailAddress) {
        contactUsPage.typeEmailAddress(emailAddress);
    }

    @When("I type a specific comment {string} with the number {int}")
    public void iTypeASpecificCommentWithNumber(String comment, Integer number) {
        contactUsPage.typeComment(comment + " " + number);
    }

    @When("I type an email address {string} and a comment {string}")
    public void iTypeAnEmailAddressAndAComment(String emailAddress, String comment) {
        contactUsPage.typeEmailAddress(emailAddress);
        contactUsPage.typeComment(comment);
    }

    //RANDOMS
    @When("I type a random firstname")
    public void iTypeARandomFirstname() {
        contactUsPage.typeRandomFirstName();
    }

    @When("I type a random lastname")
    public void iTypeARandomLastname() {
        contactUsPage.typeRandomLastName();
    }

    @When("I type a random email address")
    public void iTypeARandomEmailAddress() {
        contactUsPage.typeRandomEmailAddress();
    }

    @When("I type a random comment")
    public void iTypeARandomComment() {
        contactUsPage.typeRandomComment();
    }
}

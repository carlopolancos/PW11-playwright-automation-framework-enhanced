package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import org.testng.Assert;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.*;
import static org.testng.Assert.assertTrue;

public class ContactUs_Steps {

    public BrowserManager browserManager;
    public Faker faker = new Faker();

    public ContactUs_Steps (BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @When("I type a firstname")
    public void i_type_a_firstname() {
        browserManager.page.getByPlaceholder("First Name").fill("Joe");
    }

    @When("I type a specific firstname {string}")
    public void i_type_a_specific_firstname(String firstName) {
        browserManager.page.getByPlaceholder("First Name").fill(firstName);
    }

    @When("I type a random firstname")
    public void i_type_a_random_firstname() {
        String randomFirstName = faker.name().firstName();
        browserManager.page.getByPlaceholder("First Name").fill(randomFirstName);
    }

    @When("I type a lastname")
    public void i_type_a_lastname() {
        browserManager.page.getByPlaceholder("Last Name").fill("Blogs");
    }

    @When("I type a specific lastname {string}")
    public void i_type_a_specific_lastname(String lastName) {
        browserManager.page.getByPlaceholder("Last Name").fill(lastName);
    }

    @When("I type a random lastname")
    public void i_type_a_random_lastname() {
        String randomLastName = faker.name().lastName();
        browserManager.page.getByPlaceholder("Last Name").fill(randomLastName);
    }

    @When("I type a first name {word} and a last name {word}")
    public void i_type_a_first_name_john_and_a_last_name_jones(String firstName, String lastName) {
        browserManager.page.getByPlaceholder("First Name").fill(firstName);
        browserManager.page.getByPlaceholder("Last Name").fill(lastName);
    }

    @When("I enter an email address")
    public void i_enter_an_email_address() {
        browserManager.page.getByPlaceholder("Email Address").fill("joe_blogs@example.com");
    }

    @When("I enter a specific email address {string}")
    public void i_enter_a_specific_email_address(String emailAddress) {
        browserManager.page.getByPlaceholder("Email Address").fill(emailAddress);
    }

    @When("I enter a random email address")
    public void i_enter_a_random_email_address() {
        String randomEmailAddress = faker.internet().emailAddress();
        browserManager.page.getByPlaceholder("Email Address").fill(randomEmailAddress);
    }

    @When("I type an email address {string} and a comment {string}")
    public void i_type_an_email_address_and_a_comment(String emailAddress, String comment) {
        browserManager.page.getByPlaceholder("Email Address").fill(emailAddress);
        browserManager.page.getByPlaceholder("Comments").fill(comment);
    }

    @When("I type a comment")
    public void i_type_a_comment() {
        browserManager.page.getByPlaceholder("Comments").fill("Hello World!!");
    }

    @When("I type a specific comment {string} with the number {int}")
    public void i_type_a_specific_comment(String comment, Integer number) {
        browserManager.page.getByPlaceholder("Comments").fill(comment + " " + number);
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        String selector = "input[value='SUBMIT']";
        browserManager.page.waitForSelector(selector);
        browserManager.page.locator(selector).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        Locator locator = browserManager.page.locator("#contact_reply > h1");
        assertThat(locator).isVisible();
        assertThat(locator).hasText("Thank You for your Message!");
    }

    @Then("I should be presented with an unsuccessful contact us submission message")
    public void i_should_be_presented_with_an_unsuccessful_contact_us_submission_message() {
        Locator locator = browserManager.page.locator("body");
        assertThat(locator).isVisible();
        String bodyText = locator.innerText();
        Pattern pattern = Pattern.compile("Error: (all fields are required!|Invalid email address)");
        Matcher matcher = pattern.matcher(bodyText);
        assertTrue(matcher.find(), "The body text does not match the expected error message. \nFound text: " + bodyText);
    }

    @Then("I should be presented with header text {string}")
    public void i_should_be_presented_with_header_text(String message) {
        browserManager.page.waitForSelector("//h1 | //body");
        Locator locator = browserManager.page.locator("//h1 | //body");
        List<String> texts = locator.allInnerTexts();
        String foundText = "";
        boolean found = false;
        for (String text : texts) {
            if (text.contains(message)) {
                foundText = text;
                found = true;
                break;
            } else {
                foundText = text;
            }
        }
        assertTrue(found, "The element does not contain the expected message. " +
                "\nExpected message: " + foundText + " to be equal to: " + message);
    }
}

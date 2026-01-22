package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.*;

public class ContactUs_Steps {

    public BrowserManager browserManager;

    public ContactUs_Steps (BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @When("I type a firstname")
    public void i_type_a_firstname() {
        browserManager.page.getByPlaceholder("First Name").fill("Joe");
    }

    @When("I tpye a lastname")
    public void i_tpye_a_lastname() {
        browserManager.page.getByPlaceholder("Last Name").fill("Blogs");
    }

    @When("I enter an email address")
    public void i_enter_an_email_address() {
        browserManager.page.getByPlaceholder("Email Address").fill("joe_blogs@example.com");
    }

    @When("I type a comment")
    public void i_type_a_comment() {
        browserManager.page.getByPlaceholder("Comments").fill("Hello World!!");
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
}

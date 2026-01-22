package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

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
        System.out.println("TO DO 4");
    }

    @When("I enter an email address")
    public void i_enter_an_email_address() {
        System.out.println("TO DO 5");
    }

    @When("I type a comment")
    public void i_type_a_comment() {
        System.out.println("TO DO 6");
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        System.out.println("TO DO 7");
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        System.out.println("TO DO 8");
    }
}

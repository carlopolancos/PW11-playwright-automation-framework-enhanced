package step_definitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccordionPage;
import pages.PageObjectModelPage;

public class Accordion_Steps {

    private final AccordionPage accordionPage;

    public Accordion_Steps(AccordionPage accordionPage) {
        this.accordionPage = accordionPage;
    }

    @When("I click the accordion button {string}")
    public void i_click_the_accordion_button(String buttonName) {
        accordionPage.clickAccordionButton(buttonName);
    }

    @Then("The text {string} should appear")
    public void the_text_should_appear(String expectedText) {
        accordionPage.verifyAppearedText(expectedText);
    }

    @Then("The text {string} should appear after {int} seconds")
    public void the_text_should_appear_after_seconds(String expectedText, int seconds) {
        accordionPage.verifyAppearedTextAfterSeconds(expectedText, seconds);
    }
}

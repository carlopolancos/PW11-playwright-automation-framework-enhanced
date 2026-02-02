package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccordionPage;

public class AccordioSteps {

    private final AccordionPage accordionPage;

    public AccordioSteps(AccordionPage accordionPage) {
        this.accordionPage = accordionPage;
    }

    @When("I click the accordion button {string}")
    public void iClickTheAccordionButton(String buttonName) {
        accordionPage.clickAccordionButton(buttonName);
    }

    @Then("The text {string} should appear")
    public void theTextShouldAppear(String expectedText) {
        accordionPage.verifyAppearedText(expectedText);
    }

    @Then("The text {string} should appear after {int} seconds")
    public void theTextShouldAppearAfterSeconds(String expectedText, int seconds) {
        accordionPage.verifyAppearedTextAfterSeconds(expectedText, seconds);
    }
}

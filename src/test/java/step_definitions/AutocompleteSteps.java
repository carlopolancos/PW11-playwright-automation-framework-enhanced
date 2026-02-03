package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccordionPage;
import pages.AutocompletePage;

public class AutocompleteSteps {

    private final AutocompletePage autocompletePage;

    public AutocompleteSteps(AutocompletePage autocompletePage) {
        this.autocompletePage = autocompletePage;
    }

    @When("I type on the food item textbox letter {word}")
    public void iTypeOnTheFoodItemTextboxLetter(String letter) {
        autocompletePage.typeLetterTextbox(letter);
    }

    @When("I click on the first autocomplete suggestion")
    public void iClickOnTheFirstAutoCompleteSuggestion() {
        autocompletePage.clickOnFirstAutocompleteSuggestion();
    }

    @Then("The food item textbox should have value {word}")
    public void theFoodItemTextboxShouldHaveValue(String value) {
        autocompletePage.verifyTextboxValue(value);
    }
}

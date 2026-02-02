package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ScrollingAroundPage;

public class ScrollingAround_Steps {

    private final ScrollingAroundPage scrollingAroundPage;

    public ScrollingAround_Steps(ScrollingAroundPage scrollingAroundPage) {
        this.scrollingAroundPage = scrollingAroundPage;
    }

    @When("Hover on the {word} element")
    public void hoverOnElement(String element) {
        scrollingAroundPage.hoverElement(element);
    }

    @Then("The the correct text will be displayed for all elements")
    public void the_correct_text_will_be_displayed_for_all_elements() {
        scrollingAroundPage.verifyDisplayedTextForAllElements();
    }
}

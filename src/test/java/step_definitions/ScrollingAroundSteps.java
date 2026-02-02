package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ScrollingAroundPage;

public class ScrollingAroundSteps {

    private final ScrollingAroundPage scrollingAroundPage;

    public ScrollingAroundSteps(ScrollingAroundPage scrollingAroundPage) {
        this.scrollingAroundPage = scrollingAroundPage;
    }

    @When("Hover on the {word} element")
    public void hoverOnElement(String element) {
        scrollingAroundPage.hoverElement(element);
    }

    @Then("The correct text will be displayed for all elements")
    public void theCorrectTextWillBeDisplayedForAllElements() {
        scrollingAroundPage.verifyDisplayedTextForAllElements();
    }
}

package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AjaxLoaderPage;
import pages.ChoicePage;

public class AjaxLoader_Steps {

    private final AjaxLoaderPage ajaxLoaderPage;

    public AjaxLoader_Steps(AjaxLoaderPage ajaxLoaderPage) {
        this.ajaxLoaderPage = ajaxLoaderPage;
    }

    @When("Wait for the span element before clicking it")
    public void wait_for_the_span_element_before_clicking_it() {
        ajaxLoaderPage.waitThenClickTheSpanElement();
    }

    @Then("The correct modal will appear")
    public void the_correct_modal_will_appear() {
        ajaxLoaderPage.verifyCorrectModalAppeared();
    }
}

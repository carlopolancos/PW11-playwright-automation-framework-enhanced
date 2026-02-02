package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AjaxLoaderPage;

public class AjaxLoaderSteps {

    private final AjaxLoaderPage ajaxLoaderPage;

    public AjaxLoaderSteps(AjaxLoaderPage ajaxLoaderPage) {
        this.ajaxLoaderPage = ajaxLoaderPage;
    }

    @When("Wait for the span element before clicking it")
    public void waitForTheSpanElementBeforeClickingIt() {
        ajaxLoaderPage.waitThenClickTheSpanElement();
    }

    @Then("The correct modal will appear")
    public void theCorrectModalWillAppear() {
        ajaxLoaderPage.verifyCorrectModalAppeared();
    }
}

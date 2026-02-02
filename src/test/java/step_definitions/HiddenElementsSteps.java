package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AjaxLoaderPage;
import pages.HiddenElementsPage;

public class HiddenElementsSteps {

    private final HiddenElementsPage hiddenElementsPage;

    public HiddenElementsSteps(HiddenElementsPage hiddenElementsPage) {
        this.hiddenElementsPage = hiddenElementsPage;
    }

    @When("Button {word} is not visible")
    public void buttonIsNotVisible(String buttonName) {
        hiddenElementsPage.verifyButtonNotVisible(buttonName);
    }

    @When("Remove the ID attribute on the parent container {word}")
    public void removeTheIDAttributeOnTheParentContainer(String parentContainer) {
        hiddenElementsPage.removeIDAttribute(parentContainer);
    }

    @When("Override the parent container {word} CSS property using JavaScript")
    public void overrideTheParentContainerCSSPropertyUsingJavaScript(String parentContainer) {
        hiddenElementsPage.overrideIDAttribute(parentContainer);
    }

    @Then("Button {word} should be visible")
    public void buttonShouldBeVisible(String buttonName) {
        hiddenElementsPage.verifyButtonIsVisible(buttonName);
    }
}

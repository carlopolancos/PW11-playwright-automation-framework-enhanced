package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ActionsPage;
import pages.AjaxLoaderPage;

public class Actions_Steps {

    private final ActionsPage actionsPage;

    public Actions_Steps(ActionsPage actionsPage) {
        this.actionsPage = actionsPage;
    }

    @When("Drag the draggable element to the target")
    public void drag_the_draggable_element_to_the_target() {
        actionsPage.dragElementToTarget();
    }

    @When("Double click on the element")
    public void double_click_on_the_element() {
        actionsPage.doubleClickOnElement();
    }

    @When("On hovered element {word}, click on element {string}")
    public void hover_then_click_on_element(String hoverElement, String clickOnElement ) {
        actionsPage.hoverThenClickOnElement(hoverElement, clickOnElement);
    }

    @Then("The target will have the correct content {word}")
    public void the_target_will_have_the_correct_content(String expectedContent) {
        actionsPage.verifyTargetContent(expectedContent);
    }

    @Then("The target will have a new class {word}")
    public void the_target_will_have_a_new_class(String expectedNewClass) {
        actionsPage.verifyElementNewClass(expectedNewClass);
    }

    @Then("The correct dialog will appear")
    public void the_correct_dialog_will_appear() {
        actionsPage.verifyCorrectDialogAppears();
    }
}

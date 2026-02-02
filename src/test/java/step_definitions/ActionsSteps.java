package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ActionsPage;

public class ActionsSteps {

    private final ActionsPage actionsPage;

    public ActionsSteps(ActionsPage actionsPage) {
        this.actionsPage = actionsPage;
    }

    @When("Drag the draggable element to the target")
    public void dragTheDraggableElementToTheTarget() {
        actionsPage.dragElementToTarget();
    }

    @When("Double click on the element")
    public void doubleClickOnTheElement() {
        actionsPage.doubleClickOnElement();
    }

    @When("On hovered element {word}, click on element {string}")
    public void onHoveredElementClickOnElement(String hoverElement, String clickOnElement) {
        actionsPage.hoverThenClickOnElement(hoverElement, clickOnElement);
    }

    @When("Hold click on the element")
    public void holdClickOnTheElement() {
        actionsPage.holdClickOnElement();
    }

    @Then("The target will have the correct content {word}")
    public void theTargetWillHaveTheCorrectContent(String expectedContent) {
        actionsPage.verifyTargetContent(expectedContent);
    }

    @Then("The target will have a new class {word}")
    public void theTargetWillHaveANewClass(String expectedNewClass) {
        actionsPage.verifyElementNewClass(expectedNewClass);
    }

    @Then("The correct dialog will appear")
    public void theCorrectDialogWillAppear() {
        actionsPage.verifyCorrectDialogAppears();
    }

    @Then("Element will have text {string} while clicked")
    public void elementWillHaveTextWhileClicked(String expectedText) {
        actionsPage.elementWillHaveTextWhileClicked(expectedText);
    }

    @Then("Element will have text {string} when hold click is released")
    public void elementWillHaveTextWhenHoldClickIsReleased(String expectedText) {
        actionsPage.elementWillHaveTextWhenHoldClickIsReleased(expectedText);
    }
}

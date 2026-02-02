package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ButtonClicksPage;

public class ButtonClicksSteps {

    private final ButtonClicksPage buttonClicksPage;

    public ButtonClicksSteps(ButtonClicksPage buttonClicksPage) {
        this.buttonClicksPage = buttonClicksPage;
    }

    @When("I click the button {string}")
    public void iClickTheButton(String name) {
        buttonClicksPage.clickOnTheButton(name);
    }

    @When("I click the button {string} using {word}")
    public void iClickTheButtonUsing(String name, String method) {
        buttonClicksPage.clickOnTheButton(name, method);
    }

    @Then("I should be presented with a modal which contains text {string}")
    public void iShouldBePresentedWithAModalWhichContainsText(String modalHeader) {
        buttonClicksPage.verifyClickedButton(modalHeader);
    }
}

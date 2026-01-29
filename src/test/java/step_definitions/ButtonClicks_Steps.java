package step_definitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ButtonClicksPage;
import pages.LoginPage;

public class ButtonClicks_Steps {

    private final ButtonClicksPage buttonClicksPage;

    public ButtonClicks_Steps (ButtonClicksPage buttonClicksPage) {
        this.buttonClicksPage = buttonClicksPage;
    }

    @When("I click the button {string}")
    public void i_click_the_button(String name) {
        buttonClicksPage.clickOnTheButton(name);
    }

    @When("I click the button {string} using {word}")
    public void i_click_the_button(String name, String method) {
        buttonClicksPage.clickOnTheButton(name, method);
    }

    @Then("I should be presented with a modal which contains text {string}")
    public void i_should_be_presented_with_a_modal_which_contains_text(String modalHeader) {
        buttonClicksPage.verifyClickedButton(modalHeader);
    }
}

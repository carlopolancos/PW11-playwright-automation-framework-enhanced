package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PopupAndAlertsPage;

public class PopupAndAlertsSteps {

    private final PopupAndAlertsPage popupAndAlertsPage;

    public PopupAndAlertsSteps(PopupAndAlertsPage popupAndAlertsPage) {
        this.popupAndAlertsPage = popupAndAlertsPage;
    }

    @When("Click on the {string} button")
    public void clickOnButton(String buttonName) {
        popupAndAlertsPage.clickButton(buttonName);
    }

    @Then("The correct javascript alert will appear")
    public void theCorrectJavaScriptAlertWillAppear() {
        popupAndAlertsPage.verifyJavaScriptAlert();
    }

    @Then("The correct modal popup will appear")
    public void theCorrectModalPopupWillAppear() {
        popupAndAlertsPage.verifyModalPopupContent();
    }

    @Then("The page is redirected to ajax loading page")
    public void thePageIsRedirectedToAjaxLoadingPage() {
        popupAndAlertsPage.verifyRedirectionToAjaxLoadingPage();
    }

    @Then("The text {string} will be visible")
    public void theTextWillBeVisible(String confirmationText) {
        popupAndAlertsPage.verifyJavaScriptConfirmation(confirmationText);
    }
}

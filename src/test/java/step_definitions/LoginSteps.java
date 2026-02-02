package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @When("I type a username {word}")
    public void iTypeAUsername(String username) {
        loginPage.typeUserName(username);
    }

    @When("I type a password {word}")
    public void iTypeAPassword(String password) {
        loginPage.typePassword(password);
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be presented with an alert box which contains text {string}")
    public void iShouldBePresentedWithAnAlertBoxWhichContainsText(String expectedAlertText) {
        loginPage.verifyUserValidationStatus(expectedAlertText);
    }
}

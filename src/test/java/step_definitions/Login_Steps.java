package step_definitions;

import browser.BrowserManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

public class Login_Steps {

    private static final Logger log = LoggerFactory.getLogger(Login_Steps.class);
    private final LoginPage loginPage;

    public Login_Steps (LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @When("I type a username {word}")
    public void i_type_a_username_webdriver(String username) {
        loginPage.typeUserName(username);
    }

    @When("I type a password {word}")
    public void i_type_a_password_webdriver123(String password) {
        loginPage.typePassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be presented with an alert box which contains text {string}")
    public void i_should_be_presented_with_an_alert_box_which_contains_text(String expectedAlertText) {
        loginPage.verifyUserValidationStatus(expectedAlertText);
    }
}

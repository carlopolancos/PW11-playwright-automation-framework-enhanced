package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.options.AriaRole.*;
import static org.testng.Assert.assertEquals;

public class Login_Steps {

    public BrowserManager browserManager;
    public String alertText;

    public Login_Steps (BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @When("I type a username {word}")
    public void i_type_a_username_webdriver(String username) {
        browserManager.page.getByRole(TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill(username);
    }

    @When("I type a password {word}")
    public void i_type_a_password_webdriver123(String password) {
        browserManager.page.getByRole(TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        browserManager.page.onceDialog(dialog -> {
            alertText = dialog.message();
            dialog.accept();
        });

        browserManager.page.getByRole(BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

    @Then("I should be presented with an alert box which contains text {string}")
    public void i_should_be_presented_with_an_alert_box_which_contains_text(String expectedAlertText) {
        assertEquals(alertText, expectedAlertText, "The alert text does not match the expected alert box text. " +
                "\nActual Alert Text: " + alertText + "\nExpected Alert Text: " + expectedAlertText);
    }
}

package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {

    public String alertText;

    public LoginPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void typeUserName(String username) {
        fillField("Username", username);
    }

    public void typePassword(String password) {
        fillField("Password", password);
    }

    public void clickLoginButton() {
        getBrowserManager().getPage().onceDialog(dialog -> {
            alertText = dialog.message();
            dialog.accept();
        });
        waitAndClickByRole("BUTTON", "Login");
    }

    public void verifyUserValidationStatus(String expectedAlertText) {
        assertEquals(alertText, expectedAlertText, "The alert text does not match the expected alert box text. " +
                "\nActual Alert Text: " + alertText + "\nExpected Alert Text: " + expectedAlertText);
    }
}

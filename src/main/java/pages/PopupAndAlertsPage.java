package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PopupAndAlertsPage extends BasePage {

    public String dialogMessage, expectedMessage;

    public PopupAndAlertsPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void clickButton(String buttonName) {
        getBrowserManager().getPage().onceDialog(dialog -> {
            dialogMessage = dialog.message();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept();
        });
        switch (buttonName) {
            case "javascript alert" -> getLocator("#button1").click();
            case "modal popup" -> getLocator("#button2").click();
            case "ajax loader" -> getLocator("#button3").click();
            case "javascript confirm" -> getLocator("#button4").click();
        };
    }

    public void verifyJavaScriptAlert() {
        expectedMessage = "I am an alert box!";
        assertEquals(dialogMessage, expectedMessage,
                "Dialog message did not match " +
                        "\nActual message: " + dialogMessage +
                        "\nExpected message: " + expectedMessage);
    }

    public void verifyModalPopupContent() {
        String modalTitle = getLocator("#myModal > div > div > div.modal-header > h4").innerText();
        expectedMessage = "It’s that Easy!! ";
        assertTrue(modalTitle.contains(expectedMessage));
    }

    public void verifyRedirectionToAjaxLoadingPage() {
        assertEquals(getBrowserManager().getPage().title(), "WebDriver | Ajax-Loader");
        assertThat(getLocator("#loader")).isVisible();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertThat(getLocator("#myDiv")).isVisible();
    }

    public void verifyJavaScriptConfirmation(String confirmationText) {
        assertThat(getLocator("#confirm-alert-text")).isVisible();
        assertThat(getLocator("#confirm-alert-text")).hasText(confirmationText);
    }
}
package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import pages.base.BasePage;

import java.nio.file.Paths;
import java.util.Objects;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class FileUploadPage extends BasePage {

    public String dialogMessage;

    public FileUploadPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void uploadFile(String fileName) {
        if (!Objects.equals(fileName, "")) {
            getBrowserManager().getPage().setInputFiles("input[type='file']", Paths.get(fileName));
        }
    }

    public void clickSubmitFileButton() {
        getBrowserManager().getPage().onceDialog(dialog -> {
            dialogMessage = dialog.message();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept();
        });
        getLocator("#submit-button").click();
    }

    public void verifyAlertContent(String alertContent) {
        assertEquals(dialogMessage, alertContent,
            "Dialog message did not match " +
                    "\nActual message: " + dialogMessage +
                    "\nExpected message: " + alertContent);
    }
}

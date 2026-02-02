package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class IframePage extends BasePage {

    public IframePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void clickTab(String tabName) {
        getLocatorOnFrame("li").filter(new Locator.FilterOptions().setHasText(tabName)).click();
    }

    public void clickText(String text) {
        waitAndClickByExactNameOnIframe(text);
    }

    public void verifyCorrectModalHeader(String modalHeader) {
        String actualModalHeader = getLocatorOnFrame(".modal-title").innerText();
        assertEquals(modalHeader, actualModalHeader, "Modals do not match" +
                "\nActual Modal Header: " + actualModalHeader +
                "\nExpected Modal Header: " + modalHeader);
    }

    public void verifyRedirectionToContactUsPage() {
        String actualHeader = getLocatorOnFrame("#contact_me > div > div:nth-child(1) > div > h2").innerText();
        assertEquals(actualHeader, "CONTACT US",
                "Page headers do not match: " +
                "\nActual Modal Header: " + actualHeader +
                "\nExpected Modal Header: CONTACT US");
    }
}

package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class PageObjectModelPage extends BasePage {

    public PageObjectModelPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void clickTab(String tabName) {
        getLocator("li").filter(new Locator.FilterOptions().setHasText(tabName)).click();
    }

    public void clickText(String text) {
        waitAndClickByExactName(text);
    }

    public void verifyCorrectModalHeader(String modalHeader) {
        String actualModalHeader = getLocator(".modal-title").innerText();
        assertEquals(modalHeader, actualModalHeader, "Modals do not match" +
                "\nActual Modal Header: " + actualModalHeader +
                "\nExpected Modal Header: " + modalHeader);
    }

    public void verifyRedirectionToContactUsPage() {
        assertEquals(getBrowserManager().getPage().title(), "WebDriver | Contact Us", "Webpage title do not match" +
                "\nActual Page Title: " + getBrowserManager().getPage().title() +
                "\nExpected Page Title: WebDriver | Contact Us");
        assertThat(getLocator("#contact_me > div > div:nth-child(1) > div > h2")).isVisible();
    }
}

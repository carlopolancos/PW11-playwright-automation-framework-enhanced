package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import pages.base.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class AccordionPage extends BasePage {

    public AccordionPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void clickAccordionButton(String buttonName) {
        waitAndClickByRole("BUTTON", buttonName);
    }

    public void verifyAppearedText(String expectedText) {
        assertThat(getBrowserManager().getPage().getByText(expectedText, new Page.GetByTextOptions().setExact(false))).isVisible();
    }

    public void verifyAppearedTextAfterSeconds(String expectedText, int seconds) {
        assertThat(getLocator("#hidden-text")
                .filter(new Locator.FilterOptions().setHasText("LOADING COMPLETE.")))
                .isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout((seconds*1000) * 3 ));
        waitAndClickByRole("BUTTON", "Keep Clicking! - Text will Appear After 5 Seconds!");
        waitAndClickByRole("BUTTON", "Keep Clicking! - Text will Appear After 5 Seconds!");
        verifyAppearedText(expectedText);

    }
}

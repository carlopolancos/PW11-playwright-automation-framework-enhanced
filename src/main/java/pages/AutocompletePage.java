package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import pages.base.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class AutocompletePage extends BasePage {

    public AutocompletePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void typeLetterTextbox(String letter) {
        getLocator("#myInput").fill(letter);
        getLocator("#myInput").focus();
    }


    public void clickOnFirstAutocompleteSuggestion() {
        getLocator("#myInputautocomplete-list > div:nth-child(1)").click();
    }


    public void verifyTextboxValue(String value) {
        assertEquals(getLocator("#myInput").inputValue(), value);
    }
}

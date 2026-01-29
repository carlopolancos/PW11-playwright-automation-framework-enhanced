package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import pages.base.BasePage;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.*;

public class AjaxLoaderPage extends BasePage {

    public AjaxLoaderPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void waitThenClickTheSpanElement() {
        getBrowserManager().getPage().waitForSelector("#button1",
                new Page.WaitForSelectorOptions().setTimeout(10000).setState(WaitForSelectorState.VISIBLE));
        getLocator("#button1").click();
    }


    public void verifyCorrectModalAppeared() {
        String actualModal = getLocator(".modal-title").innerText();
        assertEquals(actualModal, "Well Done For Waiting....!!!",
                "Modal title did not match: " +
                "\nActual Modal Title: " + actualModal +
                "\nExpected Modal Title: Well Done For Waiting....!!!");
    }
}

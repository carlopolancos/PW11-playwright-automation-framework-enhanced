package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertFalse;

public class HiddenElementsPage extends BasePage {

    public HiddenElementsPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void verifyButtonNotVisible(String buttonName) {
        assertFalse(getLocator(buttonName).isVisible());
    }

    public void removeIDAttribute(String parentContainer) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getBrowserManager().getPage().evalOnSelector(parentContainer, "el => el.removeAttribute('id')");
    }

    public void verifyButtonIsVisible(String buttonName) {
        assertThat(getLocator(buttonName)).isVisible();
    }

    public void overrideIDAttribute(String parentContainer) {
        getBrowserManager().getPage().evaluate("sel => {" +
                "  const el = document.querySelector(sel);" +
                "  if (el) {" +
                "console.log('Targeting element:', el); " +
                "console.log('Selector :', sel); " +
                "    el.style.setProperty('display', 'block', 'important');" +
                "    el.style.setProperty('visibility', 'visible', 'important');" +
                "    el.style.setProperty('opacity', '1', 'important');" +
                "    el.removeAttribute('id');" +
                "  }" +
                "}", parentContainer);
    }
}
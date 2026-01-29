package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import static org.testng.Assert.assertEquals;

public class ButtonClicksPage extends BasePage {

    public ButtonClicksPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void clickOnTheButton(String name) {
        waitAndClickByName(name);
    }

    public void clickOnTheButton(String name, String method) {
        switch (method) {
            case "playwright" -> waitAndClickByName(name);
            case "css" -> waitAndClickSelector("#button2");
            case "xpath" -> waitAndClickSelector("//*[@id=\"button3\"]");
        }
    }

    public void verifyClickedButton(String modalHeader) {
        String modalHeaderContent = getBrowserManager().getPage().locator(".modal-title").filter(new Locator.FilterOptions().setHasText(modalHeader)).innerText();
        assertEquals(modalHeaderContent, modalHeader, "Modal header does not match" +
                "\nActual Modal Header: " + modalHeaderContent +
                "\nExpected Modal Header: " + modalHeader);
    }
}

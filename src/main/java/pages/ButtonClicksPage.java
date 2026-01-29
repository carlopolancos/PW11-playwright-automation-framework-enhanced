package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import pages.base.BasePage;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

public class ButtonClicksPage extends BasePage {

    private Logger logger = Logger.getLogger(ButtonClicksPage.class.getName());

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
        logger.info("Expected Modal Header: " + modalHeader + "\nActual Modal Header: " + modalHeaderContent);
        assertEquals(modalHeaderContent, modalHeader);
    }
}

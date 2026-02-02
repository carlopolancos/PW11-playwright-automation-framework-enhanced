package pages;

import browser.BrowserManager;
import pages.base.BasePage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ScrollingAroundPage extends BasePage {

    public ScrollingAroundPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void hoverElement(String element) {
        switch (element) {
            case "top" -> getLocator("#zone1").hover();
            case "left" -> getLocator("#zone2").hover();
            case "right" -> getLocator("#zone3").hover();
            case "bottom" -> getLocator("#zone4").hover();
        };
    }

    public void verifyDisplayedTextForAllElements() {
        assertThat(getLocator("body > div > div:nth-child(2)")).hasText("Well done for scrolling to me!");
        assertThat(getLocator("body > div > div:nth-child(3)")).hasText("2 Entries");
        assertThat(getLocator("body > div > div:nth-child(4)")).hasText("1 Entries");
        assertThat(getLocator("body > div > div:nth-child(5)")).hasText(Pattern.compile("X: \\d{3,4}Y: \\d{3}"));
    }
}
package browser;

import com.microsoft.playwright.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BrowserManager {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext browserContext;
    public Page page;

    public void setUp() {
        System.out.println("Setting up Playwright...");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        List<String> arguments =  new ArrayList<>();
        arguments.add("--start-maximized");

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page  = browserContext.newPage();
        System.out.println("Playwright setup complete");
    }

    public void tearDown() {
        System.out.println("Tearing down Playwright...");
        try {
            if (playwright != null) {
                playwright.close();
            }
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
        }
        System.out.println("Playwright teardown complete");
    }
}

package browser;

import com.microsoft.playwright.*;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserManager {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext browserContext;
    public Page page;
    public Properties properties;
    private static final Logger logger = Logger.getLogger(BrowserManager.class.getName());

    public BrowserManager() {
        properties = new Properties();
        Path configPath = Paths.get(System.getProperty("config.path",
                Paths.get(System.getProperty("user.dir"), "src", "main", "resources",
                        "config.properties").toString()));
        try (InputStream in = Files.newInputStream(configPath)) {
            properties.load(in);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading config file.", e);
        }
    }

    public byte[] takeScreenshot() {
        if (page != null) {
            return page.screenshot();
        }
        return new byte[0];
    }

    public void setUp() {
        logger.info("Setting up Playwright...");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        List<String> arguments =  new ArrayList<>();
        arguments.add("--start-maximized");

        playwright = Playwright.create();
        String browserType = properties.getProperty("browser", "chromium");
        switch (browserType.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
                break;
            default:
                logger.warning("Unknown browser type: " + browserType + ". Defaulting to chromium.");
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
                break;
        }
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page  = browserContext.newPage();
        logger.info("Playwright setup complete");
    }

    public void tearDown() {
        logger.info("Tearing down Playwright...");
        try {
            if (playwright != null) {
                playwright.close();
            }
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
        }
        logger.info("Playwright teardown complete");
    }
}

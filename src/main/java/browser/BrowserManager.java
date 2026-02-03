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

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();
    public Properties properties;
    private static final Logger logger = Logger.getLogger(BrowserManager.class.getName());

    public BrowserContext  getBrowserContext(){
        return browserContext.get();
    }

    public Page getPage() {
        return page.get();
    }

    public void setPage(Page page) {
        BrowserManager.page.set(page);
    }

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
        if (page.get() != null) {
            return page.get().screenshot();
        }
        return new byte[0];
    }

    public void setUp() {
        logger.info("Setting up Playwright...");
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = (int) screenSize.getWidth();
//        int height = (int) screenSize.getHeight();
        List<String> arguments =  new ArrayList<>();
        arguments.add("--start-maximized");
        int navigationTimeout = Integer.parseInt(properties.getProperty("navigation.timeout", "30000"));
        int actionTimeout = Integer.parseInt(properties.getProperty("action.timeout", "15000"));

        try {
            playwright.set(Playwright.create());

            String browserType = System.getProperty("BROWSER");
            if (browserType == null || browserType.isEmpty()) {
                browserType = properties.getProperty("browser", "chromium");
            }

            switch (browserType.toLowerCase()) {
                case "chromium":
                    browser.set(playwright.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments)));
                    break;
                case "firefox":
                    browser.set(playwright.get().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments)));
                    break;
                default:
                    logger.warning("Unknown browser type: " + browserType + ". Defaulting to chromium.");
                    browser.set(playwright.get().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments)));
                    break;
            }
            browserContext.set(browser.get().newContext(new Browser.NewContextOptions().setViewportSize(null)));
            page.set(browserContext.get().newPage());
            page.get().setDefaultNavigationTimeout(navigationTimeout);
            page.get().setDefaultTimeout(actionTimeout);
            logger.info("Playwright setup complete");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to setup Playwright!", e);
        }
    }

    public void tearDown() {

        System.out.println("Tearing down Playwright...");
        if (browser.get() != null) {
            for (BrowserContext ctx : browser.get().contexts()) {
                for (Page p : ctx.pages()) p.close();
                ctx.close();
            }
            browser.get().close();
        }
        if (playwright.get() != null) playwright.get().close();
        System.out.println("Playwright teardown complete");
    }

    public static void tearDownAll() {
        logger.info("Tearing down Playwright...");
        try {
            if (playwright.get() != null) {
                playwright.get().close();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to close Playwright resources!", e);
        }
        logger.info("Playwright teardown complete");
    }
}

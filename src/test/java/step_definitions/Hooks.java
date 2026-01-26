package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.Browser;
import io.cucumber.java.*;

import java.lang.reflect.Method;

public class Hooks {

    private final BrowserManager browserManager;

    public Hooks (BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Executing test suite...");
    }

    @Before
    public void beforeEach() {
        System.out.println("Executing test");
        browserManager.setUp();
    }

    @After
    public void afterEach(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = browserManager.takeScreenshot();
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        System.out.println("Finished executing test");
        browserManager.tearDown();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Finished executing the test suite...");
    }
}

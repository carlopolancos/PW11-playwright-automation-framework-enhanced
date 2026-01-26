package step_definitions;

import browser.BrowserManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.awt.*;

import static com.microsoft.playwright.options.AriaRole.*;

public class Homepage_Steps {

    public BrowserManager browserManager;

    public Homepage_Steps (BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    @Given("I navigate to the webdriveruniversity homepage")
    public void i_navigate_to_the_webdriveruniversity_homepage() {
        browserManager.page.navigate("https://www.webdriveruniversity.com");
    }

    @When("I click on the contact us button")
    public void i_click_on_the_contact_us_button() {
        browserManager.page = browserManager.page.waitForPopup(() -> {
            browserManager.page.getByRole(LINK, new Page.GetByRoleOptions().setName("CONTACT US Contact Us Form")).click();
        });
        browserManager.page.bringToFront();
    }

    @When("I click on the login portal button")
    public void i_click_on_the_login_portal_button() {
        browserManager.page = browserManager.page.waitForPopup(() -> {
            browserManager.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("LOGIN PORTAL Login Portal Are")).click();
        });
        browserManager.page.bringToFront();
    }
}

package pages;

import browser.BrowserManager;
import pages.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void navigateToHomePage() {
        navigate("https://www.webdriveruniversity.com");
    }

    public void clickContactUsButton () {
        getBrowserManager().setPage(getBrowserManager().getPage().waitForPopup(() -> {
//            browserManager.getPage().getByRole(LINK, new Page.GetByRoleOptions().setName("CONTACT US Contact Us Form")).click();
            waitAndClickByRole("LINK", "CONTACT US Contact Us Form");
        }));
        getBrowserManager().getPage().bringToFront();
    }

    public void clickLoginButton() {
        getBrowserManager().setPage(getBrowserManager().getPage().waitForPopup(() -> {
//            browserManager.getPage().getByRole(LINK, new Page.GetByRoleOptions().setName("CONTACT US Contact Us Form")).click();
            waitAndClickByRole("LINK", "LOGIN PORTAL Login Portal Are");
        }));
        getBrowserManager().getPage().bringToFront();
    }

    public void clickButtonClicksLink() {
        getBrowserManager().setPage(getBrowserManager().getPage().waitForPopup(() -> {
            waitAndClickByRole("LINK", "BUTTON CLICKS WebElement");
        }));
        getBrowserManager().getPage().bringToFront();
    }

    public void clickToDoListLink() {
        getBrowserManager().setPage(getBrowserManager().getPage().waitForPopup(() -> {
            waitAndClickByRole("LINK", "TO DO LIST Task1 [ ] - Task2");
        }));
        getBrowserManager().getPage().bringToFront();
    }
}

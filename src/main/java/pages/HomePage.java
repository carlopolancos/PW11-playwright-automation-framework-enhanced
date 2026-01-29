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

    public void clickAndOpenNewPage(String linkText){
        getBrowserManager().setPage(getBrowserManager().getPage().waitForPopup(() -> {
//            browserManager.getPage().getByRole(LINK, new Page.GetByRoleOptions().setName("CONTACT US Contact Us Form")).click();
            waitAndClickByRole("LINK", linkText);
        }));
        getBrowserManager().getPage().bringToFront();
    }

    public void clickContactUsLink() {
        clickAndOpenNewPage("CONTACT US Contact Us Form");
    }

    public void clickLoginLink() {
        clickAndOpenNewPage("LOGIN PORTAL Login Portal Are");
    }

    public void clickButtonClicksLink() {
        clickAndOpenNewPage("BUTTON CLICKS WebElement");
    }

    public void clickToDoListLink() {
        clickAndOpenNewPage("TO DO LIST Task1 [ ] - Task2");
    }

    public void clickPageObjectModelLink() {
        clickAndOpenNewPage("PAGE OBJECT MODEL Design a");
    }

    public void clickAccordionLink() {
        clickAndOpenNewPage("ACCORDION & TEXT AFFECTS (APPEAR & DISAPPEAR)");
    }
}

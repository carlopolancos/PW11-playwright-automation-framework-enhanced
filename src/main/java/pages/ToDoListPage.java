package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.base.BasePage;

import java.util.logging.Logger;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ToDoListPage extends BasePage {


    public ToDoListPage(BrowserManager browserManager) {
        super(browserManager);
    }

    //CREATE
    public void createNewTask(String name) {
        Locator element = getBrowserManager().getPage().getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Add new todo"));
        element.fill(name);
        element.press("Enter");
    }

    public void verifyAddedTask(String taskName) {
        Locator element = getBrowserManager().getPage().locator("#container > ul > li:nth-child(4)");
        assertThat(element).containsText(taskName);
    }

    //UPDATE
    public void completeTask(String name) {
        Locator element = getBrowserManager().getPage().locator("#container > ul > li:nth-child(4)");
        element.click();
    }

    public void verifyCompletedTask(String taskName) {
        Locator element = getBrowserManager().getPage().locator("#container > ul > li:nth-child(4)");
        assertThat(element).containsClass("completed");
    }

    //DELETE
    public void deleteTask(String name) {
        Locator element = getBrowserManager().getPage().locator("#container > ul > li:nth-child(4)");
        element.hover();
        element.locator(".fa-trash").click();
    }

    public void verifyDeletedTask(String taskName) {
        Locator element = getBrowserManager().getPage().getByText(taskName, new Page.GetByTextOptions().setExact(true));
        assertThat(element).hasCount(0);
    }
}

package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import pages.base.BasePage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class ActionsPage extends BasePage {

    public String dialogMessage;

    public ActionsPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void dragElementToTarget() {
        Locator dragObject = getLocator("#draggable");
        Locator dropObject = getLocator("#droppable");

        double xPoint = dragObject.boundingBox().x + (dragObject.boundingBox().width/ 2);
        double yPoint = dragObject.boundingBox().y + (dragObject.boundingBox().height/ 2);
        double xPointDest = dropObject.boundingBox().x + (dropObject.boundingBox().width/ 2);
        double yPointDest = dropObject.boundingBox().y + (dropObject.boundingBox().height/ 2);

        getBrowserManager().getPage().mouse().move(xPoint, yPoint);
        getBrowserManager().getPage().mouse().down();
        getBrowserManager().getPage().mouse().move(xPointDest, yPointDest, new Mouse.MoveOptions().setSteps(20));
        getBrowserManager().getPage().mouse().up();
    }


    public void verifyTargetContent(String expectedContent) {
        String actualContent = getLocator("#droppable > p").innerText();
        assertEquals(actualContent, expectedContent,
                "Element content did not match: " +
                "\nActual content: " + actualContent +
                "\nExpected content: " + expectedContent);
    }

    public void doubleClickOnElement() {
        getLocator("#double-click").click(new Locator.ClickOptions().setClickCount(2));
    }

    public void verifyElementNewClass(String expectedNewClass) {
        assertThat(getLocator("#double-click")).hasClass(Pattern.compile(".*"+expectedNewClass+".*"));
    }

    public void hoverThenClickOnElement(String hoverElement, String clickOnElement) {
        getBrowserManager().getPage().onceDialog(dialog -> {
            dialogMessage = dialog.message();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept();
        });
        getLocator("#div-hover > div:nth-child("+hoverElement+")").hover();
        getLocator("#div-hover > div:nth-child("+hoverElement+") "+clickOnElement).click();
    }


    public void verifyCorrectDialogAppears() {
        String expectedMessage = "Well done you clicked on the link!";
        assertEquals(dialogMessage, expectedMessage,
                "Dialog message did not match " +
                "\nActual message: " + dialogMessage +
                "\nExpected message: " + expectedMessage);
    }
}

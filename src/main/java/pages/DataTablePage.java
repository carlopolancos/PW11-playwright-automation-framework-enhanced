package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pages.base.BasePage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class DataTablePage extends BasePage {

    public String expectedContent, actualContent, normalizedActualContent, normalizedExpectedContent;

    public DataTablePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void readDataFromTable(String tableName) {
        String selector = tableName + " tr";
        getBrowserManager().getPage().waitForSelector(selector);
        List<String> trStrings = getLocator(selector).allInnerTexts();
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("./target/DataTableContents.txt", false))) {
            for (String trString : trStrings) {
                writer.write(trString.trim());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public void verifyCorrectFileContents(String tableName) throws IOException {
        switch (tableName) {
            case "#t01" ->
                expectedContent = """
                    Firstname Lastname Age
                    John Smith 45
                    Jemma Jackson 94
                    Michael Doe 20""".trim();
            case "#t02" ->
                expectedContent = """
                    Firstname Lastname Age
                    Jason Jones 27
                    Sarah Jackson 56
                    Bob Woods 80""".trim();
            case "table.traversal-table" ->
                expectedContent = """
                    # First Last
                    1 Andy Otto
                    2 Jacob Jones
                    3 Larry Scott""".trim();
        }
        actualContent = Files.readString(Paths.get("./target/DataTableContents.txt")).trim();
        normalizedActualContent = actualContent.replaceAll("\\s+", " ");
        normalizedExpectedContent = expectedContent.replaceAll("\\s+", " ");
        assertEquals(normalizedActualContent, normalizedExpectedContent,
                "Contents are not matched: " +
                        "\nExpected content: " + expectedContent +
                        "\nActual content: " + normalizedActualContent);
    }

    public void inputFirstName(String firstName) {
        getLocator("input[name='firstname']").fill(firstName);
    }

    public void inputLastName(String lastName) {
        getLocator("input[name='lastname']").fill(lastName);
    }

    public void inputTextBoxResizable(String multiLine) {
        String sanitized = multiLine.replace("\r\n", "\n").trim();
        getLocator("#form-textfield > textarea").fill(sanitized);
    }

    public void verifyInputTextValues() {
        assertThat(getLocator("input[name='firstname']")).hasValue("Carlo");
        assertThat(getLocator("input[name='lastname']")).hasValue("Polancos");
        assertThat(getLocator("#form-textfield > textarea")).hasValue("Open Bind\nDelete Corrode\nDelete Abyss\nOpen Breeze\nStudy Split\nOpen Pearl\nOpen Haven");
    }

    public void clickLink(String linkName) {
        switch (linkName) {
            case "Home", "About" -> getBrowserManager().getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkName)).click();
            case "Forward" -> getLocator("body > div > div:nth-child(5) > div > nav > ul > li:nth-child(1) > a").click();
            case "Backward" -> getLocator("body > div > div:nth-child(5) > div > nav > ul > li:nth-child(7) > a").click();
            case "Link" -> getLocator("body > div > div:nth-child(7) > div > div.traversal-buttons > a").click();
            default -> {
                int elementNumber = Integer.parseInt(linkName) + 1;
                getLocator("body > div > div:nth-child(5) > div > nav > ul > li:nth-child(" + elementNumber + ") > a").click();
            }
        }
    }

    public void verifyPageStartRedirection() {
        assertThat(getLocator("#main-header > h1")).isInViewport();
    }

    public void verifyListItemBadge(String listItemName, String badge) {
        Locator element = getLocator("body > div > div:nth-child(4) > div > ul > li").filter(new Locator.FilterOptions().setHasText(listItemName));
        String actualBadge = element.locator("span").innerText();
        assertEquals(actualBadge, badge,
                "Badges do not match: " +
                        "\nExpected badge: " + badge +
                        "\nActual badge: " + actualBadge);
    }

    public void verifyButtonState(String buttonName, String state) {
        Locator element = getBrowserManager().getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonName).setExact(true));
        switch (state) {
            case "enabled" -> assertThat(element).isEnabled();
            case "disabled" -> assertThat(element).hasClass(Pattern.compile("disabled"));
            case "active" -> assertThat(element).hasClass(Pattern.compile("active"));
        }
    }

    public void readListValues(String listName) {
        if (listName.equals("traversal-job-list")) {
            getBrowserManager().getPage().waitForSelector("ul[class='"+listName+"']");
            String header = getLocator("#types-of-jobs").innerText();
            List<String> listItems = getLocator("ul[class='"+listName+"'] > ul > li").allInnerTexts();
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter("./target/ListContents.txt", false))) {
                for (String listItem : listItems) {
                    writer.write(header.trim());
                    writer.newLine();
                    writer.write(listItem.trim());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        } else {
            getBrowserManager().getPage().waitForSelector("ul[class='"+listName+"'] li");
            List<String> listItems = getLocator("ul[class='"+listName+"'] li").allInnerTexts();
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter("./target/ListContents.txt", false))) {
                for (String listItem : listItems) {
                    writer.write(listItem.trim());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    public void verifyListValue(String listName) throws IOException {
        switch (listName) {
            case "traversal-drinks-list" ->
                    expectedContent = """
                    Coffee Tea Milk Espresso Sugar""".trim();
            case "traversal-food-list" ->
                    expectedContent = """
                    Fruits Apple Banana Blackberries Cherries Figs Vegetables Asparagus Broccoli Kidney beans Lentils""".trim();
            case "traversal-job-list" ->
                    expectedContent = """
                    Types of Jobs Finance Types of Jobs Technology Types of Jobs Sales""".trim();
        }
        actualContent = Files.readString(Paths.get("./target/ListContents.txt")).trim();
        normalizedActualContent = actualContent.replaceAll("\\s+", " ");
        normalizedExpectedContent = expectedContent.replaceAll("\\s+", " ");
        assertEquals(normalizedActualContent, normalizedExpectedContent,
                "Contents are not matched: " +
                        "\nExpected content: " + expectedContent +
                        "\nActual content: " + normalizedActualContent);
    }
}

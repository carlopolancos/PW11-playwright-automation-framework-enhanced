package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import context.PersonContext;
import net.datafaker.Faker;
import pages.base.BasePage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class ContactUsPage extends BasePage {

    private final Faker faker = new Faker();
    private final PersonContext personContext;

    public ContactUsPage(BrowserManager browserManager, PersonContext personContext) {
        super(browserManager);
        this.personContext = personContext;
    }

    public void typeFirstName(String firstName) {
        fillField("First Name", firstName);
    }

    public void typeRandomFirstName() {
        String randomFirstName = faker.name().firstName();
        personContext.setRandomFirstName(randomFirstName);
        typeFirstName(randomFirstName);
    }

    public void typeLastName(String lastName) {
        fillField("Last Name", lastName);
    }

    public void typeRandomLastName() {
        String randomLastName = faker.name().lastName();
        personContext.setRandomLastName(randomLastName);
        typeLastName(randomLastName);
    }

    public void typeEmailAddress(String emailAddress) {
        fillField("Email Address", emailAddress);
    }

    public void typeRandomEmailAddress() {
        String randomEmailAddress = faker.internet().emailAddress();
        personContext.setRandomEmailAddress(randomEmailAddress);
        typeEmailAddress(randomEmailAddress);
    }

    public void typeComment(String comment) {
        fillField("Comments", comment);
    }

    public void typeRandomComment() {
        typeComment("Hi, please can you contact me?" +
                "\nMy details: " +
                "\nFirst Name: " + personContext.getRandomFirstName() +
                "\nLast Name: " + personContext.getRandomLastName() +
                "\nEmail Address: " + personContext.getRandomEmailAddress());
    }

    public void clickSubmitButton() {
        waitAndClickSelector("input[value='SUBMIT']");
    }

    public void verifySuccessfulSubmissionMessage() {
        String selector = "#contact_reply > h1";
        getBrowserManager().getPage().waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(10000));
        Locator locator = getBrowserManager().getPage().locator(selector);
        assertThat(locator).isVisible();
        assertThat(locator).hasText("Thank You for your Message!");
    }

    public void verifyUnsuccessfulSubmissionMessage() {
        Locator locator = getBrowserManager().getPage().locator("body");
        assertThat(locator).isVisible();
        String bodyText = locator.innerText();
        Pattern pattern = Pattern.compile("Error: (all fields are required!|Invalid email address)");
        Matcher matcher = pattern.matcher(bodyText);
        assertTrue(matcher.find(), "The body text does not match the expected error message. \nFound text: " + bodyText);
    }

    public void verifyHeaderText(String message) {
        getBrowserManager().getPage().waitForSelector("//h1 | //body");
        Locator locator = getLocator("//h1 | //body");
        List<String> texts = locator.allInnerTexts();
        String foundText = "";
        boolean found = false;
        for (String text : texts) {
            if (text.contains(message)) {
                foundText = text;
                found = true;
                break;
            } else {
                foundText = text;
            }
        }
        assertTrue(found, "The element does not contain the expected message. " +
                "\nExpected message: " + foundText + " to be equal to: " + message);
    }
}

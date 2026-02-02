package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectModelPage;

public class PageObjectModelSteps {

    private final PageObjectModelPage pageObjectModelPage;

    public PageObjectModelSteps(PageObjectModelPage pageObjectModelPage) {
        this.pageObjectModelPage = pageObjectModelPage;
    }

    @When("I click the tab {string}")
    public void iClickTheTab(String tabName) {
        pageObjectModelPage.clickTab(tabName);
    }

    @When("I click the {string}")
    public void iClickTheString(String text) {
        pageObjectModelPage.clickText(text);
    }

    @Then("The correct modalHeader {string} should appear")
    public void theCorrectModalHeaderShouldAppear(String modalHeader) {
        pageObjectModelPage.verifyCorrectModalHeader(modalHeader);
    }

    @Then("I am redirected to Contact Us page")
    public void iAmRedirectedToContactUsPage() {
        pageObjectModelPage.verifyRedirectionToContactUsPage();
    }
}

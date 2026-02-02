package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.IframePage;
import pages.PageObjectModelPage;

public class IframeSteps {

    private final IframePage iframePage;

    public IframeSteps(IframePage iframePage) {
        this.iframePage = iframePage;
    }

    @When("On the iframe, i click the tab {string}")
    public void onTheIframeIClickTheTab(String tabName) {
        iframePage.clickTab(tabName);
    }

    @When("On the iframe, i click the {string}")
    public void onTheIframeIClickTheString(String text) {
        iframePage.clickText(text);
    }

    @Then("On the iframe, the correct modalHeader {string} should appear")
    public void onTheIframeTheCorrectModalHeaderShouldAppear(String modalHeader) {
        iframePage.verifyCorrectModalHeader(modalHeader);
    }

    @Then("On the iframe, i am redirected to Contact Us page")
    public void onTheIframeIAmRedirectedToContactUsPage() {
        iframePage.verifyRedirectionToContactUsPage();
    }
}

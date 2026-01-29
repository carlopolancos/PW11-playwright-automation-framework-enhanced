package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageObjectModelPage;

public class PageObjectModel_Steps {

    private final PageObjectModelPage pageObjectModelPage;

    public PageObjectModel_Steps(PageObjectModelPage pageObjectModelPage) {
        this.pageObjectModelPage = pageObjectModelPage;
    }

    @When("I click the tab {string}")
    public void i_click_the_tab(String tabName) {
        pageObjectModelPage.clickTab(tabName);
    }

    @When("I click the {string}")
    public void i_click_the_text(String text) {
        pageObjectModelPage.clickText(text);
    }

    @Then("The correct modalHeader {string} should appear")
    public void the_correct_modal_should_appear(String modalHeader) {
        pageObjectModelPage.verifyCorrectModalHeader(modalHeader);
    }

    @Then("I am redirected to Contact Us page")
    public void i_am_redirected_to_contact_us_page() {
        pageObjectModelPage.verifyRedirectionToContactUsPage();
    }
}

package step_definitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class Homepage_Steps {

    private final HomePage homePage;

    public Homepage_Steps (HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("I navigate to the webdriveruniversity homepage")
    public void iNavigateToTheWebdriverUniversityHomepage() {
        homePage.navigateToHomePage();
    }

    @When("I click on the contact us button")
    public void iClickOnTheContactUsButton() {
        homePage.clickContactUsLink();
    }

    @When("I click on the login portal button")
    public void iClickOnTheLoginPortalButton() {
        homePage.clickLoginLink();
    }

    @When("I click on the button clicks link")
    public void iClickOnTheButtonClicksLink() {
        homePage.clickButtonClicksLink();
    }

    @When("I click on the to do list link")
    public void iClickOnTheToDoListLink() {
        homePage.clickToDoListLink();
    }

    @When("I click on the pageObjectModel link")
    public void iClickOnThePageObjectModelLink() {
        homePage.clickPageObjectModelLink();
    }

    @When("I click on the accordion & text effects link")
    public void iClickOnTheAccordionAndTextEffectsLink() {
        homePage.clickAccordionLink();
    }

    @When("I click on the choice link")
    public void iClickOnTheChoiceLink() {
        homePage.clickChoiceLink();
    }

    @When("I click on the ajax loader link")
    public void iClickOnTheAjaxLoaderLink() {
        homePage.clickAjaxLoaderLink();
    }

    @When("I click on the actions link")
    public void iClickOnTheActionsLink() {
        homePage.clickActionLink();
    }

    @When("I click on the scrolling around link")
    public void iClickOnTheScrollingAroundLink() {
        homePage.clickScrollingAroundLink();
    }

    @When("I click on the popup and alerts link")
    public void iClickOnThePopupAndAlertsLink() {
        homePage.clickPopupAndAlertsLink();
    }

    @When("I click on the iframe link")
    public void iClickOnTheIframeLink() {
        homePage.clickIframeLink();
    }

    @When("I click on the hidden elements link")
    public void iClickOnTheHiddenElementsLink() {
        homePage.clickHiddenElementsLink();
    }

    @When("I click on the data table link")
    public void iClickOnTheDataTableLink() {
        homePage.clickDataTableLink();
    }

    @When("I click on the autocomplete link")
    public void iClickOnTheAutocompleteLink() {
        homePage.clickAutocompleteLink();
    }
}

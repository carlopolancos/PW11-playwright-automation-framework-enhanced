package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class Homepage_Steps {

    private final HomePage homePage;

    public Homepage_Steps (HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("I navigate to the webdriveruniversity homepage")
    public void i_navigate_to_the_webdriveruniversity_homepage() {
        homePage.navigateToHomePage();
    }

    @When("I click on the contact us button")
    public void i_click_on_the_contact_us_button() {
        homePage.clickContactUsLink();
    }

    @When("I click on the login portal button")
    public void i_click_on_the_login_portal_button() {
        homePage.clickLoginLink();
    }

    @When("I click on the button clicks link")
    public void i_click_on_the_button_clicks_link() {
        homePage.clickButtonClicksLink();
    }

    @When("I click on the to do list link")
    public void i_click_on_the_to_do_list_link() {
        homePage.clickToDoListLink();
    }

    @When("I click on the pageObjectModel link")
    public void i_click_on_the_page_object_model_link() {
        homePage.clickPageObjectModelLink();
    }

    @When("I click on the accordion & text effects link")
    public void i_click_on_the_accordion_and_text_effects_link() {
        homePage.clickAccordionLink();
    }

    @When("I click on the choice link")
    public void i_click_on_the_choice_link() {
        homePage.clickChoiceLink();
    }

    @When("I click on the ajax loader link")
    public void i_click_on_the_ajax_loader_link() {
        homePage.clickAjaxLoaderLink();
    }

    @When("I click on the actions link")
    public void i_click_on_the_actions_link() {
        homePage.clickActionLink();
    }
}

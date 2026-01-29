package step_definitions;

import browser.BrowserManager;
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
    public void i_navigate_to_the_webdriveruniversity_homepage() {
        homePage.navigateToHomePage();
    }

    @When("I click on the contact us button")
    public void i_click_on_the_contact_us_button() {
        homePage.clickContactUsButton();
    }

    @When("I click on the login portal button")
    public void i_click_on_the_login_portal_button() {
        homePage.clickLoginButton();
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
}

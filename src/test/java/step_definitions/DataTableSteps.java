package step_definitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ActionsPage;
import pages.DataTablePage;

import java.io.IOException;

public class DataTableSteps {

    private final DataTablePage dataTablePage;

    public DataTableSteps(DataTablePage dataTablePage) {
        this.dataTablePage = dataTablePage;
    }

    @When("Read data on table {word}")
    public void readDataOnTable(String tableName) {
        dataTablePage.readDataFromTable(tableName);
    }

    @When("Input {word} on First name textbox")
    public void inputOnFirstNameTextbox(String firstName) {
        dataTablePage.inputFirstName(firstName);
    }

    @When("Input {word} on Last name textbox")
    public void inputOnLastNameTextbox(String lastName) {
        dataTablePage.inputLastName(lastName);
    }

    @When("Input on Input text box resizable:")
    public void inputOnInputTextBoxResizable(String multiLine) {
        dataTablePage.inputTextBoxResizable(multiLine);
    }

    @When("Link {word} is clicked")
    public void linkIsClicked(String linkName) {
        dataTablePage.clickLink(linkName);
    }

    @When("Read list {word} values")
    public void readListValues(String listName) {
        dataTablePage.readListValues(listName);
    }

    @Then("The file created from table {word} will have the correct content")
    public void theFileCreatedFromTableWillHaveTheCorrectContent(String tableName) throws IOException {
        dataTablePage.verifyCorrectFileContents(tableName);
    }

    @Then("All text inputs should have correct values")
    public void allTextInputsShouldHaveCorrectValues() {
        dataTablePage.verifyInputTextValues();
    }

    @Then("I am brought back to the top of the page")
    public void iAmBroughtBackToTheTopOfThePage() {
        dataTablePage.verifyPageStartRedirection();
    }

    @Then("List item {string} should have badge {string}")
    public void listItemShouldHaveBadge(String listItemName, String badge) {
        dataTablePage.verifyListItemBadge(listItemName, badge);
    }

    @Then("Button {word} should have state {word}")
    public void buttonShouldHaveState(String buttonName, String state) {
        dataTablePage.verifyButtonState(buttonName, state);
    }

    @Then("List {word} should have the correct values")
    public void listShouldHaveTheCorrectValues(String listName) throws IOException {
        dataTablePage.verifyListValue(listName);
    }
}

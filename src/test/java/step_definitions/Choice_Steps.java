package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChoicePage;

public class Choice_Steps {

    private final ChoicePage choicePage;

    public Choice_Steps(ChoicePage choicePage) {
        this.choicePage = choicePage;
    }

    @When("The initial selected value for dropdown {word} is {word}")
    public void the_initial_selected_value_for_dropdown_is(String dropdownNumber, String initialValue) {
        choicePage.verifyDropdownInitialValue(dropdownNumber, initialValue);
    }

    @When("I choose {word} as its new value for dropdown {word}")
    public void i_choose_as_its_new_value_for_dropdown(String newValue, String dropdownNumber) {
        choicePage.chooseDropdownNewValue(dropdownNumber, newValue);
    }

    @When("Only checkbox 3 is initially checked")
    public void only_checkbox_3_is_initially_checked() {
        choicePage.verifyCheckboxesInitialValues();
    }

    @When("I click all checkboxes")
    public void i_click_all_checkboxes() {
        choicePage.clickAllCheckboxes();
    }

    @When("No radiobutton is initially checked")
    public void no_radiobutton_is_initially_checked() {
        choicePage.verifyRadiobuttonsInitialValues();
    }

    @When("I click all radiobuttons")
    public void i_click_all_radiobuttons() {
        choicePage.clickAllRadiobuttons();
    }

    @When("Radiobutton pumpkin is selected and grape is selected from dropdown")
    public void radiobutton_pumpkin_is_selected_and_grape_is_selected_from_dropdown() {
        choicePage.verifyInitiallySelectedRadiobuttonAndOption();
    }

    @When("I try to select other radiobutton and select option")
    public void i_try_to_select_other_radiobutton_and_select_option() {
        choicePage.selectOtherRadioButtonAndSelectOption();
    }

    @Then("The {word} should be displayed for dropdown {word}")
    public void the_new_value_should_be_displayed_for_dropdown (String newValue, String dropdownNumber) {
        choicePage.verifyDropdownNewValue(dropdownNumber, newValue);
    }

    @Then("Only checkbox 3 is unchecked")
    public void only_checkbox_3_is_unchecked() {
        choicePage.verifyCheckboxesNewValues();
    }

    @Then("Only radiobutton purple is checked")
    public void only_radiobutton_purple_is_checked() {
        choicePage.verifyCheckedRadioButton();
    }

    @Then("Verify that specific radiobutton and select option are disabled")
    public void verify_that_specific_radiobutton_and_select_option_are_disabled() {
        choicePage.verifyDisabledRadioButtonAndSelectOption();
    }
}

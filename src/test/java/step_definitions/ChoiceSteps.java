package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChoicePage;

public class ChoiceSteps {

    private final ChoicePage choicePage;

    public ChoiceSteps(ChoicePage choicePage) {
        this.choicePage = choicePage;
    }

    @When("The initial selected value for dropdown {word} is {word}")
    public void theInitialSelectedValueForDropdownIs(String dropdownNumber, String initialValue) {
        choicePage.verifyDropdownInitialValue(dropdownNumber, initialValue);
    }

    @When("I choose {word} as its new value for dropdown {word}")
    public void iChooseAsItsNewValueForDropdown(String newValue, String dropdownNumber) {
        choicePage.chooseDropdownNewValue(dropdownNumber, newValue);
    }

    @When("Only checkbox 3 is initially checked")
    public void onlyCheckbox3IsInitiallyChecked() {
        choicePage.verifyCheckboxesInitialValues();
    }

    @When("I click all checkboxes")
    public void iClickAllCheckboxes() {
        choicePage.clickAllCheckboxes();
    }

    @When("No radiobutton is initially checked")
    public void noRadiobuttonIsInitiallyChecked() {
        choicePage.verifyRadiobuttonsInitialValues();
    }

    @When("I click all radiobuttons")
    public void iClickAllRadiobuttons() {
        choicePage.clickAllRadiobuttons();
    }

    @When("Radiobutton pumpkin is selected and grape is selected from dropdown")
    public void radiobuttonPumpkinIsSelectedAndGrapeIsSelectedFromDropdown() {
        choicePage.verifyInitiallySelectedRadiobuttonAndOption();
    }

    @When("I try to select other radiobutton and select option")
    public void iTryToSelectOtherRadiobuttonAndSelectOption() {
        choicePage.selectOtherRadioButtonAndSelectOption();
    }

    @Then("The {word} should be displayed for dropdown {word}")
    public void theShouldBeDisplayedForDropdown (String newValue, String dropdownNumber) {
        choicePage.verifyDropdownNewValue(dropdownNumber, newValue);
    }

    @Then("Only checkbox 3 is unchecked")
    public void onlyCheckbox3IsUnchecked() {
        choicePage.verifyCheckboxesNewValues();
    }

    @Then("Only radiobutton purple is checked")
    public void onlyRadiobuttonPurpleIsChecked() {
        choicePage.verifyCheckedRadioButton();
    }

    @Then("Verify that specific radiobutton and select option are disabled")
    public void verifyThatSpecificRadiobuttonAndSelectOptionAreDisabled() {
        choicePage.verifyDisabledRadioButtonAndSelectOption();
    }
}

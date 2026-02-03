package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccordionPage;
import pages.DatepickerPage;

public class DatepickerSteps {

    private final DatepickerPage datepickerPage;

    public DatepickerSteps(DatepickerPage datepickerPage) {
        this.datepickerPage = datepickerPage;
    }

    @When("The initial value should be today")
    public void theInitialValueShouldBeToday() {
        datepickerPage.verifyInitialValue();
    }

    @When("I choose a specific date")
    public void iChooseASpecificDate() {
        datepickerPage.chooseSpecificDate();
    }

    @Then("The datepicker should be updated with the new value")
    public void theDatepickerShouldBeUpdatedWithTheNewValue() {
        datepickerPage.verifyNewValue();
    }
}

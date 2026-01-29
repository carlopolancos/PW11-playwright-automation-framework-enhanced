package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import pages.base.BasePage;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.*;

public class ChoicePage extends BasePage {

    public ChoicePage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void verifyDropdownInitialValue(String dropdownNumber, String initialValue) {
        Locator element = getLocator("#dropdowm-menu-" + dropdownNumber + " option:checked");
        assertThat(element).hasText(initialValue);
    }

    public void chooseDropdownNewValue(String dropdownNumber, String newValue) {
        Locator element = getLocator("#dropdowm-menu-" + dropdownNumber);
        element.selectOption(new SelectOption().setLabel(newValue));
    }

    public void verifyDropdownNewValue(String dropdownNumber, String newValue) {
        verifyDropdownInitialValue(dropdownNumber, newValue);
    }

    public void verifyCheckboxesInitialValues() {
//        #checkboxes > label:nth-child(1) > input[type=checkbox]
        getBrowserManager().getPage().waitForSelector("#checkboxes > label:nth-child(1) > input[type=checkbox]");
        List<Locator> checkboxes = getLocator("#checkboxes > label > input[type=checkbox]").all();
        int checked = 0;
        for (Locator checkbox : checkboxes) {
            if (checkbox.isChecked()) checked++;
        }
        assertEquals(checked, 1);
        assertTrue(getLocator("#checkboxes > label:nth-child(5) > input[type=checkbox]").isChecked());
    }

    public void clickAllCheckboxes() {
        List<Locator> checkboxes = getLocator("#checkboxes > label > input[type=checkbox]").all();
        for (Locator checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public void verifyCheckboxesNewValues() {
//        #checkboxes > label:nth-child(1) > input[type=checkbox]
        getBrowserManager().getPage().waitForSelector("#checkboxes > label:nth-child(1) > input[type=checkbox]");
        List<Locator> checkboxes = getLocator("#checkboxes > label > input[type=checkbox]").all();
        int checked = 0;
        for (Locator checkbox : checkboxes) {
            if (checkbox.isChecked()) checked++;
        }
        assertEquals(checked, 3);
        assertFalse(getLocator("#checkboxes > label:nth-child(5) > input[type=checkbox]").isChecked());
    }

    public void verifyRadiobuttonsInitialValues() {
        getBrowserManager().getPage().waitForSelector("#radio-buttons > input[type=radio]:nth-child(1)");
        List<Locator> radiobuttons = getLocator("#radio-buttons > input[type=radio]").all();
        int checked = 5;
        for (Locator radiobutton : radiobuttons) {
            if (!radiobutton.isChecked()) checked--;
        }
        assertEquals(checked, 0);
    }

    public void clickAllRadiobuttons() {
        List<Locator> radiobuttons = getLocator("#radio-buttons > input[type=radio]").all();
        for (Locator radiobutton : radiobuttons) {
            radiobutton.click();
        }
    }

    public void verifyCheckedRadioButton() {
        getBrowserManager().getPage().waitForSelector("#radio-buttons > input[type=radio]:nth-child(1)");
        List<Locator> radiobuttons = getLocator("#radio-buttons > input[type=radio]").all();
        int checked = 5;
        for (Locator radiobutton : radiobuttons) {
            if (!radiobutton.isChecked()) checked--;
        }
        assertEquals(checked, 1);
        assertTrue(getLocator("#radio-buttons > input[type=radio]:nth-child(9)").isChecked());
    }

    public void verifyInitiallySelectedRadiobuttonAndOption() {
        assertThat(getLocator("#radio-buttons-selected-disabled > input[type=radio]:nth-child(5)")).isChecked();
        String selected = getLocator("#fruit-selects option:checked").textContent();
        assertEquals(selected, "Grape");
    }

    public void selectOtherRadioButtonAndSelectOption() {
        getLocator("#radio-buttons-selected-disabled > input[type=radio]:nth-child(1)").click();
        getLocator("#fruit-selects").selectOption(new SelectOption().setLabel("Apple"));
    }

    public void verifyDisabledRadioButtonAndSelectOption() {
        assertThat(getLocator("#radio-buttons-selected-disabled > input[type=radio]:nth-child(3)")).isDisabled();
        assertThat(getLocator("#fruit-selects > option:nth-child(2)")).isDisabled();
    }
}

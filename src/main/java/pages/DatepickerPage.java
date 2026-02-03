package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import pages.base.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class DatepickerPage extends BasePage {

    private String date, month, numberMonth, year;

    public DatepickerPage(BrowserManager browserManager) {
        super(browserManager);
    }

    public void verifyInitialValue() {
        getBrowserManager().getPage().waitForSelector("#datepicker > input");
        String actualValue = getLocator("#datepicker > input").inputValue();
        String expectedValue = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        assertEquals(actualValue, expectedValue,
                "Input value did not match: " +
                "\nActual value: " + actualValue +
                "\nExpected value: " + expectedValue);
    }

    public void chooseSpecificDate() {
        getLocator("#datepicker > span").click();
        Locator targetDate = getLocator("//html/body/div[2]/div[1]/table/tbody/tr[3]/td[4]");
        date = targetDate.innerText();
        Locator targetMonth = getLocator("//html/body/div[2]/div[1]/table/thead/tr[1]/th[2]");
        String fullText = targetMonth.innerText();
        String[] parts = fullText.split(" ");
        month = parts[0];
        year = parts[1];
        targetDate.click();
    }

    public void verifyNewValue() {
        String actualValue = getLocator("#datepicker > input").inputValue();
        switch (month) {
            case "January" -> numberMonth = "01";
            case "February" -> numberMonth = "02";
            case "March" -> numberMonth = "03";
            case "April" -> numberMonth = "04";
            case "May" -> numberMonth = "05";
            case "June" -> numberMonth = "06";
            case "July" -> numberMonth = "07";
            case "August" -> numberMonth = "08";
            case "September" -> numberMonth = "09";
            case "October" -> numberMonth = "10";
            case "November" -> numberMonth = "11";
            case "December" -> numberMonth = "12";
        }
        String expectedValue = numberMonth+"-"+date+"-"+year;
        assertEquals(actualValue, expectedValue,
                "Input value did not match: " +
                        "\nActual value: " + actualValue +
                        "\nExpected value: " + expectedValue);
    }
}

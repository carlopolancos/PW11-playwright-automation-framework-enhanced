package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccordionPage;
import pages.FileUploadPage;

public class FileUploadSteps {

    private final FileUploadPage fileUploadPage;

    public FileUploadSteps(FileUploadPage fileUploadPage) {
        this.fileUploadPage = fileUploadPage;
    }

    @When("I upload the file {string}")
    public void iUploadTheFile(String fileName) {
        fileUploadPage.uploadFile(fileName);
    }

    @When("I click the submit file button")
    public void iClickTheSubmitFileButton() {
        fileUploadPage.clickSubmitFileButton();
    }

    @Then("The correct alert {string} will be displayed")
    public void theCorrectAlertWillBeDisplayed(String alertContent) {
        fileUploadPage.verifyAlertContent(alertContent);
    }
}

package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ToDoListPage;

public class ToDoListSteps {

    private final ToDoListPage toDoListPage;

    public ToDoListSteps(ToDoListPage toDoListPage) {
        this.toDoListPage = toDoListPage;
    }

    //CREATE
    @When("I create a new task {string}")
    public void iCreateANewTask(String name) {
        toDoListPage.createNewTask(name);
    }

    @Then("The new task {string} should be added to the list")
    public void theNewTaskShouldBeAddedToTheList(String taskName) {
        toDoListPage.verifyAddedTask(taskName);
    }

    //UPDATE
    @When("I completed the task {string}")
    public void iCompletedTheTask(String name) {
        toDoListPage.completeTask(name);
    }

    @Then("The task {string} should be marked as completed")
    public void theTaskShouldBeMarkedAsCompleted(String taskName) {
        toDoListPage.verifyCompletedTask(taskName);
    }

    //DELETE
    @When("I deleted the task {string}")
    public void iDeletedTheTask(String name) {
        toDoListPage.deleteTask(name);
    }

    @Then("The task {string} should not exist")
    public void theTaskShouldNotExist(String taskName) {
        toDoListPage.verifyDeletedTask(taskName);
    }
}

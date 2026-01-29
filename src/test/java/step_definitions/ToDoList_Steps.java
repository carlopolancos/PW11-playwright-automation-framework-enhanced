package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ToDoListPage;

public class ToDoList_Steps {

    private final ToDoListPage toDoListPage;

    public ToDoList_Steps(ToDoListPage toDoListPage) {
        this.toDoListPage = toDoListPage;
    }

    //CREATE
    @When("I create a new task {string}")
    public void i_create_a_new_task(String name) {
        toDoListPage.createNewTask(name);
    }

    @Then("The new task {string} should be added to the list")
    public void i_should_be_presented_with_a_modal_which_contains_text(String taskName) {
        toDoListPage.verifyAddedTask(taskName);
    }

    //UPDATE
    @When("I completed the task {string}")
    public void i_completed_the_task(String name) {
        toDoListPage.completeTask(name);
    }

    @Then("The task {string} should be marked as completed")
    public void the_task_should_be_marked_as_completed(String taskName) {
        toDoListPage.verifyCompletedTask(taskName);
    }

    //DELETE
    @When("I deleted the task {string}")
    public void i_deleted_the_task(String name) {
        toDoListPage.deleteTask(name);
    }

    @Then("The task {string} should not exist")
    public void the_task_should_not_exist(String taskName) {
        toDoListPage.verifyDeletedTask(taskName);
    }
}

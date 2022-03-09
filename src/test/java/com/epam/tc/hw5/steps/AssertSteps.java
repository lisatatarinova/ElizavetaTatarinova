package com.epam.tc.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AssertSteps extends AbstractStep {

    //DIFFERENT ELEMENTS PAGE

    @Then("Log rows are displayed")
    public void assertLogsDisplayed() {
        Assertions.assertThat(elementsPage.getItemLogs()).isNotEmpty();
    }

    @Then("{string} name = {string} and its status = {string} are corresponding to selected")
    public void assertCheckboxLogs(String itemType, String itemName, String itemStatus) {
        elementsPage.getItemLogs().stream()
                .forEach(item ->
                        Assertions.assertThat(item.matches("(.*)" + itemName + "(.*)" + itemStatus + "(.*)")));
    }

    //USER TABLE PAGE

    @Then("User Table page should be opened")
    public void assertThatPageOpens() {
        Assertions.assertThat(userTablePage.getCurrentPageUrl())
                .isEqualTo("https://jdi-testing.github.io/jdi-light/user-table.html");
    }

    @Then("{string} {string} should be displayed on Users Table on User Table Page")
    public void assertUserPageItem(String expCount, String itemType) {
        Assertions.assertThat(userTablePage.getTableItemsCounter(itemType))
                .isEqualTo(Integer.parseInt(expCount));
    }

    @Then("User table should contain following values")
    public void assertUserTableValues(DataTable userTable) {
        List<Map<String, String>> rows = userTable.asMaps(String.class, String.class);
        rows.stream().forEach(item -> Assertions.assertThat(userTablePage.getTableFromUserPage())
                .contains(item));
    }

    @Then("DropList should contain values in column Type for user Roman")
    public void assertDropListValues(DataTable userTable) {
        List<String> rows = new LinkedList<>(userTable.asList(String.class));
        rows.remove(0);
        System.out.println(rows);
        System.out.println(userTablePage.getDropDownValues().toString());
        Assertions.assertThat(userTablePage.getDropDownValues().toString())
                .isEqualTo(rows.toString());
    }

    @Then("1 log row has {string} text in log section")
    public void assertLogs(String logLine) {
        Assertions.assertThat(userTablePage.getLogs()).contains(logLine);
    }
}

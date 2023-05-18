package web.screens;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.CheckBox;
import web.component.Input;
import web.component.Table;
import web.util.Wait;

public class AutomationProcessesScreen {

    private final Table table = new Table(By.cssSelector("table.MuiTable-stickyHeader"));

    private final Button deleteButton = new Button(By.xpath("//p[text()='Delete']"));

    private final Button createNewButton = new Button(By.xpath("//button[text()='Create New']"));

    private final Input filterByTextInput = new Input(By.id("search_field"));

    public int getRowsNumber() {
        return table.getRowsNumber();
    }

    public void checkCheckBoxInHeader() {
        new CheckBox(table.getHeaders().get(0).findElement(By.tagName("input"))).check();
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public void clickCreateNew() {
        createNewButton.click();
    }

    public boolean isTableEmpty() {
        return table.isEmpty();
    }

    public void setFilterByText(String value) {
        filterByTextInput.setText(value);
        Wait.attributeContains(filterByTextInput.getElement(), "value", value);
    }
}
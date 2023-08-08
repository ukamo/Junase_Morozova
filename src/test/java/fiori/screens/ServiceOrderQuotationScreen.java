package fiori.screens;

import eu.ibagroup.junase.web.util.Wait;
import fiori.component.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ServiceOrderQuotationScreen {

    private static final String INPUT_BY_LABEL_XPATH = "//label[contains(text(),'%s')]//following::input[1]";

    private final TabContainer tabContainer = new TabContainer(By.id("anchorBar"));

    private final Table itemsTable = new Table(By.id("C13_W49_V50_V54_Tree_TableHeader"));

    private final Button saveButton = new Button(By.id("C9_W36_V39_thtmlb_button_6"));

    public void setInputByLabel(String labelName, String value) {
        Input input = new Input(By.xpath(String.format(INPUT_BY_LABEL_XPATH, labelName)));
        input.setText(value);
    }

    public void setInputByLabelAndClickEnter(String labelName, String value) {
        Input input = new Input(By.xpath(String.format(INPUT_BY_LABEL_XPATH, labelName)));
        input.setText(value);
        input.sendKeys(Keys.ENTER);
    }

    public void switchToTab(String tabName) {
        tabContainer.switchTo(tabName);
    }

    public boolean isItemsTableDisplayed() {
        return itemsTable.isDisplayed();
    }

    public void setInputInRowItemsTable(String columnHeader, String value, int rowIndex) {
        itemsTable.getRow(rowIndex).getCell(columnHeader).getInput().setText(value);
    }

    public void setInputInRowItemsTableAndClickEnter(String columnHeader, String value, int rowIndex) {
        Input input = itemsTable.getRow(rowIndex).getCell(columnHeader).getInput();
        input.setText(value);
        input.sendKeys(Keys.ENTER);
    }

    public void checkCheckboxesInColumn(String columnHeader) {
        List<WebElement> rows = itemsTable.getRows();
        Wait.functionPassed(() -> {
            rows.forEach((row) -> {
                if (!itemsTable.getRow(rows.indexOf(row)).getCell(columnHeader).getElement().findElements(By.className("th-sapcb-a")).isEmpty()) {
                    itemsTable.getRow(rows.indexOf(row)).getCell(columnHeader).getCheckbox().check();
                }
            });
        });
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}

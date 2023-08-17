package fiori.screens;

import eu.ibagroup.junase.web.util.Wait;
import fiori.component.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ServiceOrderQuotationScreen {

    private static final String INPUT_BY_LABEL_XPATH = "//label[contains(text(),'%s')]//following::input[1]";

    private static final String INPUT_BY_VALUE_XPATH = "//input[contains(@value,'%s')]//following::input[4]";

    private final TabContainer tabContainer = new TabContainer(By.id("anchorBar"));

    private final ButtonsContainer subHeaderButtonsContainer = new ButtonsContainer(By.id("tbOVFcontainerC1W1V2V3watoolbar"));

    private final ButtonsContainer itemsButtonsContainer = new ButtonsContainer(By.id("tbOVFcontainerC13W46V47V51Treediv"));

    private final Table itemsTable = new Table(By.xpath("//table[contains (@id, '_Tree_TableHeader')]"));

    private final Button searchButton = new Button(By.id("C6_W20_V22_Searchbtn"));

    private final Label transactionText = new Label(By.xpath("//div[@id='th-mess-cont1']//span[contains(text(),'Transaction')]"));

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
        tabContainer.switchToTab(tabName);
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
        itemsTable.checkAllCheckBoxes(columnHeader);
    }

    public String getTransactionText() {
        return transactionText.getText();
    }

    public void setInput(String valueName, String value) {
        Input input = new Input(By.xpath(String.format(INPUT_BY_VALUE_XPATH, valueName)));
        input.setText(value);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickButtonByNameOnSubHeader(String buttonName) {
        Wait.functionPassed(() -> {
            subHeaderButtonsContainer.getButtonByName(buttonName).doubleClick();
        });
    }

    public void clickButtonByName(String buttonName) {
        itemsButtonsContainer.getButtonByName(buttonName).click();
    }

    public String getValueInTable(String columnHeader, String value, String columnStatusHeader) {
        return itemsTable.getRowByValue(columnHeader, value, columnStatusHeader);

    }
    public String getReleasedStatusFromTable(String columnHeader, String value, String columnStatusHeader){
        return Wait.functionPassed(() -> itemsTable.getColumn(columnHeader).getRow(value).getCell(columnStatusHeader).getInput().getValue());
    }
    public String getCompletedStatusFromTable(String columnHeader, String value, String columnStatusHeader){
        return itemsTable.getColumn(columnHeader).getRow(value).getCell(columnStatusHeader).getText();
    }
}

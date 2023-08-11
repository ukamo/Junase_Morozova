package fiori.screens;

import fiori.component.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ServiceOrderQuotationScreen {

    private static final String INPUT_BY_LABEL_XPATH = "//label[contains(text(),'%s')]//following::input[1]";

    private static final String INPUT_BY_VALUE_XPATH = "//input[contains(@value,'%s')]//following::input[4]";

    private final TabContainer tabContainer = new TabContainer(By.id("tbOVFcontainerC9W36V39ovpAnchorNavigationBar"));

    private final Table itemsTable = new Table(By.id("C13_W49_V50_V54_Tree_TableHeader"));

    private final Button saveButton = new Button(By.id("C9_W36_V39_thtmlb_button_6"));

    private final Button successButton = new Button(By.id("th-mes-inf-cont"));

    private final Button backButton = new Button(By.id("backBtn"));

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

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isSuccessButtonDisplayed() {
        return successButton.isDisplayed();
    }

    public void clickSuccessButton() {
        successButton.click();
    }

    public String getTransactionText() {
        return transactionText.getText();
    }

    public void clickBackButton() {
        backButton.click();
    }

    public void setInput(String valueName, String value) {
        Input input = new Input(By.xpath(String.format(INPUT_BY_VALUE_XPATH, valueName)));
        input.setText(value);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}

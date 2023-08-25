package fiori.screens;

import fiori.component.Dialog;
import org.openqa.selenium.By;

public class CommonDialog {

    private static final String DIALOG_XPATH = "//span[@title='%s']/ancestor::*[contains(@Class,'th-dialog') and @ROLE='main']";

    private Dialog getDialogByTitle(String dialogTitle) {
        return new Dialog(By.xpath(String.format(DIALOG_XPATH, dialogTitle)));
    }

    public boolean isDialogWithTitleOpened(String dialogTitle) {
        return getDialogByTitle(dialogTitle).isDisplayed();
    }

    public boolean isTableDisplayedOnDialog(String dialogTitle) {
        return getDialogByTitle(dialogTitle).getTable().isDisplayed();
    }

    public int getRowsNumberFromTable(String dialogTitle) {
        return getDialogByTitle(dialogTitle).getTable().getRowsNumber();
    }

    public void clickHyperlinkByNameInTableColumn(String dialogTitle, String hyperlinkValue, String columnName) {
        getDialogByTitle(dialogTitle).getTable().getColumn(columnName).getRow(hyperlinkValue).getCell(columnName).getHyperlink().click();
    }

    public void selectRowWithCheckedCheckbox(String columnHeader, String dialogTitle) {
        getDialogByTitle(dialogTitle).getTable().getRowByColumnHeader(columnHeader).select();
    }
}

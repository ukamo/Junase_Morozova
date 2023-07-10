package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Dialog;
import org.openqa.selenium.By;

public class CommonDialog {

    private static final String DIALOG_XPATH = "//span[@title='%s']/ancestor::*[contains(@class,'th-body')]";

    private static final String APPLICATION_IFRAME_ID = "application-ServiceQuotation-create";

    private static final String DIALOG_IFRAME_ID = "thDialogIframe_1";

    private static final String POPUP_IFRAME_ID = "WorkAreaFrame1popup";

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> WebDriverManager.currentSession().getWebDriver().switchTo().defaultContent());
    }

    private void switchToIframe(String iFrameId) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.id(iFrameId)));
    }

    public void switchPopUpIframe() {
        switchToDefaultContent();
        switchToIframe(APPLICATION_IFRAME_ID);
        switchToIframe(DIALOG_IFRAME_ID);
        switchToIframe(POPUP_IFRAME_ID);
    }

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

    public void clickHyperlinkByNameInTableColumn(String dialogTitle, String titleName, String columnName) {
        getDialogByTitle(dialogTitle).getTable().getColumn(columnName).getRow(titleName).getCell(columnName).getHyperlink().click();
    }
}

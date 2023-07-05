package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Dialog;
import fiori.component.Input;
import fiori.component.Table;
import org.openqa.selenium.By;

public class SelectDialog {

    //td[@id='bcTitle']//span[text()='%s']
    private static final String DIALOG_XPATH = "//span[@title='%s']";

    //span[text()='SRVP']
    private static final String INPUT_XPATH = "//td/span[@title='%s']";

    private static final String APPLICATION_IFRAME_ID = "application-ServiceQuotation-create";

    private static final String DIALOG_IFRAME_ID = "thDialogIframe_1";

    private static final String POPUP_IFRAME_ID = "WorkAreaFrame1popup";

    private final Table transactionTypeTable = new Table(By.id("C8_W30_V31_Table_TableHeader"));

    private final Table selectOrganizationalDataTable = new Table(By.id("C15_W65_V66_V68_Table_TableHeader"));

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> WebDriverManager.currentSession().getWebDriver().switchTo().defaultContent());
    }

    private void switchToIframe(String xPathFrame) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.id(xPathFrame)));
    }

    public void switchPopUpIframe() {
        switchToDefaultContent();
        switchToIframe(APPLICATION_IFRAME_ID);
        switchToIframe(DIALOG_IFRAME_ID);
        switchToIframe(POPUP_IFRAME_ID);
    }

    public boolean isDialogNameOpened(String dialogName) {
        return new Dialog(By.xpath(String.format(DIALOG_XPATH, dialogName))).isDisplayed();
    }

    public boolean isSelectTransactionTypeTableDisplayed() {
        return transactionTypeTable.isDisplayed();
    }

    public int getRowsNumberSelectTransactionTypeTable() {
        return transactionTypeTable.getRowsNumber();
    }

    public boolean isSelectOrganizationalDataTableDisplayed() {
        return selectOrganizationalDataTable.isDisplayed();
    }

    public int getRowsNumberSelectOrganizationalDataTable() {
        return selectOrganizationalDataTable.getRowsNumber();
    }

    public void clickTitleByNameOnDialog(String titleName) {
        new Input(By.xpath(String.format(INPUT_XPATH, titleName))).click();
    }
}

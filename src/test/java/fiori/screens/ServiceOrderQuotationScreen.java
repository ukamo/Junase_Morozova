package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Dialog;
import fiori.component.Input;
import fiori.component.Table;
import org.openqa.selenium.By;

public class ServiceOrderQuotationScreen {

    private static final String DIV_BY_DIALOG_NAME = "//div[@id='_POPUP0001']//span[text()='%s']";

    private static final String TD_BY_TITLE = "//td/span[@title='%s']";

    private static final String APPLICATION_IFRAME_ID = "application-ServiceQuotation-create";

    private static final String DIALOG_IFRAME_ID = "thDialogIframe_1";

    private static final String SELECT_TRANSACTION_TYPE_IFRAME_ID = "WorkAreaFrame1popup";

    private final Table selectTransactionTypeTable = new Table(By.xpath("//div[@id='_POPUP0001']/table"));

    private final Table transactionTypeTable = new Table(By.xpath("//table[contains(@id,'Table_TableHeader')]"));

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> WebDriverManager.currentSession().getWebDriver().switchTo().defaultContent());
    }

    private void switchToIframe(String xPathFrame) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.id(xPathFrame)));
    }

    public void switchApplicationIframe() {
        switchToDefaultContent();
        switchToIframe(APPLICATION_IFRAME_ID);
    }

    public boolean isDialogWithNameOpened(String dialogName) {
        return new Dialog(By.xpath(String.format(DIV_BY_DIALOG_NAME, dialogName))).isDisplayed();
    }

    public void switchTransactionTypeIframe() {
        switchToIframe(DIALOG_IFRAME_ID);
        switchToIframe(SELECT_TRANSACTION_TYPE_IFRAME_ID);
    }

    public boolean isTableDisplayed() {
        return selectTransactionTypeTable.isDisplayed() & transactionTypeTable.isDisplayed();
    }

    public int getRowsNumber() {
        return transactionTypeTable.getRowsNumber();
    }

    public void clickTransactionType(String typeName) {
        new Input(By.xpath(String.format(TD_BY_TITLE, typeName))).click();
    }
}

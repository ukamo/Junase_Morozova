package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Dialog;
import fiori.component.Input;
import fiori.component.Table;
import org.openqa.selenium.By;

public class ServiceOrderQuotationScreen {

    private static final String IFRAME_COMMON = "//iframe[@title = 'Application']";

    private static final String DIV_BY_ROLE = "//div[@role='%s']";

    private static final String DIALOG_IFRAME_1 = "//iframe[@id='thDialogIframe_1']";

    private static final String SELECT_TRANSACTION_TYPE_IFRAME = "//iframe[@id='WorkAreaFrame1popup']";

    private static final String TITLE_BY_INPUT = "//*[@title='%s']";

    private final Table tableMain = new Table(By.xpath("//div[@id='_POPUP0001']/table"));

    private final Table tableTypes = new Table(By.xpath("//table[contains(@id,'Table_TableHeader')]"));

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> WebDriverManager.currentSession().getWebDriver().switchTo().defaultContent());
    }

    private void switchToIframe(String xPathFrame) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.xpath(xPathFrame)));
    }

    public void switchIFrameCommon() {
        switchToDefaultContent();
        switchToIframe(IFRAME_COMMON);
    }

    public boolean isDialogOpened(String dialogType) {
        return new Dialog(By.xpath(String.format(DIV_BY_ROLE, dialogType))).isDisplayed();
    }

    public void switchIFrameTransactionType() {
        switchToIframe(DIALOG_IFRAME_1);
        switchToIframe(SELECT_TRANSACTION_TYPE_IFRAME);
    }

    public boolean isTableDisplayed() {
        return tableMain.isDisplayed() & tableTypes.isDisplayed();
    }

    public int getRowsNumber() {
        return tableTypes.getRowsNumber();
    }

    public void clickTransactionType(String type) {
        new Input(By.xpath(String.format(TITLE_BY_INPUT, type))).click();
    }

}

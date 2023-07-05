package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Dialog;
import fiori.component.Input;
import fiori.component.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ServiceOrderQuotationScreen {

    //td[@id='bcTitle']//span[text()='%s']
    private static final String DIV_BY_DIALOG_NAME = "//span[@title='Select Transaction Type']";

    //span[text()='SRVP']
    private static final String TD_BY_TITLE = "//td/span[@title='%s']";

    private static final String APPLICATION_IFRAME_ID = "application-ServiceQuotation-create";

    private static final String DIALOG_IFRAME_ID = "thDialogIframe_1";

    private static final String POPUP_IFRAME_ID = "WorkAreaFrame1popup";

    private static final String SERVICE_QUOTATION_CREATE_ID = "application-ServiceQuotation-create";


    //"//div[@class='th-af-content']//input[contains(@id,'%s')]";
    private static final String CONTENT_INPUT_BY_ID = "//input[contains(@id,'%s')]";

    private final Table selectTransactionTypeTable = new Table(By.xpath("//div[@id='_POPUP0001']/table"));

    private final Table transactionTypeTable = new Table(By.xpath("//table[contains(@id,'Table_TableHeader')]"));

    private final Input SolutionQuotationNewInput = new Input(By.xpath("//table[@id='th-l-table-wccontainer']//span[@title='Solution Quotation: New']"));

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

    public boolean isDialogNameOpened(String dialogName) {
        return new Dialog(By.xpath(String.format(DIV_BY_DIALOG_NAME, dialogName))).isDisplayed();
    }

    public void switchPopUpIframe() {
        switchToIframe(DIALOG_IFRAME_ID);
        switchToIframe(POPUP_IFRAME_ID);
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

    public void switchServiceQuotationCreateIframe() {
        switchToDefaultContent();
        switchToIframe(SERVICE_QUOTATION_CREATE_ID);
    }

    public String getTextFromTable() {
        return SolutionQuotationNewInput.getText();
    }

    public void setValueInDescriptionField(String field) {
        String random = String.valueOf((int) Math.floor(Math.random() * 1000000));
        new Input(By.xpath(String.format(CONTENT_INPUT_BY_ID, field))).setText(random);
    }

    public void setValueInputField(String value, String field) {
        Input input = new Input(By.xpath(String.format(CONTENT_INPUT_BY_ID, field)));
        input.setText(value);
        input.sendKeys(Keys.ENTER);
    }
}

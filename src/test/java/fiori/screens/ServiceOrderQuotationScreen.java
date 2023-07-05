package fiori.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Input;
import fiori.util.TextUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ServiceOrderQuotationScreen {

    //"//div[@class='th-af-content']//input[contains(@id,'%s')]";
    private static final String CONTENT_INPUT_XPATH = "//label[contains(text(),'%s')]//ancestor::td[@class='ch-grid-cell']//..//following-sibling::tr[1]//input";

    private static final String SERVICE_QUOTATION_CREATE_ID = "application-ServiceQuotation-create";

    private final Input SolutionQuotationNewInput = new Input(By.xpath("//table[@id='th-l-table-wccontainer']//span[@title='Solution Quotation: New']"));

    public String getTextFromTable() {
        return SolutionQuotationNewInput.getText();
    }

    public String setRandomNumericValue(int sizeValue) {
        return TextUtil.generateNumericString(sizeValue);
    }

    public void setValueInDescriptionField(String field) {
        String random = setRandomNumericValue(11);
        new Input(By.xpath(String.format(CONTENT_INPUT_XPATH, field))).setText(random);
    }

    public void setValueInputField(String value, String field) {
        Input input = new Input(By.xpath(String.format(CONTENT_INPUT_XPATH, field)));
        input.clear();
        input.setText(value);
        input.sendKeys(Keys.ENTER);
    }

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> WebDriverManager.currentSession().getWebDriver().switchTo().defaultContent());
    }

    private void switchToIframe(String iframeID) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.id(iframeID)));
    }

    public void switchServiceQuotationCreateIframe() {
        switchToDefaultContent();
        switchToIframe(SERVICE_QUOTATION_CREATE_ID);
    }
}

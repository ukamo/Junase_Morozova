package sap.screens;

import org.openqa.selenium.Keys;
import eu.ibagroup.junase.sap.driver.api.locator.SapSearch;
import eu.ibagroup.junase.sap.component.SapComponent;

public class CompanyCodePage {

    private final SapComponent companyCodeInput = new SapComponent(SapSearch.sapId("wnd[1]/usr/ctxtBKPF-BUKRS"));

    private final SapComponent currencyInput = new SapComponent(SapSearch.sapId("wnd[0]/usr/tabsTS/tabpMAIN/ssubPAGE:SAPLFDCB:0010/ctxtINVFO-WAERS"));

    private final SapComponent window = new SapComponent(SapSearch.sapId("wnd[1]"));

    public void enterCompanyCode(String code) {
        companyCodeInput.setText(code);
        window.sendKeys(Keys.ENTER);
    }

    public String getCurrency() {
        return currencyInput.getText();
    }
}
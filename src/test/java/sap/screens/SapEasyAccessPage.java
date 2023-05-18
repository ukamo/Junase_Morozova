package sap.screens;

import eu.ibagroup.junase.sap.driver.api.locator.SapSearch;
import eu.ibagroup.junase.sap.component.SapComponent;

public class SapEasyAccessPage {

    private static final String VENDOR_INVOICE_CODE = "FB60";

    private final SapComponent commandInput = new SapComponent(SapSearch.sapId("wnd[0]/tbar[0]/okcd"));

    private final SapComponent window = new SapComponent(SapSearch.sapId("wnd[0]"));

    public void openInvoicePage() {
        commandInput.setText(VENDOR_INVOICE_CODE);
        window.sendEnter();
    }
}
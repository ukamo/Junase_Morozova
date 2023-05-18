package sap.steps;

import io.cucumber.java.en.Given;
import sap.screens.SapEasyAccessPage;

public class SapEasyAccessSteps {

    private final SapEasyAccessPage sapEasyAccessPage = new SapEasyAccessPage();

    @Given("I open Invoice Page")
    public void iOpenInvoicePage() {
        sapEasyAccessPage.openInvoicePage();
    }
}
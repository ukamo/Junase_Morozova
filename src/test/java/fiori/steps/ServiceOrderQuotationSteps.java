package fiori.steps;

import eu.ibagroup.junase.model.util.TextUtil;
import fiori.screens.ServiceOrderQuotationScreen;
import io.cucumber.java.en.When;

public class ServiceOrderQuotationSteps {

    private final ServiceOrderQuotationScreen serviceOrderQuotationScreen = new ServiceOrderQuotationScreen();

    @When("^I set (Description) as random string on tab (Quotation Details) on screen (Service Order Quotations) in application (Fiori)$")
    public void setInputByLabelAsRandomValue(String labelName, String tab, String screen, String app) {
        String randomValue = TextUtil.generateAlphanumericString(11);
        serviceOrderQuotationScreen.setInputByLabel(labelName, randomValue);
    }

    @When("^I set (.*) \"([0-9]+)\" on tab (Quotation Details) on screen (Service Order Quotations) in application (Fiori)$")
    public void setInputByLabelOnTab(String labelName, String value, String tab, String screen, String app) {
        if (labelName.equals("Employee")) {
            serviceOrderQuotationScreen.setInputByLabelAndClickEnter(labelName, value);
        } else {
            serviceOrderQuotationScreen.setInputByLabel(labelName, value);
        }
    }
}

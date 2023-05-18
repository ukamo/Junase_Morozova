package sap.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sap.screens.CompanyCodePage;

public class CompanyCodeDialogSteps {

    private final CompanyCodePage companyCodePage = new CompanyCodePage();

    @When("I enter company code {string}")
    public void iEnterCompanyCode(String companyCode) {
        companyCodePage.enterCompanyCode(companyCode);
    }

    @Then("I assert Document Currency is {string}")
    public void assertDocumentCurrency(String currency) {
        Assert.assertEquals(currency, companyCodePage.getCurrency());
    }
}
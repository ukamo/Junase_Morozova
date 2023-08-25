package fiori.steps;

import fiori.screens.HomeScreen;
import io.cucumber.java.en.When;

public class HomeSteps {
    
    HomeScreen homeScreen = new HomeScreen();

    @When("^I switch to tab (Subscription Management) on screen (Home) in application (Fiori)$")
    public void clickHyperlink(String hyperlinkName, String screen, String app) {
        homeScreen.switchToTab(hyperlinkName);
    }

    @When("^I click hyperlink (Manage Solution Quotations) on screen (Home) in application (Fiori)$")
    public void clickManageSolutionQuotations(String hyperlinkName, String screen, String app) {
        homeScreen.clickManageSolutionQuotations();
    }
}

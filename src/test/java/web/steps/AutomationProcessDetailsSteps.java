package web.steps;

import io.cucumber.java.en.When;
import web.screens.AutomationProcessDetailsScreen;

public class AutomationProcessDetailsSteps {

    private final AutomationProcessDetailsScreen automationProcessDetailsScreen = new AutomationProcessDetailsScreen();

    @When("^I set Name \"(.*)\" on screen (New Automation Process|Automation Process Details)$")
    public void setName(String name, String screen) {
        automationProcessDetailsScreen.setName(name);
    }

    @When("^I set Group Id \"(.*)\" on screen (New Automation Process|Automation Process Details)$")
    public void setGroupId(String value, String screen) {
        automationProcessDetailsScreen.setGroupId(value);
    }

    @When("^I set Artifact Id \"(.*)\" on screen (New Automation Process|Automation Process Details)$")
    public void setArtifactId(String name, String screen) {
        automationProcessDetailsScreen.setArtifactId(name);
    }

    @When("^I set Version Id \"(.*)\" on screen (New Automation Process|Automation Process Details)$")
    public void setVersionId(String value, String screen) {
        automationProcessDetailsScreen.setVersionId(value);
    }

    @When("^I click button (CREATE NEW) on screen (New Automation Process)$")
    public void clickCreateNew(String buttonName, String screen) {
        automationProcessDetailsScreen.clickCreateNew();
    }

    @When("^I click (Back to list) on screen (Automation Process Details)$")
    public void clickBackToList(String hyperlinkName, String screen) {
        automationProcessDetailsScreen.clickBackToList();
    }
}
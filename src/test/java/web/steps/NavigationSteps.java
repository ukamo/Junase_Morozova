package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
<<<<<<< Updated upstream
import web.screens.Navigation;
=======
import web.screens.NavigationScreen;
>>>>>>> Stashed changes

public class NavigationSteps {

    private final NavigationScreen navigation = new NavigationScreen();

    @Given("^I am on screen (.*) in application (Sap)$")
    @Then("^I assert I am on screen (.*) in application (Sap)$")
    public void assertScreenInApplication(String screen, String app) {
        Assert.assertTrue(() -> navigation.getScreenTitle().contains(screen));
    }

<<<<<<< Updated upstream
    @When("^I navigate (.*) on screen (Onliner) in application (Onliner)$")
    public void navigateSection(String section, String screen, String app) {
        navigation.navigateSection(section);
=======
    @When("^I set (.*) in field (.*) on screen (.*) in application (Sap)$")
    public void setValueInField(String value, String iconName, String screen, String app) {
        navigation.clickIconByName(iconName);
        navigation.setValue(value, iconName);
>>>>>>> Stashed changes
    }

    @When("^I switch to (.*) on screen (.*) in application (Sap)$")
    public void switchToTab(String tabName, String screen, String app) {
        navigation.clickTabByName(tabName);
    }

    @Then("^I assert modal window (.*) is opened on screen (.*) in application (Sap)$")
    public void assertModalWindowIsDisplayed(String modalName, String screen, String app) {
        navigation.switсhIFrameSelectTransactionType();
        Assert.assertEquals(modalName, navigation::getModalWindowText);
    }

    @When("^I navigate to type (.*) on modal window (.*) on screen (.*) in application (Sap)$")
    public void navigateTypeOnModalWindow(String type,String modalName, String screen, String app) {
        navigation.navigateType(type);
    }
}

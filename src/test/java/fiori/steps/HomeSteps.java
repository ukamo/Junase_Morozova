package fiori.steps;

import fiori.screens.HomeScreen;
import io.cucumber.java.en.When;

public class HomeSteps {

    private final HomeScreen homeScreen = new HomeScreen();

    @When("^I set (Search) (.*) on screen (.*) in application (Fiori)$")
    public void setValueInField(String iconName, String value, String screen, String app) {
        homeScreen.clickIconByName(iconName);
        homeScreen.setValue(value, iconName);
    }
}

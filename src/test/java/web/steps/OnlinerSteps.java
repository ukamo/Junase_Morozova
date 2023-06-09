package web.steps;

import io.cucumber.java.en.When;
import web.screens.OnlinerScreen;

public class OnlinerSteps {

    private final OnlinerScreen onlinerScreen = new OnlinerScreen();

    @When("^I navigate (.*) section on screen (Onliner) in application (Onliner)$")
    public void navigateSection(String section, String screen, String app) {
        onlinerScreen.navigateToSection(section);
    }

}

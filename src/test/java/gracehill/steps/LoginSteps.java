package gracehill.steps;

import gracehill.screens.LoginScreen;
import gracehill.screens.Navigation;
import gracehill.utils.PropertiesReader;
import io.cucumber.java.en.Given;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginSteps {

    private static final String CREDITS_FILE = "LoginCredentials.json";

    private final LoginScreen loginScreen = new LoginScreen();

    private final Navigation navigation = new Navigation();

    @Given("^I log in to application (Gracehill) with username \"(.*)\"$")
    public void logInToAppWithUsername(String app, String username) throws IOException, ParseException {
        String password = PropertiesReader.parseJSONFile(CREDITS_FILE, username);
        navigation.switchApplicationIframe();
        loginScreen.loginToApp(username, password);
    }
}

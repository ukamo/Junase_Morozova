package fiori.steps;

import fiori.screens.LoginScreen;
import gracehill.utils.PropertiesReader;
import io.cucumber.java.en.Given;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginSteps {

    private static final String CREDITS_FILE = "LoginCredentials.json";

    private final LoginScreen loginScreen = new LoginScreen();

    @Given("^I log in to application (Fiori) with username \"(.*)\"$")
    public void logInToAppWithUsername(String app, String username) throws IOException, ParseException {
        String password = PropertiesReader.parseJSONFile(CREDITS_FILE, username);
        loginScreen.loginToApp(username, password);
    }
}


package fiori.steps;

import io.cucumber.java.en.Given;
import org.json.simple.parser.ParseException;
import fiori.screens.LoginScreen;
import onliner.utils.PropertiesReader;

import java.io.IOException;

public class LoginSteps {

    private static final String CREDITS_FILE = "testdata/LoginCredentials.json";

    private final LoginScreen loginScreen = new LoginScreen();

    @Given("^I log in to application (Fiori) with username \"(.*)\"$")
    public void logInToAppWithUsername(String app, String username) throws IOException, ParseException, InterruptedException {
        String password = PropertiesReader.parseJSONFile(CREDITS_FILE, username);
        loginScreen.loginToApp(username, password);
    }
}


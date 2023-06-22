package fiori.steps;

import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import fiori.screens.LoginScreen;
import web.utils.PropertiesReader;

import java.io.IOException;

public class LoginSteps {

    private static final String CREDITS_FILE = "testdata/LoginCredentials.json";

    private final LoginScreen loginloginScreen = new LoginScreen();
    @When("^I log on to application (Sap) with username (.*)$")
    public void logOnToAppWithUsername(String app, String username) throws IOException, ParseException, InterruptedException {
        String password = PropertiesReader.parseJSONFile(CREDITS_FILE, username);
        Thread.sleep(2000);
        loginloginScreen.loginToApp(username, password);


    }

}


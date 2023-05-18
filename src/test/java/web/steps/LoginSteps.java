package web.steps;

import io.cucumber.java.en.Given;
import org.json.simple.parser.ParseException;
import web.screens.LoginScreen;

import java.io.IOException;

public class LoginSteps {

    private final LoginScreen loginScreen = new LoginScreen();

    private final static String FILE_NAME = "LoginCredentials.json";

    @Given("^I login to application with user \"(.*)\"$")
    public void loginToAppFromFileWithUser(String username) throws IOException, ParseException {
        loginScreen.loginToAppFromFileWithUser(username, FILE_NAME);
    }
}
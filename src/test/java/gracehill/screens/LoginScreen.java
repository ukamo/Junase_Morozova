package gracehill.screens;

import gracehill.component.Button;
import gracehill.component.Input;
import org.openqa.selenium.By;


public class LoginScreen {

    private final Input usernameInput = new Input(By.id("user_username"));

    private final Input passwordInput = new Input(By.id("user_password"));

    private final Button loginButton = new Button(By.className("btn-primary"));

    public void loginToApp(String username, String password) {
        usernameInput.setText(username);
        passwordInput.setText(password);
        loginButton.click();
    }
}

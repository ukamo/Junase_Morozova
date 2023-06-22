package fiori.screens;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.Input;

public class LoginScreen {
    private final Input usernameInput = new Input(By.xpath("//input[@id='USERNAME_FIELD-inner']"));

    private final Input passwordInput = new Input(By.xpath("//input[@id='PASSWORD_FIELD-inner']"));

    private final Button loginButton = new Button(By.id("LOGIN_LINK"));

    public void loginToApp(String username, String password) {
        usernameInput.setText(username);
        passwordInput.setText(password);
        loginButton.click();
    }
}

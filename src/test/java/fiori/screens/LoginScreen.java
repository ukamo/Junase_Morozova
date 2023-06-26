package fiori.screens;

import fiori.component.Button;
import fiori.component.Input;
import org.openqa.selenium.By;


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

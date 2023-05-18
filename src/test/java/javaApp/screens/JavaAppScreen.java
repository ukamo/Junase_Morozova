package javaApp.screens;

import javaApp.component.Button;
import javaApp.component.Input;
import javaApp.component.Label;
import org.openqa.selenium.By;

public class JavaAppScreen {

    private final Input userField = new Input(By.tagName("text-field"));

    private final Button logInButton = new Button(By.tagName("button"));

    private final Input passwordField = new Input(By.name("password"));

    private final Label messageText = new Label(By.tagName("button"));

    public void setUserName(String userName) {
        userField.setText(userName);
    }

    public void setUserPassword(String password) {
        passwordField.setText(password);
    }

    public void clickLoginButton() {
        logInButton.click();
    }

    public boolean isTitleDisplayed(){
        return messageText.isDisplayed();
    }
}
package mobile.screens;

import mobile.component.Button;
import mobile.component.Input;
import org.openqa.selenium.By;

public class ComposePageScreen {

    private final Input fromAccount = new Input(By.id("com.google.android.gm:id/from_account_name"));

    private final Input toAccount = new Input(By.id("com.google.android.gm:id/to"));

    private final Input subject = new Input(By.id("com.google.android.gm:id/subject"));

    private final Button sendButton = new Button(By.id("com.google.android.gm:id/send"));

    public String getUserFromName() {
        return fromAccount.getText();
    }

    public void setUserTo(String email) {
        toAccount.setText(email);
    }

    public void setSubject(String text) {
        subject.setText(text);
    }

    public void clickSendButton() {
        sendButton.click();
    }
}
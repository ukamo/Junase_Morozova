package mobile.screens;

import mobile.component.Button;
import mobile.component.Label;
import org.openqa.selenium.By;

public class WelcomeScreen {

    private final Label headerLabel = new Label(By.id("com.google.android.gm:id/gmail_logo"));

    private final Button gotItButton = new Button(By.id("com.google.android.gm:id/welcome_tour_got_it"));

    private final Button takeMeToGmailButton = new Button(By.id("com.google.android.gm:id/action_done"));

    private final Label userName = new Label(By.id("com.google.android.gm:id/account_display_name"));

    private final Label userAddress = new Label(By.id("com.google.android.gm:id/account_address"));

    public boolean isHeaderLabelDisplayed() {
        return headerLabel.isDisplayed();
    }

    public void clickGotItButton() {
        gotItButton.click();
    }

    public void clickTakeMeToGmailButton() {
        takeMeToGmailButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public String getUserAddress() {
        return userAddress.getText();
    }
}
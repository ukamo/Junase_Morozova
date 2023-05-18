package mobile.screens;

import mobile.component.Button;
import mobile.component.Label;
import org.openqa.selenium.By;

public class MainPageScreen {

    private final Label userLabel = new Label(By.id("com.google.android.gm:id/og_apd_ring_view"));

    private final Button newEmailButton = new Button(By.id("com.google.android.gm:id/compose_button"));

    private final Label subjectLabel = new Label(By.id("com.google.android.gm:id/subject"));

    private final Label alertMessage = new Label(By.id("android:id/message"));

    private final Label alertSmartComposeMessage = new Label(By.id("com.google.android.gm:id/custom"));

    private final Button alertMessageOkButton = new Button(By.id("android:id/button1"));

    public boolean isUserIconDisplayed() {
        return userLabel.isDisplayed();
    }

    public boolean isNewEmailButtonDisplayed() {
        return newEmailButton.isDisplayed();
    }

    public boolean isSubjectMessageDisplayed() {
        return subjectLabel.isDisplayed();
    }

    public void clickNewEmailButton() {
        newEmailButton.click();
    }

    public void acceptAlert() {
        while (alertMessage.isDisplayed() | alertSmartComposeMessage.isDisplayed())
            alertMessageOkButton.click();
    }
}
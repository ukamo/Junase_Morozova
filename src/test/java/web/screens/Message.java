package web.screens;

import desktop.component.Label;
import org.openqa.selenium.By;
import web.util.Wait;

public class Message {

    private final Label messageContainer = new Label(By.id("notistack-snackbar"));

    public String getMessage() {
        return Wait.functionPassed(() -> messageContainer.getAttribute("innerText").trim());
    }

    public void waitForMessageContainerToHide(String text) {
        Wait.inVisibilityOfElement(messageContainer.getElement().findElement(By.xpath(String.format("//div[text()='%s']", text))));
    }
}
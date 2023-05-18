package web.screens;

import org.openqa.selenium.By;
import web.component.Dialog;

public class CommonDialog {

    private final Dialog dialog = new Dialog(By.xpath("//div[@role='dialog']"));

    public boolean isDialogOpened() {
        return dialog.isDisplayed();
    }

    public void clickButton(String buttonName) {
        dialog.clickButtonByName(buttonName);
    }

    public String getMessageText() {
        return dialog.getMessage();
    }
}
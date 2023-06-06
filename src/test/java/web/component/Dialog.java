package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Dialog - a class for dialogs.
 */
public class Dialog extends WebComponent {

    public Dialog(By locator) {
        super(locator);
    }

    //FIXME: remove unused methods and components through all the project
    public void clickButtonByName(String buttonName) {
        List<WebElement> dialogButtons = getElement().findElements(By.tagName("button"));
        for (WebElement button : dialogButtons) {
            if (button.getText().equalsIgnoreCase(buttonName)) {
                button.click();
                return;
            }
        }
        throw new IllegalStateException("Cannot locate button with text [" + buttonName + "]");
    }

    //FIXME: remove unused methods and components through all the project
    public String getMessage() {
        return getElement().findElement(By.id("confirm-modal-description")).getText();
    }

    //FIXME: the method should return the button object from the dialog
    public void clickButtonById() {
        WebElement element = getElement().findElement(By.xpath("//div[contains(@class,'offers-form__control_condensed-alter')]//span[contains(@class,'offers-form__button')]"));
        element.click();
    }
}
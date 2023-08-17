package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * ButtonsContainer - a component for the <ul> list item which contains the button.
 */
public class ButtonsContainer extends WebComponent {

    public ButtonsContainer(By locator) {
        super(locator);
    }

    public Button getButtonByName(String buttonName) {
        return Wait.functionPassed(() -> {
            List<WebElement> buttons = getElement().findElements(By.className("th-bt-b"));
            for (WebElement button : buttons) {
                if (button.getText().equals(buttonName)) {
                    return new Button(button);
                }
            }
            throw new IllegalStateException("Cannot locate element with text [" + buttonName + "]");
        });
    }
}

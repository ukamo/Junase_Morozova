package onliner.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import eu.ibagroup.junase.web.util.Wait;

/**
 * Input - a component for inputs. Allows to set random values.
 */
public class Input extends WebComponent {

    public Input(By locator) {
        super(locator);
    }

    /**
     * Cleans the input field and sets the text.
     *
     * @param value - text to set
     */
    public void setText(String value) {
        Wait.functionPassed(() -> {
            clear();
            sendKeys(value);
        });
    }

    /**
     * Cleans the input field.
     */
    public void clear() {
        getElement().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }

    /**
     * Sets the text to the input field.
     *
     * @param value - text to set
     */
    public void sendKeys(String value) {
        Wait.functionPassed(() -> getElement().sendKeys(value));
    }
}
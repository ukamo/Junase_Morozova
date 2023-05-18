package desktop.component;

import eu.ibagroup.junase.desktop.component.DesktopComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import eu.ibagroup.junase.model.util.CommonWait;

/**
 * Input - a model.component for inputs and text areas. Allows to set random values.
 */
public class Input extends DesktopComponent {

    public Input(By locator) {
        super(locator);
    }

    /**
     * Cleans the input field.
     */
    public void clear() {
        getElement().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }

    /**
     * Cleans the input field and sets the text.
     *
     * @param value - text to set
     */
    public void setText(String value) {
        CommonWait.functionPassed(() -> {
            clear();
            getElement().sendKeys(value);
        });
    }
}
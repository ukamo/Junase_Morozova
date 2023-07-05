package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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

    public void sendKeys(Keys key) {
        getElement().sendKeys(key);
    }

    @Override
    public Input scrollToElement() {
        return (Input) super.scrollToElement();
    }

    public void click() {
        Wait.functionPassed(() -> {
            Wait.elementToBeClickable(getLocator());
            getElement().click();
        });
    }
}
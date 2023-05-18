package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.util.Wait;

/**
 * CheckBox - a model.component for checkboxes.
 */
public class CheckBox extends WebComponent {

    public static final String CHECKED = "checked";

    public CheckBox(By locator) {
        super(locator);
    }

    public CheckBox(WebElement element) {
        super(element);
    }

    /**
     * Checks checkbox, but does nothing, if it is already checked.
     */
    public void check() {
        Wait.functionPassed(() -> {
            if (!isChecked()) {
                getElement().click();
            }
        });
    }

    /**
     * Unchecks checkbox, but does nothing, if it is already unchecked.
     */
    public void uncheck() {
        Wait.functionPassed(() -> {
            if (isChecked()) {
                getElement().click();
            }
        });
    }

    /**
     * Verifies if checkbox is checked.
     */
    public boolean isChecked() {
        return getElement().getAttribute("class").contains(CHECKED);
    }

    @Override
    public CheckBox scrollToElement() {
        return (CheckBox) super.scrollToElement();
    }
}
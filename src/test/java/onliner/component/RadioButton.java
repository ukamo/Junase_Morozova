package onliner.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.web.util.Wait;

/**
 * RadioButton - a model.component for radio buttons.
 */
public class RadioButton extends WebComponent {

    public static final String CHECKED = "checked";

    public RadioButton(By locator) {
        super(locator);
    }

    public RadioButton(WebElement element) {
        super(element);
    }

    /**
     * Selects radio button, but does nothing, if it is already selected.
     */
    public void select() {
        Wait.functionPassed(() -> {
            if (!isSelected()) {
                getElement().click();
            }
        });
    }

    /**
     * Unselects radio button, but does nothing, if it is not selected.
     */
    public void unselect() {
        Wait.functionPassed(() -> {
            if (isSelected()) {
                getElement().click();
            }
        });
    }

    /**
     * Verifies if radio button is selected.
     */
    public boolean isSelected() {
        return getElement().getAttribute(CHECKED) != null;
    }

    @Override
    public RadioButton scrollToElement() {
        return (RadioButton) super.scrollToElement();
    }
}
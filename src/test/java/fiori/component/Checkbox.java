package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

/**
 * CheckBox - a component for checkboxes.
 */
public class Checkbox extends WebComponent {

    public Checkbox(By locator) {
        super(locator);
    }

    protected Checkbox(WebElement element) {
        super(element);
    }


    /**
     * The method asserts if the checkbox is checked.
     */
    public boolean isChecked() {
        return getElement().getAttribute("aria-checked").equals("true");
    }

    /**
     * The method checks the checkbox.
     */
    public void check() {
        functionPassed(() -> {
            if (!isChecked()) {
                getElement().click();
            }
        });
    }
}

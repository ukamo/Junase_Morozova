package gracehill.component;

import eu.ibagroup.junase.web.component.WebControl;
import org.openqa.selenium.By;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

public class Checkbox extends WebControl {
    public Checkbox(By locator) {
        super(locator);
    }

    /**
     * The method asserts if the checkbox is checked.
     */
    public boolean isChecked() {
        return getElement().getAttribute("value").equals("true");
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

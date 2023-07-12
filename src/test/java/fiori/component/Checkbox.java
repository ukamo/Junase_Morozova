package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}

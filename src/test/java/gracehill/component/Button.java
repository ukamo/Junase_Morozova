package gracehill.component;

import eu.ibagroup.junase.web.component.WebControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Button - a component for buttons.
 */
public class Button extends WebControl {

    public Button(By locator) {
        super(locator);
    }

    protected Button(WebElement element) {
        super(element);
    }
}
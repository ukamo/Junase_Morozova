package web.component;

import eu.ibagroup.junase.model.component.Control;
import eu.ibagroup.junase.web.component.WebComponent;
import eu.ibagroup.junase.web.component.WebControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.web.util.Wait;

import java.util.List;

/**
 * Button - a model.component for buttons.
 */
public class Button extends WebControl {

    public Button(By locator) {
        super(locator);
    }

    @Override
    public Button scrollToElement() {
        return (Button) super.scrollToElement();
    }
}
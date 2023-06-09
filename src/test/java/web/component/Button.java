package web.component;

import eu.ibagroup.junase.web.component.WebControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/**
 * Button - a model.component for buttons.
 */
public class Button extends WebControl {

    public Button(By locator) {
        super(locator);
    }
    public Button(WebElement element) {
        super(element);
    }

    @Override
    public Button scrollToElement() {
        return (Button) super.scrollToElement();
    }
}
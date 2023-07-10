package fiori.component;

import eu.ibagroup.junase.web.component.WebControl;
import org.openqa.selenium.By;

/**
 * Button - a component for buttons.
 */
public class Button extends WebControl {

    public Button(By locator) {
        super(locator);
    }

    /**
     * The method scrolls to the element and then returns the element, so that it is possible
     * to call the next method in chain.
     *
     * @return Button
     */
    @Override
    public Button scrollToElement() {
        return (Button) super.scrollToElement();
    }
}
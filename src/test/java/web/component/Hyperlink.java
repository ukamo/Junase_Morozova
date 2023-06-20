package web.component;

import eu.ibagroup.junase.model.component.Control;
import eu.ibagroup.junase.web.component.WebComponent;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Hyperlink - a model.component for hyperlinks.
 */
public class Hyperlink extends WebComponent {

    public Hyperlink(By locator) {
        super(locator);
    }

    public Hyperlink(WebElement element) {
        super(element);
    }

    @Override
    public Hyperlink scrollToElement() {
        return (Hyperlink) super.scrollToElement();
    }

    public void click() {
        Wait.functionPassed(() -> {
            Wait.elementToBeClickable(getLocator());
            getElement().click();
        });
    }

}
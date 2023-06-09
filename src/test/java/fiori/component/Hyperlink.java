package fiori.component;

import eu.ibagroup.junase.web.component.WebControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Hyperlink - a model.component for hyperlinks.
 */
public class Hyperlink extends WebControl {

    public Hyperlink(By locator) {
        super(locator);
    }

    public Hyperlink(WebElement element) {
        super(element);
    }
}

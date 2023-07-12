package onliner.component;

import eu.ibagroup.junase.web.component.WebControl;
import org.openqa.selenium.By;

/**
 * Hyperlink - a component for hyperlinks.
 */
public class Hyperlink extends WebControl {

    public Hyperlink(By locator) {
        super(locator);
    }
}
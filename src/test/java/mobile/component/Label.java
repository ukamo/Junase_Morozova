package mobile.component;

import eu.ibagroup.junase.mobile.component.MobileComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Label - a model.component for labels.
 */
public class Label extends MobileComponent {

    public Label(By locator) {
        super(locator);
    }

    Label(WebElement element) {
        super(element);
    }
}
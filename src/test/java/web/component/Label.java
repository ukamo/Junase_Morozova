package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Label - a model.component for labels.
 */
public class Label extends WebComponent {

    public Label(By locator) {
        super(locator);
    }

    public Label(WebElement element) {
        super(element);
    }

}
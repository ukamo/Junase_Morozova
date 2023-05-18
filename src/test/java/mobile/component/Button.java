package mobile.component;

import eu.ibagroup.junase.mobile.component.MobileComponent;
import eu.ibagroup.junase.model.component.Control;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.model.util.CommonWait;

/**
 * Button - a model.component for buttons.
 */
public class Button extends MobileComponent implements Control {

    public Button(By locator) {
        super(locator);
    }

    Button(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        CommonWait.functionPassed(() -> getElement().click());
    }

    @Override
    public void rightClick() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void doubleClick() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void jsClick() {
        throw new UnsupportedOperationException();
    }
}
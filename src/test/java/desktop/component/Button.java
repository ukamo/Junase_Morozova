package desktop.component;

import eu.ibagroup.junase.desktop.component.DesktopComponent;
import eu.ibagroup.junase.model.component.Control;
import org.openqa.selenium.By;

/**
 * Button - a model.component for buttons.
 */
public class Button extends DesktopComponent implements Control {

    public Button(By locator) {
        super(locator);
    }

    @Override
    public void click() {
        getElement().click();
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
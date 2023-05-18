package javaApp.component;

import eu.ibagroup.junase.javaApp.component.JavaAppComponent;
import eu.ibagroup.junase.model.component.Control;
import org.openqa.selenium.By;
import eu.ibagroup.junase.model.util.CommonWait;

/**
 * Button - a model.component for buttons.
 */
public class Button extends JavaAppComponent implements Control {

    public Button(By locator) {
        super(locator);
    }

    @Override
    public void click() {
        CommonWait.elementToBeClickable(getElement());
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
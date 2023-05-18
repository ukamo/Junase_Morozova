package web.component;

import eu.ibagroup.junase.model.component.Control;
import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.util.Wait;

/**
 * Button - a model.component for buttons.
 */
public class Button extends WebComponent implements Control {

    public Button(By locator) {
        super(locator);
    }

    public Button(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        Wait.functionPassed(() -> {
            Wait.elementToBeClickable(getLocator());
            getElement().click();
        });
    }

    @Override
    public void jsClick() {
        Wait.functionPassed(() -> {
            Wait.elementToBeClickable(getElement());
            getJavascriptExecutor().executeScript("arguments[0].click();", getElement());
        });
    }

    @Override
    public void rightClick() {
        Wait.functionPassed(() -> {
            Wait.elementToBeClickable(getLocator());
            getActionBuilder().contextClick(getElement()).perform();
        });
    }

    @Override
    public void doubleClick() {
        Wait.functionPassed(() -> {
            Wait.elementToBeClickable(getLocator());
            getActionBuilder().doubleClick(getElement()).perform();
        });
    }

    @Override
    public Button scrollToElement() {
        return (Button) super.scrollToElement();
    }
}
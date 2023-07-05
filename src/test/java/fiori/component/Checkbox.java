package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Checkbox extends WebComponent {

    public Checkbox(By locator) {
        super(locator);
    }

    protected Checkbox(WebElement element) {
        super(element);
    }

    public void click() {
        Wait.functionPassed(() -> {
            Wait.elementToBeClickable(getLocator());
            getElement().click();
        });
    }
}

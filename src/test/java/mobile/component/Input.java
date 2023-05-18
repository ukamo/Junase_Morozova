package mobile.component;

import eu.ibagroup.junase.mobile.component.MobileComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.model.util.CommonWait;

/**
 * Input - a model.component for inputs.
 */
public class Input extends MobileComponent {

    public Input(By locator) {
        super(locator);
    }

    Input(WebElement element) {
        super(element);
    }

    /**
     * The method cleans input and set the text.
     *
     * @param value Text to set.
     */
    public void setText(String value) {
        CommonWait.functionPassed(() -> {
            WebElement element = getElement();
            element.click();
            element.clear();
            element.sendKeys(value);
        });
    }
}
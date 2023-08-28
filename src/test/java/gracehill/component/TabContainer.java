package gracehill.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TabContainer extends WebComponent {
    public TabContainer(By locator) {
        super(locator);
    }

    /**
     * The method returns the active stage.
     *
     * @return WebElement stage
     */
    public WebElement getHeaderTab() {
        return getElement().findElement(By.tagName("h5"));
    }

}

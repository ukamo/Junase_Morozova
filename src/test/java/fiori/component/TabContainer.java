package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * TabContainer - a component for the tabs in container.
 */
public class TabContainer extends WebComponent {

    public TabContainer(By locator) {
        super(locator);
    }

    /**
     * The method returns the active stage.
     *
     * @return WebElement stage
     */
    public WebElement getActiveStage() {
        return getElement().findElement(By.className("th-l-anchorNav-topAB"));
    }
}
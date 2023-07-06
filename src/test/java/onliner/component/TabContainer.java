package onliner.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.web.util.Wait;

/**
 * TabContainer - a component for the tabs in container.
 */
public class TabContainer extends WebComponent {

    public TabContainer(By locator) {
        super(locator);
    }

    /**
     * Returns the tab from the tab container by its name, passed as a parameter.
     *
     * @param tabName - the name of the tab to return
     * @return WebElement tab
     */
    private WebElement getTab(String tabName) {
        for (WebElement tab : getElement().findElements(By.className("search__tabs-item"))) {
            if (tab.getText().equals(tabName)) {
                return tab;
            }
        }
        throw new IllegalStateException("Cannot locate tab with label [" + tabName + "]");
    }

    /**
     * Returns the name of the active tab from the tab container.
     */
    public String getActiveTab() {
        return getElement().findElement(By.className("search__tabs-item_active")).getText();
    }

    /**
     * Switches to the desired tab by its name, passed as a parameter.
     */
    public void switchTo(String tabName) {
        Wait.functionPassed(getTab(tabName)::click);
    }
}
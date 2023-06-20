package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.web.util.Wait;

/**
 * TabContainer - a model.component for the tabs in container.
 */
public class TabContainer extends WebComponent {

    public TabContainer(By locator) {
        super(locator);
    }

    public TabContainer(WebElement element) {
        super(element);
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
        return getElement().findElement(By.xpath("//div[contains(@class,'search__tabs-item_active')]")).getText();
    }

    /**
     * Switches to the desired tab by its name, passed as a parameter.
     */
    public void switchTo(String tabName) {
        WebElement tab = getTab(tabName);
        if (tab == null) {
            throw new IllegalStateException("The tab [" + tabName + "] was not found.");
        }
        Wait.functionPassed(tab::click);
    }
}
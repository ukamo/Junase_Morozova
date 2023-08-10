package fiori.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static eu.ibagroup.junase.web.util.Wait.functionPassed;

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
    public WebElement getActiveTab() {
        return getElement().findElement(By.className("th-l-anchorNav-topAB"));
    }

    /**
     * The method returns the tab from the tab container by its name, passed as a parameter.
     *
     * @param tabName - the name of the tab to return
     * @return WebElement tab
     */
    private WebElement getTab(String tabName) {
        for (WebElement tab : getElement().findElements(By.className("th-bt-b"))) {
            if (tab.getText().equals(tabName)) {
                return tab;
            }
        }
        return null;
    }

    /**
     * The method returns the tab from the Group tab container by its name, passed as a parameter.
     *
     * @param tabName - the name of the tab to return
     * @return WebElement tab
     */
    private WebElement getGroupTab(String tabName) {
        for (WebElement tab : getElement().findElements(By.className("sapMITHTextContent"))) {
            if (tab.getText().equals(tabName)) {
                return tab;
            }
        }
        return null;
    }

    /**
     * The method returns the tab from the Tile tab container by its name, passed as a parameter.
     *
     * @param tabName - the name of the tab to return
     * @return WebElement tab
     */
    private WebElement getTileTab(String tabName) {
        for (WebElement tab : getElement().findElements(By.className("sapFGridContainerItemWrapper"))) {
            if (tab.getText().replaceAll("[^a-zA-Z0-9 ]", "").equals(tabName)) {
                return tab;
            }
        }
       throw new IllegalStateException("Cannot locate tab with label [" + tabName + "]");
    }

    /**
     * The method switches to the desired tab by its name, passed as a parameter.
     *
     * @param tabName - the name of the tab to switch to
     */
    public void switchToTab(String tabName) {
        WebElement tab = getTab(tabName);
        if (tab == null) {
            throw new IllegalStateException("The tab [" + tabName + "] was not found.");
        }
        functionPassed(tab::click);
    }

    /**
     * The method switches to the desired Group tab by its name, passed as a parameter.
     *
     * @param tabName - the name of the tab to switch to
     */
    public void switchToGroup(String tabName) {
        WebElement tab = getGroupTab(tabName);
        if (tab == null) {
            throw new IllegalStateException("The tab [" + tabName + "] was not found.");
        }
        functionPassed(tab::click);
    }

    /**
     * The method switches to the desired Tile tab by its name, passed as a parameter.
     *
     * @param tabName - the name of the tab to switch to
     */
    public void switchToTile(String tabName) {
        WebElement tab = getTileTab(tabName);
        if (tab == null) {
            throw new IllegalStateException("The tab [" + tabName + "] was not found.");
        }
        functionPassed(tab::click);
    }
}
package web.screens;

import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import web.component.Dialog;
import web.component.Hyperlink;
import web.component.Input;
import web.component.TabContainer;

public class OnlinerScreen {

    private static final String IFRAME_SEARCH = "//iframe[contains(@class,'modal-iframe')]";

    private static final String INPUT_BY_PLACEHOLDER_XPATH = "//input[contains(@Placeholder,'%s')]";

    private static final String HYPERLINK_XPATH = "//div[@class='forum__title']/a[text()='%s']";

    private final Dialog dialogSearch = new Dialog(By.id("search-page"));

    private final TabContainer tabContainer = new TabContainer(By.className("search__tabs"));

    public void switchToIFrame() {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.xpath(IFRAME_SEARCH)));
    }

    public String getActiveTabName() {
        return tabContainer.getActiveTab();
    }

    public void setInputByPlaceholder(String placeholder, String value) {
        new Input(By.xpath(String.format(INPUT_BY_PLACEHOLDER_XPATH, placeholder))).setText(value);
    }

    public boolean isSearchDialogDisplayed() {
        return dialogSearch.isDisplayed();
    }

    public void switchToTab(String tabName) {
        tabContainer.switchTo(tabName);
    }

    public void clickHyperlinkByName(String hyperlinkName) {
        new Hyperlink(By.xpath(String.format(HYPERLINK_XPATH, hyperlinkName))).click();
    }
}

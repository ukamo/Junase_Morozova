package web.screens;

import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import web.component.Dialog;
import web.component.Input;
import web.component.TabContainer;

public class OnlinerScreen {

    private static final String iframeSearch = "//iframe[contains(@class,'modal-iframe')]";

    private static final String searchInputXpath = "//input[contains(@placeholder,'%s')]";

    private final Dialog dialogSearch = new Dialog(By.xpath("//div[contains(@id,'search-page')]"));

    private final TabContainer tabContainer = new TabContainer(By.xpath("//div[@class='search__tabs']"));

    private void switchToIframe(String xPathFrame) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.xpath(xPathFrame)));
    }

    public void swithIFrame() {
        switchToIframe(iframeSearch);
    }

    public String getTextFromTab() {
        return tabContainer.getActiveTab();
    }

    public void setValue(String tab, String value) {
        new Input(By.xpath(String.format(searchInputXpath, tab)))
                .setSearchCatalog(value, Keys.ENTER);
    }

    public boolean isDialogSearchDisplayed() {
        return dialogSearch.isDisplayed();
    }

    public void switchToTab(String section) {
        tabContainer.switchTo(section);
    }
}

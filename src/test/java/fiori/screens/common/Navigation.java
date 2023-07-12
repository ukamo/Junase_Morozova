package fiori.screens.common;

import eu.ibagroup.junase.web.test.WebDriverManager;
import eu.ibagroup.junase.web.util.Wait;
import fiori.component.Autocomplete;
import fiori.component.Button;
import fiori.component.TabContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation {

    private static final String APPLICATION_IFRAME_ID = "application-ServiceQuotation-create";

    private static final String DIALOG_IFRAME_ID = "thDialogIframe_1";

    private static final String POPUP_IFRAME_ID = "WorkAreaFrame1popup";

    private final Button searchButton = new Button(By.id("sf"));

    private final Autocomplete searchAutocomplete = new Autocomplete(By.id("searchFieldInShell-input-inner"));

    private final TabContainer tabContainer = new TabContainer(By.id("anchorBar"));

    public static WebDriver driver;

    public Navigation() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public String getScreenTitle() {
        return driver.getTitle();
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void selectAutocompete(String value) {
        searchAutocomplete.selectValue(value);
    }

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> WebDriverManager.currentSession().getWebDriver().switchTo().defaultContent());
    }

    private void switchToIframe(String iFrameId) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.id(iFrameId)));
    }

    public void switchPopUpIframe() {
        switchToDefaultContent();
        switchToIframe(APPLICATION_IFRAME_ID);
        switchToIframe(DIALOG_IFRAME_ID);
        switchToIframe(POPUP_IFRAME_ID);
    }

    public void switchApplicationIframe() {
        switchToDefaultContent();
        switchToIframe(APPLICATION_IFRAME_ID);
    }

    public String getActiveTab() {
        return tabContainer.getActiveTab().getText();
    }
}

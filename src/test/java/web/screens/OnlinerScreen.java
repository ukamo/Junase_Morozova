package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import web.component.Input;
import web.util.Wait;

public class OnlinerScreen {

    public static WebDriver driver;

    private static final String iframeSearch = "//iframe[contains(@class,'modal-iframe')]";

    private final Input searchInput = new Input(By.xpath("//input[contains(@class,'fast-search__input')]"));

    private final Input searchActiveInput = new Input(By.className("search__tabs-item_active"));

    public OnlinerScreen() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public void navigateToSearch() {
        searchInput.click();
    }

    public String getSearchTab() {
        return searchInput.getAttribute("placeholder");
    }

    public void setTextInSearch(String text) {
        searchInput.setTextAndSendKeys(text, Keys.ENTER);
    }

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> driver.switchTo().defaultContent());
    }

    private void switchToIframe(String xPathFrame) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.xpath(xPathFrame)));
    }

    public void swithOnIFrameField() {
        switchToDefaultContent();
        switchToIframe(iframeSearch);
    }

    public String getTextFromTab() {
        return searchActiveInput.getText();
    }
}

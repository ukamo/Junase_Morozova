package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import web.component.Input;
import web.util.Wait;

public class OnlinerScreen {
    private static final Input inputSearch = new Input(By.xpath("//input[contains(@class,'fast-search__input')]"));

    private static final String iframeSearch = "//iframe[contains(@class,'modal-iframe')]";

    private static final Input inputSearchActive = new Input(By.cssSelector(".search__tabs-item_active"));

    public static WebDriver driver;

    public OnlinerScreen() {
        driver = WebDriverManager.currentSession().getWebDriver();
    }

    public void clickOnSearch() {
        inputSearch.click();
    }

    public String getCursorSeacrh() {
        return inputSearch.getAttribute("placeholder");
    }

    public void typeInSearch(String textTyped) {
        inputSearch.setTextAndSendKeys(textTyped, Keys.ENTER);
    }

    public void switchToDefaultContent() {
        Wait.functionPassed(() -> driver.switchTo().defaultContent());
    }

    private void switchToIframe(String xPathFrame) {
        Wait.functionPassed(() -> Wait.frameAvailableAndSwitchToIt(By.xpath(xPathFrame)));
    }

    public void swithOnIFrameFieldSearching() {
        switchToDefaultContent();
        switchToIframe(iframeSearch);
    }

    public String getTextInSearchTab() {
        return inputSearchActive.getText();
    }
}
